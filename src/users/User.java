package users;

import courses.*;
import message.*;

/**
 * <b>User Object</b> <br>
 * 
 * Object is storing data about User <br>
 * 
 * @author Tomas Junas
 * @version 1.0
 */
public class User implements Person {
	
	private String username;
	private String password;
	private String name;
	private String surname;
	private String gender;
	private int age;
	private String position;
	private Course course[];	
	private TimeMessage globalMessage;
	
	/**
	 * Constructor
	 * 
	 * @param username username of the User
	 * @param password password of the User
	 */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.name = "";
		this.surname = "";
		this.gender = "";
		this.age = 0;
		this.position = "";
	}
	
	/**
	 * Sets information of the User
	 * 
	 * @param name name of the User
	 * @param surname surname of the User
	 * @param gender gender of the User
	 * @param age age of the User
	 * @param position position of the User
	 */
	public void setInfo(String name, String surname, String gender, int age, String position) {
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.age = age;
		this.position = position;
	}
	
	/**
	 * Returns username of the User
	 * 
	 * @return username
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Sets username of the User
	 * 
	 * @param username username of the User
	 */
	public void setUsername(String username){
		this.username = username;
	}
	
	/**
	 * Returns password of the User
	 * 
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Sets password of the User
	 * 
	 * @param password password of the User
	 */
	public void setPassword(String password){
		this.password = password;
	}
	
	/**
	 * Returns name of the User
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns surname of the User
	 * 
	 * @return surname
	 */
	public String getSurname() {
		return this.surname;
	}
	
	/**
	 * Returns gender of the User
	 * 
	 * @return gender
	 */
	public String getGender() {
		return this.gender;
	}
	
	/**
	 * Returns age of the User
	 * 
	 * @return age
	 */
	public int getAge() {
		return this.age;
	}
	
	/**
	 * Returns position of the User
	 * 
	 * @return position
	 */
	public String getPosition() {
		return this.position;
	}
	
	public boolean isAdmin() {
		return false;
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
