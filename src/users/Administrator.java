package users;

public class Administrator extends User {

	public Administrator(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub

	}
	
	public boolean isAdmin() {
		return true;
	}

}
