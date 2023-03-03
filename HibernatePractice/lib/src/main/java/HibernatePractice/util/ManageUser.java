package HibernatePractice.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import HibernatePractice.model.User;

public class ManageUser {

	private static SessionFactory factory;

	public boolean addUser(String firstName, String lastName, String email, String password) {
		Session session = factory.openSession();
		Transaction trx = null;

		try {
			trx = session.beginTransaction();
			User user = new User(email, firstName, lastName, password);
			session.save(user);
			trx.commit();
			System.out.println("User registered successfully!!!");
		} catch (Exception e) {
			if (trx != null)
				trx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		Session session = factory.openSession();
		List<User> userList = null;
		try {
			userList = session.createQuery("FROM User").list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return userList;
	}

	public boolean updateUser(User user, String email, HashMap<String, String> mp) {
		Session session = factory.openSession();
		Transaction trx = null;
		try {
			trx = session.beginTransaction();
			for (Map.Entry<String, String> itr : mp.entrySet()) {
				switch (itr.getKey()) {
				case "fn":
					user.setFirstName(itr.getValue());
					break;
				case "ln":
					user.setLastName(itr.getValue());
					break;
				}
			}
			session.update(user);
			trx.commit();
			System.out.println("User updated successfully!!!");
		} catch (Exception e) {
			if (trx != null)
				trx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	public boolean deleteUser(User user, String email) {
		Session session = factory.openSession();
		Transaction trx = null;
		try {
			trx = session.beginTransaction();
			session.delete(user);
			trx.commit();
			System.out.println("User deleted successfully!!!");
		} catch (Exception e) {
			if (trx != null)
				trx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	private void viewUserDetails(User user) {
		System.out.println();
		System.out.println("User email - " + user.getEmail());
		System.out.println("User first name - " + user.getFirstName());
		System.out.println("User last name - " + user.getLastName());
		System.out.println("User password - " + user.getPassword());
	}

	private User getUser(String email) {
		User user = null;
		Session session = factory.openSession();
		try {
			user = (User) session.get(User.class, email);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	private boolean updateUserHelper(Scanner scan, ManageUser manageUser) {
		System.out.println();
		HashMap<String, String> mp = new HashMap<>();
		String email;
		System.out.print("Enter email of the user to be updated - ");
		email = scan.next();
		User user = manageUser.getUser(email);
		if (user == null) {
			System.out.println("User do not exist");
			return false;
		}

		int option2 = -1;
		do {
			System.out.println();
			System.out.println("Enter 1 to update first name");
			System.out.println("Enter 2 to update last name");
			System.out.println("Enter 3 to continue");
			System.out.print("Enter option - ");
			option2 = scan.nextInt();
			switch (option2) {
			case 1:
				System.out.print("Enter new first name - ");
				String newFn = scan.next();
				mp.put("fn", newFn);
				break;
			case 2:
				System.out.print("Enter new last name - ");
				String newLn = scan.next();
				mp.put("ln", newLn);
				break;
			case 3:
				break;
			default:
				System.out.println("Enter correct option");
				break;
			}

		} while (option2 != 3);

		return manageUser.updateUser(user, email, mp);
	}

	private boolean addUserHelper(Scanner scan, ManageUser manageUser) {

		String firstName;
		String lastName;
		String email;
		String password;

		System.out.print("Enter first name - ");
		firstName = scan.next();

		System.out.print("Enter last name - ");
		lastName = scan.next();

		System.out.print("Enter registered email - ");
		email = scan.next();

		System.out.print("Enter password - ");
		password = scan.next();

		String hashValue = HashPassword.get_SHA_512_SecurePassword(password);

		boolean isSuccess = manageUser.addUser(firstName, lastName, email, hashValue);
		return isSuccess;

	}

	public static void main(String[] args) {
		try {
			Configuration configuration = new Configuration();
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
			System.out.println("Enter 6 to verify a user");
			System.out.println("Enter 7 to exit program");
			System.out.print("Enter option - ");
			option = scan.nextInt();

			switch (option) {
			case 1: {
				System.out.println();
				boolean isSuccess = manageUser.addUserHelper(scan, manageUser);
				if (!isSuccess) {
					System.out.println("User not added. Try again");
				}
				break;
			}

			case 2: {
				boolean isSuccess = manageUser.updateUserHelper(scan, manageUser);
				if (!isSuccess) {
					System.out.println("User not updated. Try again");
				}
				break;
			}

			case 3: {
				String email;
				System.out.print("Enter email of the user to be deleted - ");
				email = scan.next();
				User user = manageUser.getUser(email);
				if (user == null) {
					System.out.println("User do not exist");
					break;
				}

				boolean isSuccess = manageUser.deleteUser(user, email);
				if (!isSuccess) {
					System.out.println("User not deleted. Try again");
				}
				break;
			}

			case 4: {
				String email;
				System.out.print("Enter email of the user - ");
				email = scan.next();

				User user = manageUser.getUser(email);

				if (user == null) {
					System.out.println("User do not exist");
					break;
				}

				manageUser.viewUserDetails(user);
				break;
			}
			case 5:
				List<User> usersList = manageUser.getAllUsers();
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
				String email, password;
				System.out.print("Enter email - ");
				email = scan.next();

				User user = manageUser.getUser(email);
				if (user == null) {
					System.out.println("User do not exist!!!");
					break;
				}

				System.out.print("Enter password - ");
				password = scan.next();

				String hashPass = HashPassword.get_SHA_512_SecurePassword(password);

				if (user.getPassword().equals(hashPass))
					System.out.println("User verified successfully");
				else
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
