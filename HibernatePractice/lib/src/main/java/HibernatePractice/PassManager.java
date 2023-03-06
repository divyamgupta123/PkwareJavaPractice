package HibernatePractice;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import HibernatePractice.model.User;
import HibernatePractice.model.WebsiteAccount;
import HibernatePractice.util.HashPassword;
import HibernatePractice.util.ManageUser;
import HibernatePractice.util.ManageWebsiteAccount;

public class PassManager {
	private static SessionFactory factory;

	private static String userPassword = null;

	private static void initialiseHibernate() {
		try {

			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			Properties props = new Properties();
			try (InputStream resourceStream = loader.getResourceAsStream("application.properties")) {
				props.load(resourceStream);
			}

			Configuration configuration = new Configuration();
			configuration.setProperties(props);
			configuration.configure("hibernate.cfg.xml");
			System.out.println(" ----------- Configuration File loaded successfully ----------- ");

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			System.out.println(" ----------- Service Registry Created ----------- ");

			factory = configuration.buildSessionFactory(serviceRegistry);

		} catch (Exception e) {
			System.err.println("Failed to create factory object");
			e.printStackTrace();
		}
	}

	private static void userLoggedHelper(User user, Scanner scan) {
		ManageWebsiteAccount manageWA = new ManageWebsiteAccount();
		int option = -1;
		do {
			System.out.println();
			System.out.println("Enter 1 to add a website account");
			System.out.println("Enter 2 to update an account");
			System.out.println("Enter 3 to delete an account");
			System.out.println("Enter 4 to view all accounts");
			System.out.println("Enter 5 to view password of an account");
			System.out.println("Enter 6 to logout");
			System.out.print("Enter option - ");

			option = scan.nextInt();

			switch (option) {
			case 1: {
				System.out.println();
				
				boolean isSuccess = manageWA.addWebsiteAccountHelper(factory, user, userPassword,scan);
				if (!isSuccess) {
					System.out.println("Account not added. Try again");
				}
				break;
			}

			case 2: {
				boolean isSuccess = manageWA.updateWebsiteAccountHelper(factory, scan);
				if (!isSuccess) {
					System.out.println("User not updated. Try again");
				}
				break;
			}

			case 3: {
				int id;
				System.out.print("Enter id of the acocunt to be deleted - ");
				id = scan.nextInt();
				
				WebsiteAccount acc = manageWA.isAccountExist(factory, id);
				if (acc == null) break;

				if(!acc.getUser().getEmail().equals(user.getEmail())) {
					System.out.println("Wrong id entered !!!");
					break;
				}

				boolean isSuccess = manageWA.deleteWebsiteAccount(factory, acc);
				if (!isSuccess) {
					System.out.println("Account not deleted. Try again");
				}
				break;
				
			}
			case 4:
				List<WebsiteAccount> accList = manageWA.getAllWebsiteAccounts(factory, user);
				if (accList.size() == 0) {
					System.out.println("No acoounts added!!!");
					break;
				}
				for (WebsiteAccount acc : accList) {
					System.out.println("Total accounts - " + accList.size());
					manageWA.viewAccountDetails(acc);
				}
				break;

			case 5:
				int id;
				System.out.print("Enter id of the account - ");
				id = scan.nextInt();
				
				WebsiteAccount acc = manageWA.isAccountExist(factory, id);
				if (acc == null) break;
				
				try {
					String passOrig = manageWA.decryptPassword(factory, userPassword, acc);
					manageWA.viewAccountDetailsWithPass(acc, passOrig);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 6:
				System.out.println("User logged out successfully !!!");
				user = null;
				break;

			default:
				System.out.println("Wrong option entered");
			}

		} while (user != null);
	}

	public static void main(String[] args) {

		initialiseHibernate();

		ManageUser manageUser = new ManageUser();
		Scanner scan = new Scanner(System.in);

		int option = -1;

		System.out.println("-------------- Program Started --------------");

		do {
			System.out.println();
			System.out.println("Enter 1 to add a user");
			System.out.println("Enter 2 to update a user");
			System.out.println("Enter 3 to delete a user");
			System.out.println("Enter 4 to view a user's details");
			System.out.println("Enter 5 to view all users details");
			System.out.println("Enter 6 to login ");
			System.out.println("Enter 7 to exit program");
			System.out.print("Enter option - ");
			option = scan.nextInt();

			switch (option) {
			case 1: {
				System.out.println();
				boolean isSuccess = manageUser.addUserHelper(factory, scan);
				if (!isSuccess) {
					System.out.println("User not added. Try again");
				}
				break;
			}

			case 2: {
				boolean isSuccess = manageUser.updateUserHelper(factory, scan);
				if (!isSuccess) {
					System.out.println("User not updated. Try again");
				}
				break;
			}

			case 3: {
				String email;
				System.out.print("Enter email of the user to be deleted - ");
				email = scan.next();
				
				User user = manageUser.isUserRegistered(factory, email);
				if (user == null) break;

				boolean isSuccess = manageUser.deleteUser(factory, user);
				if (!isSuccess) {
					System.out.println("User not deleted. Try again");
				}
				break;
			}

			case 4: {
				String email;
				System.out.print("Enter email of the user - ");
				email = scan.next();

				User user = manageUser.isUserRegistered(factory, email);
				if (user == null) break;

				manageUser.viewUserDetails(user);
				break;
			}
			case 5:
				List<User> usersList = manageUser.getAllUsers(factory);
				if (usersList.size() == 0) {
					System.out.println("No users registered!!!");
					break;
				}
				for (User user : usersList) {
					System.out.println("Total registered users - " + usersList.size());
					manageUser.viewUserDetails(user);
				}
				break;

			case 6: {
				String email;
				System.out.print("Enter email - ");
				email = scan.next();

				User user = manageUser.isUserRegistered(factory, email);
				if (user == null) break;

				System.out.print("Enter password - ");
				userPassword = scan.next();

				String hashPass = HashPassword.getPasswordHash(userPassword);

				if (user.getPassword().equals(hashPass)) {
					System.out.println("User logged in");
					userLoggedHelper(user, scan);
				} else
					System.out.println("Wrong Password. Try again");

				break;
			}
			case 7:
				System.out.println("-------------- Program Exit --------------");
				break;
			default:
				System.out.println("Enter correct option");
			}

		} while (option != 7);

		scan.close();
	}

}
