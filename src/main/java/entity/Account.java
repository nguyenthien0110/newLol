package entity;

public class Account {
	private String username;
	private String password;
	private int visitor;
	private boolean admin;

	public Account() {
	}

	public Account(String username, String password, int visitor, boolean admin) {
		super();
		this.username = username;
		this.password = password;
		this.visitor = visitor;
		this.admin = admin;
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

	public int getVisitor() {
		return visitor;
	}

	public void setVisitor(int visitor) {
		this.visitor = visitor;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", visitor=" + visitor + ", admin=" + admin
				+ ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword() + ", getVisitor()="
				+ getVisitor() + ", isAdmin()=" + isAdmin() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
