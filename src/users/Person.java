package users;

import courses.*;
import epk.*;
import message.*;

public interface Person {
	
	void setInfo(String name, String surname, String gender, int age, String position);
	
	/**
	 * Returns username
	 * @return username
	 */
	String getUsername();
	
	/**
	 * Sets username
	 * @param username username
	 */
	void setUsername(String username);
	
	/**
	 * Returns password
	 * @return password
	 */
	String getPassword();
	
	/**
	 * Sets password
	 * @param pasword password
	 */
	void setPassword(String password);
	
	/**
	 * Returns name
	 * @return name
	 */
	String getName();
	
	/**
	 * Returns surname
	 * @return surname
	 */
	String getSurname();
	
	/**
	 * Returns gender
	 * @return gender
	 */
	String getGender();
	
	/**
	 * Returns age
	 * @return age
	 */
	int getAge();
	
	String getPosition();	
	
	/**
	 * Returns admin
	 * @return admin
	 */
	boolean isAdmin();
	
	Course getCourse(int position);
	
	int getCourseLength();
	
	int getCourseIndex(String find);	
	
	void setCourse(int position, Course course); 
	
	void setCourseAll(int pocet); 
	
	public TimeMessage getGlobalMessage(); 
	
	public void setGlobalMessage(TimeMessage message); 
}
