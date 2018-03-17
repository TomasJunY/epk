package epk;

import java.io.*;

public class Logic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loadFile();
	}
	
	public static void loadFile() {
		
		// The name of the file to open.
        String fileName = "./files/users.txt";

        // This will reference one line at a time
        String lineReader = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //citaj po riadkoch
            while( (lineReader = bufferedReader.readLine() ) != null) {
                System.out.println(lineReader);
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
