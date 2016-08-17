package entities;

import com.harmonia.qa.Entities.BaseEntity;

/**
 * Entity representing a user in the application
 *
 * @author jfoley
 */
public class User extends BaseEntity {

	/**
	 * Auto-generated serial ID
	 */
	private static final long serialVersionUID = -4132322928684069716L;

	private String username;

	private String password;

	private String email;

	private int kudos;

	public boolean isAdmin;

	private User() {
	}

	public User(boolean admin) {
		this.isAdmin = admin;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getKudos() {
		return this.kudos;
	}

	public void setKudos(int kudos) {
		this.kudos = kudos;
	}

	public void addKudos(int i) {
		this.kudos += i;
	}

	public void subtractKudos(int i) {
		this.kudos -= i;
	}

	public boolean isAdmin() {
		return this.isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
