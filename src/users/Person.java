package users;

import courses.*;
import message.*;

/**
 * <b>Person Interface</b> <br>
 * 
 * Interface of the Person
 *
 * @author Tomáš Junas
 * @version 1.0
 */
public interface Person {
	
	/**
	 * Sets information of the Person
	 * 
	 * @param name name of the Person
	 * @param surname surname of the Person
	 * @param gender gender of the Person
	 * @param age age of the Person
	 * @param position position of the Person
	 */
	void setInfo(String name, String surname, String gender, int age, String position);
	
	/**
	 * Returns username of the Person
	 * 
	 * @return username
	 */
	String getUsername();
	
	/**
	 * Sets username of the Person
	 * 
	 * @param username username of the Person
	 */
	void setUsername(String username);
	
	/**
	 * Returns password of the Person
	 * 
	 * @return password
	 */
	String getPassword();
	
	/**
	 * Sets password of the Person
	 * 
	 * @param password password of the Person
	 */
	void setPassword(String password);
	
	/**
	 * Returns name of the Person
	 * 
	 * @return name
	 */
	String getName();
	
	/**
	 * Returns surname of the Person
	 * 
	 * @return surname
	 */
	String getSurname();
	
	/**
	 * Returns gender of the Person
	 * 
	 * @return gender
	 */
	String getGender();
	
	/**
	 * Returns age of the Person
	 * 
	 * @return age
	 */
	int getAge();
	
	/**
	 * Returns position of the Person
	 * 
	 * @return position
	 */
	String getPosition();	
	
	boolean isAdmin();
	
	/**
	 * Returns course from array on position
	 * 
	 * @param position position
	 * @return course[position]
	 */
	Course getCourse(int position);
	
	/**
	 * Returns length of course array
	 * 
	 * @return course.length
	 */
	int getCourseLength();
	
	/**
	 * Returns course index, find by string
	 * 
	 * @param find string
	 * @return course index
	 */
	int getCourseIndex(String find);	
	
	/**
	 * Sets course on position in array
	 * 
	 * @param position position
	 * @param course course
	 */
	void setCourse(int position, Course course); 
	
	/**
	 * Sets number of courses
	 * 
	 * @param pocet number of courses
	 */
	void setCourseAll(int pocet); 
	
	/**
	 * Returns global message
	 * 
	 * @return global message
	 */
	TimeMessage getGlobalMessage(); 
	
	/**
	 * Sets global message
	 * 
	 * @param message global message
	 */
	void setGlobalMessage(TimeMessage message); 
}
