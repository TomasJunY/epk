package epk;

import java.io.*;
import java.nio.*;
import java.nio.file.Files;

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
	}
	
	//pocet uzivatelov s subore
	public static int getFileUserCount() {
		//nazov suboru
        String fileName = "./files/users.txt";
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
        String fileName = "./files/users.txt";
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
        String fileName = "./files/users.txt";
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
				loggedUser = new User(users[a].getUsername(),users[a].getPassword());
				loggedUser.setInfo(users[a].getName(), users[a].getSurname(), users[a].getGender(), users[a].getAge(), users[a].getPosition());
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
        String fileName = "./files/users.txt";
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

}
