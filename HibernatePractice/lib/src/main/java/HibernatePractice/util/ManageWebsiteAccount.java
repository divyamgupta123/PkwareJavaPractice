package HibernatePractice.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import HibernatePractice.model.User;
import HibernatePractice.model.WebsiteAccount;

public class ManageWebsiteAccount {

	public boolean addWebsiteAccount(SessionFactory factory, String websiteName, String email, String username,
			String password, byte[] ivByte, User user) {
		Session session = factory.openSession();
		Transaction trx = null;

		try {
			trx = session.beginTransaction();
			WebsiteAccount websiteAcc = new WebsiteAccount(websiteName, email, username, password, ivByte, user);
			session.save(websiteAcc);
			trx.commit();
			System.out.println("Account added successfully!!!");
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
	public List<WebsiteAccount> getAllWebsiteAccounts(SessionFactory factory, User user) {
		Session session = factory.openSession();
		List<WebsiteAccount> accountsList = null;
		try {
			String hql = "FROM WebsiteAccount WHERE useremail=:useremail";
			Query query = session.createQuery(hql);
			query.setParameter("useremail", user.getEmail());
			accountsList = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return accountsList;
	}

	public boolean updateWebsiteAccount(SessionFactory factory, WebsiteAccount acc, HashMap<String, String> mp) {
		Session session = factory.openSession();
		Transaction trx = null;
		try {
			trx = session.beginTransaction();
			for (Map.Entry<String, String> itr : mp.entrySet()) {
				switch (itr.getKey()) {
				case "wn":
					acc.setWebsiteName(itr.getValue());
					break;
				case "un":
					acc.setUsername(itr.getValue());
					break;
				case "em":
					acc.setEmail(itr.getValue());
					break;
				case "ps":
					acc.setPassword(itr.getValue());
					break;
				}
			}
			session.update(acc);
			trx.commit();
			System.out.println("Account updated successfully!!!");
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

	public boolean deleteWebsiteAccount(SessionFactory factory, WebsiteAccount acc) {
		Session session = factory.openSession();
		Transaction trx = null;
		try {
			trx = session.beginTransaction();
			session.delete(acc);
			trx.commit();
			System.out.println("Account deleted successfully!!!");
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

	public void viewAccountDetails(WebsiteAccount acc) {
		System.out.println();
		System.out.println("Id - " + acc.getId());
		System.out.println("Website name - " + acc.getWebsiteName());
		System.out.println("Email - " + acc.getEmail());
		System.out.println("User name - " + acc.getUsername());
		System.out.println("Password - " + acc.getPassword());
	}

	public void viewAccountDetailsWithPass(WebsiteAccount acc, String password) {
		System.out.println();
		System.out.println("Id - " + acc.getId());
		System.out.println("Website name - " + acc.getWebsiteName());
		System.out.println("Email - " + acc.getEmail());
		System.out.println("User name - " + acc.getUsername());
		System.out.println("Password - " + password);
	}

	public WebsiteAccount getWebsiteAcc(SessionFactory factory, int id) {
		WebsiteAccount acc = null;
		Session session = factory.openSession();
		try {
			acc = (WebsiteAccount) session.get(WebsiteAccount.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return acc;
	}

	public boolean updateWebsiteAccountHelper(SessionFactory factory, Scanner scan) {

		System.out.println();
		HashMap<String, String> mp = new HashMap<>();

		int id;
		System.out.print("Enter id of the account to be updated - ");
		id = scan.nextInt();

		WebsiteAccount acc = getWebsiteAcc(factory, id);
		if (acc == null) {
			System.out.println("Account do not exist");
			scan.close();
			return false;
		}

		int option2 = -1;
		do {
			System.out.println();
			System.out.println("Enter 1 to update website name");
			System.out.println("Enter 2 to update email");
			System.out.println("Enter 3 to update user name");
			System.out.println("Enter 4 to update password");
			System.out.println("Enter 5 to continue");
			System.out.print("Enter option - ");
			option2 = scan.nextInt();
			switch (option2) {
			case 1:
				System.out.print("Enter new website name - ");
				String newWn = scan.next();
				mp.put("wn", newWn);
				break;

			case 2:
				System.out.print("Enter new email - ");
				String email = scan.next();
				mp.put("em", email);
				break;

			case 3:
				System.out.print("Enter new username - ");
				String username = scan.next();
				mp.put("un", username);
				break;

			case 4:
				System.out.print("Enter new password - ");
				String pass = scan.next();
				mp.put("ps", pass);
				break;

			case 5:
				break;
			default:
				System.out.println("Enter correct option");
				break;
			}

		} while (option2 != 5);
		return updateWebsiteAccount(factory, acc, mp);
	}

	public boolean addWebsiteAccountHelper(SessionFactory factory, User user, String userPassword, Scanner scan) {

		String websiteName;
		String email;
		String username;
		String password;

		System.out.print("Enter website name - ");
		websiteName = scan.next();

		System.out.print("Enter email - ");
		email = scan.next();

		System.out.print("Enter user name - ");
		username = scan.next();

		System.out.print("Enter password - ");
		password = scan.next();

		try {
			SecretKey key = PasswordEncrpytDecrypt.getKeyFromPassword(userPassword);

			byte[] ivByte = PasswordEncrpytDecrypt.getIvByte();
			IvParameterSpec iv = PasswordEncrpytDecrypt.generateIv(ivByte);
			String encryptPass = PasswordEncrpytDecrypt.encrypt(password, key, iv);

			boolean isSuccess = addWebsiteAccount(factory, websiteName, email, username, encryptPass, ivByte, user);
			return isSuccess;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String decryptPassword(SessionFactory factory, String userPassword, WebsiteAccount acc) {
		try {
			SecretKey key = PasswordEncrpytDecrypt.getKeyFromPassword(userPassword);
			byte[] ivBytes = acc.getIv();
			IvParameterSpec iv = PasswordEncrpytDecrypt.generateIv(ivBytes);
			String passOrig = PasswordEncrpytDecrypt.decrypt(acc.getPassword(), key, iv);
			return passOrig;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public WebsiteAccount isAccountExist(SessionFactory factory, int id) {
		WebsiteAccount acc = getWebsiteAcc(factory, id);
		if (acc == null) {
			System.out.println("Account do not exist");
			return null;
		}
		return acc;
	}
}
