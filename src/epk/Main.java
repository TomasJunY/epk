package epk;

import users.*;
import courses.*;

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
		
		System.out.println("-----------------");
		
		//testy
		Test tests[] = new Test[2];
		//test1
		tests[0] = new Test(3,"test1","toto je prvy test"); 		
			//otazka 1
			tests[0].questions[0] = new Question(4, "otazka1:", "text otazky1");
				//moznosti
				tests[0].questions[0].options[0] = new Option("moznost1", false);
				tests[0].questions[0].options[1] = new Option("moznost2", false);
				tests[0].questions[0].options[2] = new Option("moznost3", false);
				tests[0].questions[0].options[3] = new Option("moznost4 spravna", true);
			//otazka 2
			tests[0].questions[1] = new Question(4, "otazka2:", "text otazky2");
				//moznosti
				tests[0].questions[1].options[0] = new Option("moznost1 spravna", true);
				tests[0].questions[1].options[1] = new Option("moznost2", false);
				tests[0].questions[1].options[2] = new Option("moznost3", false);
				tests[0].questions[1].options[3] = new Option("moznost4", false);
			//otazka 3
			tests[0].questions[2] = new Question(4, "otazka3:", "text otazky3");
				//moznosti
				tests[0].questions[2].options[0] = new Option("moznost1", false);
				tests[0].questions[2].options[1] = new Option("moznost2 spravna", true);
				tests[0].questions[2].options[2] = new Option("moznost3", false);
				tests[0].questions[2].options[3] = new Option("moznost4", false);
		
		//test2
		tests[1] = new Test(3,"test2","toto je druhy test"); 		
			//otazka 1
			tests[1].questions[0] = new Question(4, "otazka1:", "text otazky1");
				//moznosti
				tests[1].questions[0].options[0] = new Option("moznost1", false);
				tests[1].questions[0].options[1] = new Option("moznost2", false);
				tests[1].questions[0].options[2] = new Option("moznost3", false);
				tests[1].questions[0].options[3] = new Option("moznost4 spravna", true);
			//otazka 2
			tests[1].questions[1] = new Question(4, "otazka2:", "text otazky2");
				//moznosti
				tests[1].questions[1].options[0] = new Option("moznost1 spravna", true);
				tests[1].questions[1].options[1] = new Option("moznost2", false);
				tests[1].questions[1].options[2] = new Option("moznost3", false);
				tests[1].questions[1].options[3] = new Option("moznost4", false);
			//otazka 3
			tests[1].questions[2] = new Question(4, "otazka3:", "text otazky3");
				//moznosti
				tests[1].questions[2].options[0] = new Option("moznost1", false);
				tests[1].questions[2].options[1] = new Option("moznost2 spravna", true);
				tests[1].questions[2].options[2] = new Option("moznost3", false);
				tests[1].questions[2].options[3] = new Option("moznost4", false);
		
		/*
		//vypis
		//testy
		for(int a = 0; a<2; a++) {
			System.out.println("nazov testu: " + tests[a].name);
			System.out.println("text testu: " + tests[a].text);
			System.out.println("-----------------");
			//otazky
			for(int b = 0; b<3; b++) {				
				System.out.println("nazov otazky: " + tests[a].questions[b].name);
				System.out.println("text otazky: " + tests[a].questions[b].text);
				System.out.println("-----------------");
				//moznosti
				for(int c = 0; c<4; c++) {
					//vypis
					System.out.println(tests[a].questions[b].options[c].text + ", hodnota: " + tests[a].questions[b].options[c].correct);				
				}
				System.out.println("-----------------");
			}
			
		}
		*/
		//vypis
		//testy
		for(int a = 0; a<2; a++) {
			System.out.println("nazov testu: " + tests[a].name);
			System.out.println("text testu: " + tests[a].text);
			System.out.println("--------------------------------------------------");
			//otazky
			for(int b = 0; b<3; b++) {				
				System.out.println("	nazov otazky: " + tests[a].questions[b].name);
				System.out.println("	text otazky: " + tests[a].questions[b].text);
				System.out.println("--------------------------------------------------");
				//moznosti
				for(int c = 0; c<4; c++) {
					//vypis
					System.out.println("		" + tests[a].questions[b].options[c].text + ", hodnota: " + tests[a].questions[b].options[c].correct);				
				}
				System.out.println("--------------------------------------------------");
			}
					
		}
	}

}
