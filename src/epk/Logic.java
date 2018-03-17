package epk;

import java.io.*;
import users.*;

public class Logic {
	
	//db s usermi
	static User users[] = new User[getFileUserCount()];
	//prihlaseny user
	static User loggedUser;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("haha");
		
		//int pocet = getFileUserCount();
		//System.out.println("pocet: " + pocet);
		loadUsersFileToArray();
		writeUsersToFileFromArray();
		System.out.println(userLogin("admin", "heslo"));
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
            System.out.println("nepodarilo sa otvorit subor: " + fileName);                
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
            System.out.println("nepodarilo sa otvorit subor: " + fileName);                
        }
        catch(IOException ex) {
        	//chyba pri citani
            System.out.println("Chyba pri citani suboru: " + fileName);  
        }
	}
	
	//zapis do textaku - zatial ineho
	public static void writeUsersToFileFromArray() {
        //nazov suboru
        String fileName = "./files/users_write.txt";
        //zapisuj
        try {
        	//zapisovac
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //zapisuj
            for (int a=0; a<getFileUserCount(); a++) {
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
            //zavri
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Error writing to file: " + fileName);
        }
	}
	
	//prihlasi alebo vrati false ked ne
	public static boolean userLogin(String loginName, String loginPassword) {	
		for (int a=0; a<getFileUserCount(); a++) {			
			if(loginName.equals(users[a].getUsername())) {
				loggedUser = new User(users[a].getUsername(),users[a].getPassword());
				loggedUser.setInfo(users[a].getName(), users[a].getUsername(), users[a].getGender(), users[a].getAge(), users[a].getPosition());
				return true;
			}
		}
		return false;
	}
}
