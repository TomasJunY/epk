package users;

public class Administrator extends User {

	public Administrator(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub

	}
	
	public boolean isAdmin() {
		return true;
	}
	
	public User addUser(String addedUsername, String addedPassword, String addedAdmin, String addedName, String addedSurname, String addedGender, int addedAge, String addedPosition) {
		User newUser = new User(addedUsername, addedPassword);
		newUser.setInfo(addedName, addedSurname, addedGender, addedAge, addedPosition);
		return newUser;
	}

}
