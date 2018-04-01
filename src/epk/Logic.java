package epk;

import java.awt.Desktop;
import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import courses.Course;
import courses.CustomFile;
import courses.Option;
import courses.Question;
import courses.Test;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import message.ManualTimeMessage;
import message.TimeMessage;
import users.*;

public class Logic {
	
	//db s usermi
	public static ArrayList<Person> users = new ArrayList<Person>();
	//prihlaseny user
	public static Person loggedUser;

	//nacitanie do pola
	public static void loadUsersFileToArray() {	
		//nazov suboru
        String fileName = "./data/users_data/list/users.txt";
        //citane udaje
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
        int userIndex = 0;

        try {
            //citac
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //citaj po riadkoch
            while( (readedUsername = bufferedReader.readLine() ) != null) {
                readedPassword = bufferedReader.readLine();
                readedAdmin = bufferedReader.readLine();;                
                readedAdminNumber = Integer.parseInt(readedAdmin);      
                //pridanie usera               
                if (readedAdminNumber == 0) {
                	//pridaj normalneho
                	users.add(userIndex, new User(readedUsername, readedPassword));
                }
                if (readedAdminNumber == 1) {
                	//pridaj admina
                	users.add(userIndex, new Administrator(readedUsername, readedPassword));
                }
                //citanie dalsich info
                readedName = bufferedReader.readLine();
                readedSurname = bufferedReader.readLine();
                readedGender = bufferedReader.readLine();
                readedAge = bufferedReader.readLine();
                readedAgeNumber = Integer.parseInt(readedAge);
                readedPostition = bufferedReader.readLine();
                //uloz
                users.get(userIndex).setInfo(readedName, readedSurname, readedGender, readedAgeNumber, readedPostition);
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
	
	//zapis do textaku
	public static void writeUsersToFileFromArray() {
        //nazov suboru
        String fileName = "./data/users_data/list/users.txt";
        //zapisuj
        try {
        	//zapisovac
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //zapisuj
            for (int a=0; a<users.size(); a++) {
            	//zapisuj
            	bufferedWriter.write(users.get(a).getUsername());
            	bufferedWriter.newLine();
            	bufferedWriter.write(users.get(a).getPassword());
            	bufferedWriter.newLine();
            	//admin
            	if(users.get(a).isAdmin()) {
            		bufferedWriter.write("1");                	
            	}
            	else {
            		bufferedWriter.write("0");
            	}
            	bufferedWriter.newLine();
            	bufferedWriter.write(users.get(a).getName());
            	bufferedWriter.newLine();
            	bufferedWriter.write(users.get(a).getSurname());
            	bufferedWriter.newLine();
            	bufferedWriter.write(users.get(a).getGender());
            	bufferedWriter.newLine();
            	bufferedWriter.write(String.valueOf(users.get(a).getAge()));
            	bufferedWriter.newLine();
            	bufferedWriter.write(users.get(a).getPosition());
            	if (a < users.size()-1) {
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
	public static boolean userLogin(String loginName, String loginPassword) throws ParseException {	
		for (int a=0; a<users.size(); a++) {			
			if(loginName.equals(users.get(a).getUsername()) && loginPassword.equals(users.get(a).getPassword())  ) {
				if(users.get(a).isAdmin()) {
					loggedUser = new Administrator(users.get(a).getUsername(),users.get(a).getPassword());
				} 
				else {
					loggedUser = new User(users.get(a).getUsername(),users.get(a).getPassword());
				}				
				loggedUser.setInfo(users.get(a).getName(), users.get(a).getSurname(), users.get(a).getGender(), users.get(a).getAge(), users.get(a).getPosition());
				loadMessageFromFile();
				return true;
			}
		}
		return false;
	}
	
	//men heslo
	public static void changePassword(String username, String newPassword ) {
		for (int a=0; a<users.size(); a++) {			
			if(username.equals(users.get(a).getUsername())) {
				users.get(a).setPassword(newPassword);
				//zapis
				writeUsersToFileFromArray();
			}
		}
	}
	
	//find user by name
	public static int findByUsername(String username) {
		for (int a=0; a<users.size(); a++) {			
			if(username.equals(users.get(a).getUsername())) {		
				return a;
			}
		}
		return -1;
	}
	
	//pridanie usera - zapisanie do suboru a nacitanie
	public static void addUser(User newUser) {
        users.add(newUser);
        writeUsersToFileFromArray();
	}	
	
	//citanie courses kuknut este
	public static void loadCoursesList() {	
		//nazov suboru
        String fileName = "./data/courses/courses.txt";
        //citane udaje
        String readedLine = null;
        int pocetCourses = 0;
        int CourseIndex = 0;

        try {
            //citac
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //pocet
            readedLine = bufferedReader.readLine();   
            pocetCourses = Integer.parseInt(readedLine);
            loggedUser.setCourseAll(pocetCourses);
            
            //citaj po riadkoch
            while( (readedLine = bufferedReader.readLine() ) != null) {
            	String location = readedLine;
            	//nacitaj veci
            	loggedUser.setCourse(CourseIndex, new Course("c1", "textas"));        	
            	loadCourseMaterial(CourseIndex, readedLine);           	
            	loadCourseTest(CourseIndex, readedLine);
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
        //citane udaje
        String readedLine = null;
        String TestName = null;
        String TestText = null;
        
        String QPocet = null;
        String QName = null;
        String QText = null;
        String QImage = null;
        String QPoint = null;
        
        String OPocet = null; 
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
            	int QPointNumber = Integer.parseInt(QPoint);
            	//text otazky
            	QText = bufferedReader.readLine();
            	//obrazok
            	QImage = bufferedReader.readLine();
            	
            	loggedUser.getCourse(position).getTest().setQuestion(QuestionIndex, new Question(OPocetNumber, QName, QText, QPointNumber, QImage));
            	
            	//moznosti            	
            	for(int a=0; a<OPocetNumber; a++) {
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
	
	//otvorenie materialu 
	public static void openFileOnDisk(String name, int position) {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop desktop = Desktop.getDesktop();
				File myFile = new File("./data/courses/" + Logic.loggedUser.getCourse(position).getName() + "/material/documents/" + name);
				desktop.open(myFile);
			}		    
			catch (IOException ex) {
				//chyba
	            System.out.println("Chyba pri otvarani suboru");  
			}
				
		}
	}
	/*
	//load spravy zo suboru
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
            //load do usera
            loadMessageToUser(readedLine);
            //load pref seen
            //docasny takedown cfg
            //loadMessageSeenFromFile(loggedUser.getUsername());
        }
        catch(FileNotFoundException ex) {
        	//nenasiel sa subor
            System.out.println("Nepodarilo sa otvorit subor: " + fileName);                
        }
        catch(IOException ex) {
        	//chyba pri citani
            System.out.println("Chyba pri citani suboru: " + fileName);  
        }
	}*/
	/*
	//load spravy do usera
	public static void loadMessageToUser(String message) {
		loggedUser.setGlobalMessage(message);
	}
	
	//save spravy do suboru
	public static void writeMessageToFile(String message) {
        //nazov suboru
        String fileName = "./data/message/message.txt";
        //zapisuj
        try {
        	//zapisovac
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //zapisuj
            bufferedWriter.write(message);
            //zavri 
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Chyba pri zapisovani do suboru: " + fileName);
        }
	}*/
	/*
	//kukni ci ju videl
	public static void loadMessageSeenFromFile(String username) {
		//
		String fileName = "./data/users_data/history/" + username  +"/closedMessage.txt";
        //citane udaje
        String readedLine = null;
        int cislo = 0;
        boolean seen = false;
        try {
            //citac
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            readedLine = bufferedReader.readLine();                           
            //zavri
            bufferedReader.close();  
            
            cislo = Integer.parseInt(readedLine);           
            if (cislo == 0) {
            	seen = false;
            }
            else {
            	seen = true;
            }
            
            loggedUser.getGlobalMessage().setSeen(seen);
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
	*/
	/*
	//save ci videl
	public static void writeMessageSeenToFile(String username, boolean seen) {
        //nazov suboru
		String fileName = "./data/users_data/history/" + username  +"/closedMessage.txt";
        //zapisuj
        try {
        	//zapisovac
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //zapisuj
            String message = "0"; //default 0
            if (seen) {
            	message = "1";
            }
            else {
            	message = "0";
            }
            bufferedWriter.write(message);
            //zavri 
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Chyba pri zapisovani do suboru: " + fileName);
        }
	}*/
	
	//narvi selected do pola podla pos
	public static void saveTestSelected(ArrayList<ComboBox> combos, int position) {
		for (int a = 0; a < loggedUser.getCourse(position).getTest().getQuestionsLength(); a++) {
			if (combos.get(a).getSelectionModel().getSelectedItem()==null) {
				//nic nezaskrkol
				//System.out.println("nic");
			}
			else {
				String combosel = combos.get(a).getSelectionModel().getSelectedItem().toString();
				for (int b = 0; b < loggedUser.getCourse(position).getTest().getQuestion(a).getOptionsLength(); b++) {
					//prehlavadaj moznosti
					if (loggedUser.getCourse(position).getTest().getQuestion(a).getOption(b).getText().equals(combosel)) {
						loggedUser.getCourse(position).getTest().getQuestion(a).getOption(b).setSelected(true);
					}
				}
			}
		}
	}
	
	//max body
	public static void saveMaxPoints(int position) {
		int maxPoints = 0;
		for (int a = 0; a < loggedUser.getCourse(position).getTest().getQuestionsLength(); a++) {
			maxPoints += loggedUser.getCourse(position).getTest().getQuestion(a).getPoint();				
		}
		loggedUser.getCourse(position).getTest().setMaxPoints(maxPoints);	
	}
	
	//scitaj body
	public static void saveAchievedPoints(int position) {
		int points = 0;
		for (int a = 0; a < loggedUser.getCourse(position).getTest().getQuestionsLength(); a++) {	
			for (int b = 0; b < loggedUser.getCourse(position).getTest().getQuestion(a).getOptionsLength(); b++) {
				//ked je correct a selected
				if( (loggedUser.getCourse(position).getTest().getQuestion(a).getOption(b).getSelected()) && (loggedUser.getCourse(position).getTest().getQuestion(a).getOption(b).getCorrect()) ) {
					points +=loggedUser.getCourse(position).getTest().getQuestion(a).getPoint();
				}
			}
		}
		loggedUser.getCourse(position).getTest().setAchievedPoints(points);	
	}
	
	//nacita spravu zo suboru - globalnu
	public static void loadMessageFromFile() throws ParseException {
		//
		String fileName = "./data/message/message.txt";
        //citane udaje
        String readedSeen = null;
        String readedType = null;
        String readedDate = null;
        String readedMessage = null;
        try {
            //citac
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //readedType = bufferedReader.readLine();    
            readedDate = bufferedReader.readLine();  
            readedMessage = bufferedReader.readLine();  
            readedSeen = bufferedReader.readLine();  
            
            if (readedSeen.equals("$")) {
            	//time
            	TimeMessage message = new TimeMessage(readedMessage);
            	
            	//Date expiration = message.getFormatter().parse(readedDate);
            	SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            	Date expiration = formatter.parse(readedDate);
            	message.setExpiration(expiration);
            	
            	TimeMessage userMessage = loadUserMessageFromFile(loggedUser.getUsername());
            	
            	//rovnake
            	if (userMessage.getMessage().equals(message.getMessage())) {
            		message.setSeen(userMessage.isSeen());
            	}
            	else {
            		writeUserMessageToFile(loggedUser.getUsername(), message);
            	}
            	
            	loggedUser.setGlobalMessage(message);
            }
            else {
            	//manual
            	ManualTimeMessage message = new ManualTimeMessage(readedMessage);
            	DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            	Date expiration = formatter.parse(readedDate);
            	message.setExpiration(expiration);
                
            	if (readedSeen.equals("0")) {
            		message.setSeen(false);
            	} 
            	if (readedSeen.equals("1")) {
            		message.setSeen(true);
            	}
            	TimeMessage userMessage = loadUserMessageFromFile(loggedUser.getUsername());
            	
            	//rovnake
            	if (userMessage.getMessage().equals(message.getMessage())) {
            		message.setSeen(userMessage.isSeen());
            	}
            	else {
            		writeUserMessageToFile(loggedUser.getUsername(), message);
            	}
            	
            	loggedUser.setGlobalMessage((TimeMessage)message);     	
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
	
	//check user msg
	public static TimeMessage loadUserMessageFromFile(String username) throws ParseException {
		//
		String fileName = "./data/users_data/history/" + username + "/closedMessage.txt";
        //citane udaje
        String readedSeen = null;
        String readedType = null;
        String readedDate = null;
        String readedMessage = null;
        try {
            //citac
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //readedType = bufferedReader.readLine();    
            readedDate = bufferedReader.readLine();  
            readedMessage = bufferedReader.readLine();  
            readedSeen = bufferedReader.readLine();  
            
            if (readedSeen.equals("$")) {
            	//time
            	TimeMessage message = new TimeMessage(readedMessage);
            	
            	//Date expiration = message.getFormatter().parse(readedDate);
            	SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.YYYY");
            	Date expiration = formatter.parse(readedDate);
            	message.setExpiration(expiration);
            	
            	//zavri
                bufferedReader.close();
            	return message;            	
            }
            else {
            	//manual
            	ManualTimeMessage message = new ManualTimeMessage(readedMessage);
            	DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            	Date expiration = formatter.parse(readedDate);
            	message.setExpiration(expiration);
                
            	if (readedSeen.equals("0")) {
            		message.setSeen(false);
            	} 
            	if (readedSeen.equals("1")) {
            		message.setSeen(true);
            	}
            	
            	//zavri
                bufferedReader.close();
            	return (TimeMessage)message;
            }
            
        }
        catch(FileNotFoundException ex) {
        	//nenasiel sa subor
            System.out.println("Nepodarilo sa otvorit subor: " + fileName);                
        }
        catch(IOException ex) {
        	//chyba pri citani
            System.out.println("Chyba pri citani suboru: " + fileName);  
        }
		return null;
	}
	
	//zapis global message
	public static void writeMessageToFile(String date, String message, boolean canBeClosed) {
        //nazov suboru
		String fileName = "./data/message/message.txt";
        //zapisuj
        try {
        	//zapisovac
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //zapisuj
            bufferedWriter.write(date);
            bufferedWriter.newLine();
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            String seen = "0";
            if (canBeClosed) {
            	seen = "0";
            }
            else {
            	seen = "$";
            }
            bufferedWriter.write(seen);
            //zavri 
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Chyba pri zapisovani do suboru: " + fileName);
        }
	}
	
	//zapisovanie user message - ked je global ina
	public static void writeUserMessageToFile(String username, TimeMessage message) {
        //nazov suboru
		String fileName = "./data/users_data/history/" + username  +"/closedMessage.txt";
        //zapisuj
        try {
        	//zapisovac
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //zapisuj
            bufferedWriter.write(message.getFormattedExpiration());
            bufferedWriter.newLine();
            bufferedWriter.write(message.getMessage());
            bufferedWriter.newLine();
            String seen = "0";
            if (message.isSeen()) {
            	seen = "1";
            }
            else {
            	seen = "0";
            }
            bufferedWriter.write(seen);
            //zavri 
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Chyba pri zapisovani do suboru: " + fileName);
        }
	}
}
