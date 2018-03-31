package users;

import courses.*;
import epk.*;

interface Person {
	
	void setInfo(String name, String surname, String gender, int age, String position);
	
	String getUsername();
	
	void setUsername(String username);
	
	String getPassword();
	
	void setPassword(String password);
	
	String getName();
	
	String getSurname();
	
	String getGender();
	
	int getAge();
	
	String getPosition();
	
	
	
	//boolean isAdmin();
	
	Course getCourse(int position);
	
	int getCourseLength();
	
	int getCourseIndex(String find);	
	
	void setCourse(int position, Course course); 
	
	void setCourseAll(int pocet); 
	
	GlobalMessage getGlobalMessage(); 
	
	void setGlobalMessage(String message); 
}
