package epk;

import java.awt.Desktop;
import java.io.*;
import java.nio.*;
import java.nio.file.Files;

import courses.Course;
import courses.CustomFile;
import courses.Option;
import courses.Question;
import courses.Test;
import users.*;

public class Logic {
	
	//db s usermi
	public static User users[] = new User[getFileUserCount()];
	//prihlaseny user
	public static User loggedUser;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("haha");
		
		//int pocet = getFileUserCount();
		//System.out.println("pocet: " + pocet);
		//loadUsersFileToArray();
		//writeUsersToFileFromArray();
		//System.out.println(userLogin("admin", "heslo"));
		//addUser("uz2", "heslo", "0", "meno", "priz", "muz", "25", "asfa");
		//changePassword("admin", "new");
		//System.out.println(users.length);
		//loadCoursesList();
	}
	
	//pocet uzivatelov s subore
	public static int getFileUserCount() {
		//nazov suboru
        String fileName = "./data/users_data/list/users.txt";
        //citrany riadok
        String readedLine = null;        
        //pocty
        int lineCount = 0;
        int userCount = 0;
        //citaj
        try {
        	//citac
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);   
                       
            //citaj po riadkoch
            while( (readedLine = bufferedReader.readLine() ) != null) {
                //System.out.println(readedLine);
                lineCount++;
            } 
            //vysledok
            userCount = lineCount/8;          
            //zavri
            bufferedReader.close();       
        }
        catch(FileNotFoundException ex) {
        	//nenasiel sa subor
            System.out.println("Nepodarilo sa otvorit subor: " + fileName);                
        }
        catch(IOException ex) {
        	//chyba pri citani
            System.out.println("Chyba pri citani suboru: " + fileName);  
        }
        //vrat vysledok
        return userCount;
	}
	
	//nacitanie do pola
	public static void loadUsersFileToArray() {	
		//nazov suboru
        String fileName = "./data/users_data/list/users.txt";
        //citrane udaje
        String readedUsername = null;
        String readedPassword = null;
        String readedAdmin = null;
        String readedName = null;
        String readedSurname = null;
        String readedGender = null;
        String readedAge = null;
        String readedPostition = null;
        
        int readedAdminNumber = 0;
        int readedAgeNumber = 0;
        
        //
        int userIndex = 0;

        try {
            //citac
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //readedUsername = bufferedReader.readLine();  
            
            //citaj po riadkoch
            while( (readedUsername = bufferedReader.readLine() ) != null) {
                readedPassword = bufferedReader.readLine();
                readedAdmin = bufferedReader.readLine();;                
                readedAdminNumber = Integer.parseInt(readedAdmin);      
                //pridanie usera               
                if (readedAdminNumber == 0) {
                	//pridaj normalneho
                	users[userIndex] = new User(readedUsername, readedPassword);
                }
                if (readedAdminNumber == 1) {
                	//pridaj admina
                	users[userIndex] = new Administrator(readedUsername, readedPassword);
                }
                //citanie dalsich info
                readedName = bufferedReader.readLine();
                readedSurname = bufferedReader.readLine();
                readedGender = bufferedReader.readLine();
                readedAge = bufferedReader.readLine();
                readedAgeNumber = Integer.parseInt(readedAge);
                readedPostition = bufferedReader.readLine();
                //uloz
                users[userIndex].setInfo(readedName, readedSurname, readedGender, readedAgeNumber, readedPostition);
                //zvacsi inderx
                userIndex++;
            }   
            //zavri
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
        	//nenasiel sa subor
            System.out.println("Nepodarilo sa otvorit subor: " + fileName);                
        }
        catch(IOException ex) {
        	//chyba pri citani
            System.out.println("Chyba pri citani suboru: " + fileName);  
        }
	}
	
	//zapis do textaku - zatial ineho
	public static void writeUsersToFileFromArray() {
        //nazov suboru
        String fileName = "./data/users_data/list/users.txt";
        //zapisuj
        try {
        	//zapisovac
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //zapisuj
            for (int a=0; a<users.length; a++) {
            	//zapisuj
            	bufferedWriter.write(users[a].getUsername());
            	bufferedWriter.newLine();
            	bufferedWriter.write(users[a].getPassword());
            	bufferedWriter.newLine();
            	//admin
            	if(users[a].isAdmin()) {
            		bufferedWriter.write("1");                	
            	}
            	else {
            		bufferedWriter.write("0");
            	}
            	bufferedWriter.newLine();
            	bufferedWriter.write(users[a].getName());
            	bufferedWriter.newLine();
            	bufferedWriter.write(users[a].getSurname());
            	bufferedWriter.newLine();
            	bufferedWriter.write(users[a].getGender());
            	bufferedWriter.newLine();
            	bufferedWriter.write(String.valueOf(users[a].getAge()));
            	bufferedWriter.newLine();
            	bufferedWriter.write(users[a].getPosition());
            	if (a < users.length-1) {
            		bufferedWriter.newLine();
            	}
            }
            //zavri 
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Chyba pri zapisovani do suboru: " + fileName);
        }
	}
	
	//odhlasi alebo vrati false ked ne
	public static boolean userLogoff() {	
		loggedUser = null;
		if (loggedUser == null) {
			return true;
		}
		else {		
			return false;
		}
	}
	
	//prihlasi alebo vrati false ked ne
	public static boolean userLogin(String loginName, String loginPassword) {	
		for (int a=0; a<users.length; a++) {			
			if(loginName.equals(users[a].getUsername()) && loginPassword.equals(users[a].getPassword())  ) {
				if(users[a].isAdmin()) {
					//
					loggedUser = new Administrator(users[a].getUsername(),users[a].getPassword());
				} 
				else {
					//
					loggedUser = new User(users[a].getUsername(),users[a].getPassword());
				}
				//loggedUser = new User(users[a].getUsername(),users[a].getPassword());
				
				loggedUser.setInfo(users[a].getName(), users[a].getSurname(), users[a].getGender(), users[a].getAge(), users[a].getPosition());
				loadMessageFromFile();
				return true;
			}
		}
		return false;
	}
	
	//men heslo
	public static void changePassword(String username, String newPassword ) {
		for (int a=0; a<users.length; a++) {			
			if(username.equals(users[a].getUsername())) {
				//loggedUser = new User(users[a].getUsername(),users[a].getPassword());
				//loggedUser.setInfo(users[a].getName(), users[a].getSurname(), users[a].getGender(), users[a].getAge(), users[a].getPosition());			
				
				//zmen heslo v poli
				users[a].setPassword(newPassword);
				//zapis
				writeUsersToFileFromArray();
				//odhla
				userLogoff();
			}
		}
	}
	
	//pridanie usera - zapisanie do suboru a nacitanie
	public static void addUser(String addedUsername, String addedPassword, String addedAdmin, String addedName, String addedSurname, String addedGender, String addedAge, String addedPosition) {
        //nazov suboru
        String fileName = "./data/users_data/list/users.txt";
        //zapisuj
        try {
        	//zapisovac
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //zapisuj povodne
            for (int a=0; a<users.length; a++) {
            	//zapisuj
            	bufferedWriter.write(users[a].getUsername());
            	bufferedWriter.newLine();
            	bufferedWriter.write(users[a].getPassword());
            	bufferedWriter.newLine();
            	//admin
            	if(users[a].isAdmin()) {
            		bufferedWriter.write("1");                	
            	}
            	else {
            		bufferedWriter.write("0");
            	}
            	bufferedWriter.newLine();
            	bufferedWriter.write(users[a].getName());
            	bufferedWriter.newLine();
            	bufferedWriter.write(users[a].getSurname());
            	bufferedWriter.newLine();
            	bufferedWriter.write(users[a].getGender());
            	bufferedWriter.newLine();
            	bufferedWriter.write(String.valueOf(users[a].getAge()));
            	bufferedWriter.newLine();
            	bufferedWriter.write(users[a].getPosition());
            	bufferedWriter.newLine();
            }
            //pridaj nove
            bufferedWriter.write(addedUsername);
        	bufferedWriter.newLine();
        	bufferedWriter.write(addedPassword);
        	bufferedWriter.newLine();
        	bufferedWriter.write(addedAdmin);
        	bufferedWriter.newLine();
        	bufferedWriter.write(addedName);
        	bufferedWriter.newLine();
        	bufferedWriter.write(addedSurname);
        	bufferedWriter.newLine();
        	bufferedWriter.write(addedGender);
        	bufferedWriter.newLine();
        	bufferedWriter.write(addedAge);
        	bufferedWriter.newLine();
        	bufferedWriter.write(addedPosition);
            //zavri
        	bufferedWriter.flush();
            bufferedWriter.close();
            
        }
        catch(IOException ex) {
            System.out.println("Chyba pri zapisovani do suboru: " + fileName);
        }
        //reset uziv
        users = null;
        users = new User[getFileUserCount()];
        //loadni
        loadUsersFileToArray();
	}	
	
	
	//citanie courses
	public static void loadCoursesList() {	
		//nazov suboru
        String fileName = "./data/courses/courses.txt";
        //loggedUser.getCourse(0);
        //citane udaje
        String readedLine = null;
        int pocetCourses = 0;
        int CourseIndex = 0;

        try {
            //citac
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //readedLine = bufferedReader.readLine();
            //pocet
            readedLine = bufferedReader.readLine();   
            pocetCourses = Integer.parseInt(readedLine);
            loggedUser.setCourseAll(pocetCourses);
            
            //citaj po riadkoch
            while( (readedLine = bufferedReader.readLine() ) != null) {
            	//rob
            	String location = readedLine;
            	//nacitaj veci
            	//course[0] = new Course("c1", "textas");
            	loggedUser.setCourse(CourseIndex, new Course("c1", "textas"));
            	
            	loadCourseMaterial(CourseIndex, readedLine);
            	
            	loadCourseTest(CourseIndex, readedLine);
            	System.out.println(readedLine);
            	//zvacsi index
            	CourseIndex++;            
            }   
            //zavri
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
        	//nenasiel sa subor
            System.out.println("Nepodarilo sa otvorit subor: " + fileName);                
        }
        catch(IOException ex) {
        	//chyba pri citani
            System.out.println("Chyba pri citani suboru: " + fileName);  
        }
	}
	
	//citanie course - material
	public static void loadCourseMaterial(int position, String location) {	
		//nazov suboru
        String fileName = "./data/courses/" + location + "/material/course.txt";

        //citane udaje
        String CourseName = null;
        String readedLine = null;
        String CourseText = null;

        try {
            //citac
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
                      
            CourseName = bufferedReader.readLine();
            CourseText = bufferedReader.readLine();
            
            while( (readedLine = bufferedReader.readLine() ) != null) {
            	CourseText = CourseText + "\n" + readedLine;           
            } 
            
            loggedUser.setCourse(position, new Course(CourseName, CourseText));
            
            bufferedReader.close();   
            
            //load custom files links
            loadCourseMaterialDoc(position, location);
        }
        catch(FileNotFoundException ex) {
        	//nenasiel sa subor
            System.out.println("Nepodarilo sa otvorit subor: " + fileName);                
        }
        catch(IOException ex) {
        	//chyba pri citani
            System.out.println("Chyba pri citani suboru: " + fileName);  
        }
	}
	
	//citanie course - material - link
	public static void loadCourseMaterialDoc(int position, String location) {	
		//nazov suboru
        String fileName = "./data/courses/" + location + "/material/links.txt";

        //citane udaje
        String readedLine = null;
        String pocetLink = null;
        int pocetLinkNumber = 0;
        int LinkIndex = 0;

        try {
            //citac
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
                      
            pocetLink = bufferedReader.readLine();
            pocetLinkNumber = Integer.parseInt(pocetLink);
            
            loggedUser.getCourse(position).setFileAll(pocetLinkNumber);
            
            while( (readedLine = bufferedReader.readLine() ) != null) {
            	//uloz
            	loggedUser.getCourse(position).setFile(LinkIndex, new CustomFile(readedLine, "./data/courses/" + location + "/material/documents/"));   
            	loggedUser.getCourse(position).getFile(LinkIndex).setPath("./data/courses/" + location + "/material/documents/" + readedLine);
            	//zvacsi index
            	LinkIndex++;            
            }   
            //zavri
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
        	//nenasiel sa subor
            System.out.println("Nepodarilo sa otvorit subor: " + fileName);                
        }
        catch(IOException ex) {
        	//chyba pri citani
            System.out.println("Chyba pri citani suboru: " + fileName);  
        }
	}
	
	//citanie course - test
	public static void loadCourseTest(int position, String location) {	
		//nazov suboru
        String fileName = "./data/courses/" + location + "/test/test.txt";
        //loggedUser.getCourse(0);
        //citane udaje
        String readedLine = null;
        String TestName = null;
        String TestText = null;
        
        String QPocet = null;
        String QName = null;
        String QText = null;
        String QImage = null;
        String QPoint = null;
        
        String OPocet = null; //moznosti
        String OText = null;
        String OCorrect = null;
        
        int QPocetNumber = 0;
        int OPocetNumber = 0; 
        int OCorrectNumber = 0;
        
        boolean OCorrectBool = false;
        
        int QuestionIndex = 0;

        try {
            //citac
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //readedLine = bufferedReader.readLine();  
            
            TestName = bufferedReader.readLine();
            TestText = bufferedReader.readLine();
            QPocet = bufferedReader.readLine();
            QPocetNumber = Integer.parseInt(QPocet);
            
            loggedUser.getCourse(position).setTest(new Test(QPocetNumber, TestName, TestText));
            //citaj po riadkoch
            while( (QName = bufferedReader.readLine() ) != null) {
            	//nazov otazky
            	
            	//pocet moznosti
            	OPocet = bufferedReader.readLine();
            	OPocetNumber = Integer.parseInt(OPocet);
            	//body
            	QPoint = bufferedReader.readLine();
            	//text otazky
            	QText = bufferedReader.readLine();
            	//obrazok
            	QImage = bufferedReader.readLine();
            	
            	loggedUser.getCourse(position).getTest().setQuestion(QuestionIndex, new Question(OPocetNumber, QName, QText));
            	
            	//moznosti            	
            	for(int a=0; a<OPocetNumber; a++) {
            		//
            		OText = bufferedReader.readLine();
            		OCorrect = bufferedReader.readLine();
            		OCorrectNumber = Integer.parseInt(OCorrect);
            		if (OCorrectNumber==1) {
            			OCorrectBool = true;
            		}
            		else {
            			OCorrectBool = false;
            		}
            		
            		loggedUser.getCourse(position).getTest().getQuestion(QuestionIndex).setOption(a, new Option(OText, OCorrectBool));
            	}            	
            	//zvacsi index
            	QuestionIndex++;            
            }   
            //zavri
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
        	//nenasiel sa subor
            System.out.println("Nepodarilo sa otvorit subor: " + fileName);                
        }
        catch(IOException ex) {
        	//chyba pri citani
            System.out.println("Chyba pri citani suboru: " + fileName);  
        }
	}
	
	public static void openFileOnDisk(String name) {
		//
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop desktop = Desktop.getDesktop();
				File myFile = new File("./data/courses/1_vodicak/material/documents/" + name);
				//File myFile = new File(path);
				desktop.open(myFile);
			}		    
			catch (IOException ex) {
				//chyba
	            System.out.println("Chyba pri otvarani suboru");  
			}
				
		}
	}
	
	public static void loadMessageFromFile() {
		//
		String fileName = "./data/message/message.txt";
        //citane udaje
        String readedLine = null;
        try {
            //citac
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            readedLine = bufferedReader.readLine();                           
            //zavri
            bufferedReader.close();  
            
            loadMessageToUser(readedLine);
        }
        catch(FileNotFoundException ex) {
        	//nenasiel sa subor
            System.out.println("Nepodarilo sa otvorit subor: " + fileName);                
        }
        catch(IOException ex) {
        	//chyba pri citani
            System.out.println("Chyba pri citani suboru: " + fileName);  
        }
	}
	
	public static void loadMessageToUser(String message) {
		loggedUser.setGlobalMessage(message);
	}
	
}
