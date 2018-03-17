package epk;

import java.io.*;

import users.User;

public class Logic {
	
	public User users[] = new User[getFileUserCount()];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("haha");
		
		int pocet = getFileUserCount();
		System.out.println("pocet: " + pocet);
		loadFileToArray();
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

        try {
        	//citac
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //citaj po riadkoch
            while( (readedLine = bufferedReader.readLine() ) != null) {
                //System.out.println(readedLine);
                lineCount++;
            }   
            
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
        
        return userCount;
	}
	
	//nacitanie do pola
	public static void loadFileToArray() {
		
		//nazov suboru
        String fileName = "./files/users.txt";

        //citrany riadok
        String readedLine = null;
        
        //
        int userIndex = 0;

        try {
            //citac
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //citaj po riadkoch
            while( (readedLine = bufferedReader.readLine() ) != null) {
                System.out.println(readedLine);
                readedLine = bufferedReader.readLine();
                
                
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

}
