package epk;

import users.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User users[] = new User[2];
		
		users[0] = new User("tomas", "heslo");
		users[1] = new Administrator("admin", "heslo");
			
		users[0].setInfo("Tomáš", "Junas", "Muž", 20, "žiadna");
		users[1].setInfo("Tomáš", "Junas");
		
		System.out.println(users[0].printLoginInfo());
		System.out.println(users[0].printFullInfo());
		System.out.println(users[1].printLoginInfo());
		System.out.println(users[1].printFullInfo());
		
	}

}
