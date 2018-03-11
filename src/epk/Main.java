package epk;

import users.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User users[] = new User[2];
		
		users[0] = new User("tomas", "heslo");
		users[1] = new Administrator("admin", "heslo");
		
			
		System.out.println(users[0].printLoginInfo());
		System.out.println(users[1].printLoginInfo());
	}

}
