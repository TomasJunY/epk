package epk;

import users.*;
import courses.*;
import java.awt.Desktop;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User users[] = new User[2];		
		
		/*
		users[0] = new User("tomas", "heslo");
		users[1] = new Administrator("admin", "heslo");
			
		users[0].setInfo("Tomáš", "Junas", "Muž", 20, "žiadna");
		users[1].setInfo("Tomáš", "Junas");
		
		System.out.println(users[0].printLoginInfo());
		System.out.println(users[0].printFullInfo());
		System.out.println(users[1].printLoginInfo());
		System.out.println(users[1].printFullInfo());
		
		System.out.println("--------------------------------------------------");
		*/
		/*
		 * sauhifw
		
		//testy
		Course course[]	= new Course[2];
		//test1
		course[0] = new Course("c1", "textas");
		course[0].test = new Test(3,"test1","toto je prvy test");
		//tests[0] = new Test(3,"test1","toto je prvy test"); 		
			//otazka 1
			course[0].test.questions[0] = new Question(4, "otazka1:", "text otazky1");
				//moznosti
				course[0].test.questions[0].options[0] = new Option("moznost1", false);
				course[0].test.questions[0].options[1] = new Option("moznost2", false);
				course[0].test.questions[0].options[2] = new Option("moznost3", false);
				course[0].test.questions[0].options[3] = new Option("moznost4 spravna", true);
			//otazka 2
			course[0].test.questions[1] = new Question(4, "otazka2:", "text otazky2");
				//moznosti
				course[0].test.questions[1].options[0] = new Option("moznost1 spravna", true);
				course[0].test.questions[1].options[1] = new Option("moznost2", false);
				course[0].test.questions[1].options[2] = new Option("moznost3", false);
				course[0].test.questions[1].options[3] = new Option("moznost4", false);
			//otazka 3
				course[0].test.questions[2] = new Question(4, "otazka3:", "text otazky3");
				//moznosti
				course[0].test.questions[2].options[0] = new Option("moznost1", false);
				course[0].test.questions[2].options[1] = new Option("moznost2 spravna", true);
				course[0].test.questions[2].options[2] = new Option("moznost3", false);
				course[0].test.questions[2].options[3] = new Option("moznost4", false);
		
		//test2
		course[1] = new Course("c1", "textas");
		course[1].test = new Test(3,"test2","toto je druhy test"); 		
			//otazka 1
			course[1].test.questions[0] = new Question(4, "otazka1:", "text otazky1");
				//moznosti
				course[1].test.questions[0].options[0] = new Option("moznost1", false);
				course[1].test.questions[0].options[1] = new Option("moznost2", false);
				course[1].test.questions[0].options[2] = new Option("moznost3", false);
				course[1].test.questions[0].options[3] = new Option("moznost4 spravna", true);
			//otazka 2
			course[1].test.questions[1] = new Question(4, "otazka2:", "text otazky2");
				//moznosti
				course[1].test.questions[1].options[0] = new Option("moznost1 spravna", true);
				course[1].test.questions[1].options[1] = new Option("moznost2", false);
				course[1].test.questions[1].options[2] = new Option("moznost3", false);
				course[1].test.questions[1].options[3] = new Option("moznost4", false);
			//otazka 3
			course[1].test.questions[2] = new Question(4, "otazka3:", "text otazky3");
				//moznosti
				course[1].test.questions[2].options[0] = new Option("moznost1", false);
				course[1].test.questions[2].options[1] = new Option("moznost2 spravna", true);
				course[1].test.questions[2].options[2] = new Option("moznost3", false);
				course[1].test.questions[2].options[3] = new Option("moznost4", false);
		
		*/
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
				
		/*
		for(int a = 0; a<2; a++) {
			System.out.println("nazov course: " + course[a].name);
			System.out.println("text course: " + course[a].text);
			System.out.println("nazov testu: " + course[a].test.name);
			System.out.println("text testu: " + course[a].test.text);
			System.out.println("--------------------------------------------------");
			//otazky
			for(int b = 0; b<3; b++) {				
				System.out.println("	nazov otazky: " + course[a].test.questions[b].name);
				System.out.println("	text otazky: " + course[a].test.questions[b].text);
				System.out.println("--------------------------------------------------");
				//moznosti
				for(int c = 0; c<4; c++) {
					//vypis
					System.out.println("		" + course[a].test.questions[b].options[c].text + ", hodnota: " + course[a].test.questions[b].options[c].correct);				
				}
				System.out.println("--------------------------------------------------");
			}
					
		}
		*/
		
		//testy
		Course course[]	= new Course[2];
		//test1
		course[0] = new Course("c1", "textas");
		course[0].setTest(new Test(3,"test1","toto je prvy test"));
		//tests[0] = new Test(3,"test1","toto je prvy test"); 		
			//otazka 1
			course[0].getTest().setQuestion(0, new Question(4, "otazka1:", "text otazky1"));
				//moznosti
				course[0].getTest().getQuestion(0).setOption(0, new Option("moznost1", false));
				course[0].getTest().getQuestion(0).setOption(1, new Option("moznost2", false));
				course[0].getTest().getQuestion(0).setOption(2, new Option("moznost3", false));
				course[0].getTest().getQuestion(0).setOption(3, new Option("moznost4 spravna", true));
			//otazka 2
			course[0].getTest().setQuestion(1, new Question(4, "otazka2:", "text otazky2"));
				//moznosti
				course[0].getTest().getQuestion(1).setOption(0, new Option("moznost1 spravna", true));
				course[0].getTest().getQuestion(1).setOption(1, new Option("moznost2", false));
				course[0].getTest().getQuestion(1).setOption(2, new Option("moznost3", false));
				course[0].getTest().getQuestion(1).setOption(3, new Option("moznost4", false));
			//otazka 3
			course[0].getTest().setQuestion(2, new Question(4, "otazka3:", "text otazky3"));
				//moznosti
				course[0].getTest().getQuestion(2).setOption(0, new Option("moznost1", false));
				course[0].getTest().getQuestion(2).setOption(1, new Option("moznost2 spravna", true));
				course[0].getTest().getQuestion(2).setOption(2, new Option("moznost3", false));
				course[0].getTest().getQuestion(2).setOption(3, new Option("moznost4", false));
		//test2
		course[1] = new Course("c1", "textas");
		course[1].setTest(new Test(3,"test2","toto je druhy test"));	
			//otazka 1
			course[1].getTest().setQuestion(0, new Question(4, "otazka1:", "text otazky1"));
				//moznosti			
				course[1].getTest().getQuestion(0).setOption(0, new Option("moznost1", false));
				course[1].getTest().getQuestion(0).setOption(1, new Option("moznost2", false));
				course[1].getTest().getQuestion(0).setOption(2, new Option("moznost3", false));
				course[1].getTest().getQuestion(0).setOption(3, new Option("moznost4 spravna", true));			
			//otazka 2
			course[1].getTest().setQuestion(1, new Question(4, "otazka2:", "text otazky2"));
				//moznosti			
				course[1].getTest().getQuestion(1).setOption(0, new Option("moznost1 spravna", true));
				course[1].getTest().getQuestion(1).setOption(1, new Option("moznost2", false));
				course[1].getTest().getQuestion(1).setOption(2, new Option("moznost3", false));
				course[1].getTest().getQuestion(1).setOption(3, new Option("moznost4", false));			
			//otazka 3
			course[1].getTest().setQuestion(2, new Question(4, "otazka3:", "text otazky3"));
				//moznosti
				course[1].getTest().getQuestion(2).setOption(0, new Option("moznost1", false));
				course[1].getTest().getQuestion(2).setOption(1, new Option("moznost2 spravna", true));
				course[1].getTest().getQuestion(2).setOption(2, new Option("moznost3", false));
				course[1].getTest().getQuestion(2).setOption(3, new Option("moznost4", false));
				
		for(int a = 0; a<2; a++) {
			System.out.println("nazov course: " + course[a].getName());
			System.out.println("text course: " + course[a].getText());
			System.out.println("nazov testu: " + course[a].getTest().getName());
			System.out.println("text testu: " + course[a].getTest().getText());
			System.out.println("--------------------------------------------------");
			//otazky
			for(int b = 0; b<3; b++) {				
				System.out.println("	nazov otazky: " + course[a].getTest().getQuestion(b).getName());
				System.out.println("	text otazky: " + course[a].getTest().getQuestion(b).getText());
				System.out.println("--------------------------------------------------");
				//moznosti
				for(int c = 0; c<4; c++) {
					//vypis
					System.out.println("		" + course[a].getTest().getQuestion(b).getOption(c).getText() + ", hodnota: " + course[a].getTest().getQuestion(b).getOption(c).getCorrect());				
				}
				System.out.println("--------------------------------------------------");
			}
					
		}
		
		//File directory = new File("../files/users.txt");
		//System.out.println(directory.getAbsolutePath());
		
		/*
		 * otvaranie suboru
		if (Desktop.isDesktopSupported()) {
			 try {
			     Desktop desktop = Desktop.getDesktop();
			     //File myFile = new File("./data/images/splash.png");
			     //"./data/courses/1_vodicak/material/documents/vodicak.docx"
			     File myFile = new File("./data/courses/1_vodicak/material/documents/vodicak.docx");
			     desktop.open(myFile);
			     //desktop.open(new File("./data/users_data/list/users.txt"));
			     } catch (IOException ex) {}
			 }
		*/
	}	

}
