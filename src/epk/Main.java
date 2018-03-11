package epk;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User users[] = new User[2];
		
		users[0] = new User("tomas", "heslo");
		users[1] = new Administrator("admin", "heslo");
		
		String message;
		
		message = ("meno: " + users[0].username + " heslo: " + users[0].password);		
		System.out.println(message);
		
		message = ("meno: " + users[1].username + " heslo: " + users[1].password);		
		System.out.println(message);
	}

}
