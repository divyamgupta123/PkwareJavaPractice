package HibernatePractice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "websiteaccount", schema = "public")
public class WebsiteAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "websitename", nullable = false)
	private String websiteName;
	
	@Column(name = "email", nullable = true)
	private String email;
	
	@Column(name = "username", nullable = true)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "iv", nullable = false)
	private byte[] iv;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "useremail",nullable = false)
	private User user;
	
	public WebsiteAccount() {
		super();
	}
	
	public WebsiteAccount(String websiteName, String email, String username, String password, byte[] iv,User user) {
		super();
		this.websiteName = websiteName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.iv = iv;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public byte[] getIv() {
		return iv;
	}

	public void setIv(byte[] iv) {
		this.iv = iv;
	}

	public String getWebsiteName() {
		return websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
