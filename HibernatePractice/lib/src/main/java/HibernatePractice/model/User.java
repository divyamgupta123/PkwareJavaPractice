package HibernatePractice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user",schema = "public")
public class User {
	
	@Id
	@Column(name = "email", nullable = false, unique = true)
	String email;
	
	@Column(name = "firstname", nullable = false, unique = true)
	String firstName;
	
	@Column(name = "lastname", nullable = true, unique = true)
	String lastName;
	
	@Column(name = "password", nullable = false, unique = true)
	String password;
	
	public User() {
		super();
	}

	public User(String email, String firstName, String lastName, String password) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

 	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
