package users;

import courses.*;
import message.*;

/**
 * <b>Administrator Object</b> <br>
 * 
 * Object is storing data about Administrator <br>
 * 
 * @author Tomas Junas
 * @version 1.0
 */
public class Administrator implements Person {
	
	/**
	 * username of the Administrator
	 */
	private String username;
	
	/**
	 * password of the Administrator
	 */
	private String password;
	
	/**
	 * name of the Administrator
	 */
	private String name;
	
	/**
	 * surname of the Administrator
	 */
	private String surname;
	
	/**
	 * gender of the Administrator
	 */
	private String gender;
	
	/**
	 * age of the Administrator
	 */
	private int age;
	
	/**
	 * position of the Administrator
	 */
	private String position;
	
	/**
	 * courses of the Administrator
	 */
	private Course course[];	
	
	/**
	 * Message of the Administrator
	 */
	private TimeMessage globalMessage;
	
	/**
	 * Constructor
	 * 
	 * @param username username of the Administrator
	 * @param password password of the Administrator
	 */
	public Administrator(String username, String password) {
		this.username = username;
		this.password = password;
		this.name = "";
		this.surname = "";
		this.gender = "";
		this.age = 0;
		this.position = "";
	}
	
	/**
	 * Sets information of the Administrator
	 * 
	 * @param name name of the Administrator
	 * @param surname surname of the Administrator
	 * @param gender gender of the Administrator
	 * @param age age of the Administrator
	 * @param position position of the Administrator
	 */
	public void setInfo(String name, String surname, String gender, int age, String position) {
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.age = age;
		this.position = position;
	}
	
	/**
	 * Returns username of the Administrator
	 * 
	 * @return username
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Sets username of the Administrator
	 * 
	 * @param username username of the Administrator
	 */
	public void setUsername(String username){
		this.username = username;
	}
	
	/**
	 * Returns password of the Administrator
	 * 
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Sets password of the Administrator
	 * 
	 * @param password password of the Administrator
	 */
	public void setPassword(String password){
		this.password = password;
	}
	
	/**
	 * Returns name of the Administrator
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns surname of the Administrator
	 * 
	 * @return surname
	 */
	public String getSurname() {
		return this.surname;
	}
	
	/**
	 * Returns gender of the Administrator
	 * 
	 * @return gender
	 */
	public String getGender() {
		return this.gender;
	}
	
	/**
	 * Returns age of the Administrator
	 * 
	 * @return age
	 */
	public int getAge() {
		return this.age;
	}
	
	/**
	 * Returns position of the Administrator
	 * 
	 * @return position
	 */
	public String getPosition() {
		return this.position;
	}	
	
	/**
	 * Returns Course from array on position
	 * 
	 * @param position position
	 * @return course[position]
	 */
	public Course getCourse(int position) {
		return this.course[position];
	}
	
	/**
	 * Returns length of Course array
	 * 
	 * @return course.length
	 */
	public int getCourseLength() {
		return this.course.length;
	}
	
	/**
	 * Returns Course index, find by string
	 * 
	 * @param find string
	 * @return index
	 */
	public int getCourseIndex(String find) {
		int index = -1;
		for (int a = 0; a < this.course.length ; a++) {
			 if(this.getCourse(a).getName().equals(find)) {
				 index = a;
				 break;
			 }			
		}
		return index;
	}
	
	/**
	 * Sets Course on position in array
	 * 
	 * @param position position
	 * @param course Course
	 */
	public void setCourse(int position, Course course) {
		this.course[position] = course;
	}
	
	/**
	 * Sets number of Courses
	 * 
	 * @param pocet number of Courses
	 */
	public void setCourseAll(int pocet) {
		this.course	= new Course[pocet];
	}
	
	/**
	 * Returns global message
	 * 
	 * @return global message
	 */
	public TimeMessage getGlobalMessage() {
		return this.globalMessage;
	}
	
	/**
	 * Sets global message
	 * 
	 * @param message global message
	 */
	public void setGlobalMessage(TimeMessage message) {
		this.globalMessage = message;
	}
	
}
