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
	
	/**
	 * Returns position
	 * @return position
	 */
	String getPosition();	
	
	boolean isAdmin();
	
	/**
	 * Returns course on position
	 * @param position position
	 * @return course[position]
	 */
	Course getCourse(int position);
	
	/**
	 * Returns course length
	 * @return course length
	 */
	int getCourseLength();
	
	/**
	 * Returns course index
	 * @param find string
	 * @return course index
	 */
	int getCourseIndex(String find);	
	
	/**
	 * Sets course on position in array
	 * @param position position
	 * @param course course
	 */
	void setCourse(int position, Course course); 
	
	/**
	 * Sets number of courses
	 * @param pocet number of courses
	 */
	void setCourseAll(int pocet); 
	
	/**
	 * Returns global message
	 * @return global message
	 */
	TimeMessage getGlobalMessage(); 
	
	/**
	 * Sets global message
	 * @param message global message
	 */
	void setGlobalMessage(TimeMessage message); 
}
