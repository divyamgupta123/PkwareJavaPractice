package HibernatePractice.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import HibernatePractice.model.User;

public class ManageUser {

	public boolean addUser(SessionFactory factory, String firstName, String lastName, String email, String password) {
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
	public List<User> getAllUsers(SessionFactory factory) {
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

	public boolean updateUser(SessionFactory factory, User user, HashMap<String, String> mp) {
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

	public boolean deleteUser(SessionFactory factory, User user) {
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

	public void viewUserDetails(User user) {
		System.out.println();
		System.out.println("User email - " + user.getEmail());
		System.out.println("User first name - " + user.getFirstName());
		System.out.println("User last name - " + user.getLastName());
		System.out.println("User password - " + user.getPassword());
	}

	public User getUser(SessionFactory factory, String email) {
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

	public boolean updateUserHelper(SessionFactory factory,Scanner scan) {

		System.out.println();
		HashMap<String, String> mp = new HashMap<>();
		String email;
		System.out.print("Enter email of the user to be updated - ");
		email = scan.next();
		User user = getUser(factory, email);
		if (user == null) {
			System.out.println("User do not exist");
			scan.close();
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

		return updateUser(factory, user, mp);
	}

	public boolean addUserHelper(SessionFactory factory,Scanner scan) {

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

		String hashValue = HashPassword.getPasswordHash(password);

		boolean isSuccess = addUser(factory, firstName, lastName, email, hashValue);
		return isSuccess;

	}
	
	public User isUserRegistered(SessionFactory factory, String email) {
		User user = getUser(factory, email);
		if (user == null) {
			System.out.println("User do not exist");
			return null;
		}
		return user;
	}

}
