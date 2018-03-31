package users;

import courses.*;
import epk.*;
import message.*;

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
	
	//konstuktor
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.name = "";
		this.surname = "";
		this.gender = "";
		this.age = 0;
		this.position = "";
	}
	
	//set info
	public void setInfo(String name, String surname, String gender, int age, String position) {
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.age = age;
		this.position = position;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getPosition() {
		return this.position;
	}
	
	public boolean isAdmin() {
		return false;
	}	
	
	public Course getCourse(int position) {
		return this.course[position];
	}
	
	public int getCourseLength() {
		return this.course.length;
	}
	
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
	
	public void setCourse(int position, Course course) {
		this.course[position] = course;
	}
	
	public void setCourseAll(int pocet) {
		this.course	= new Course[pocet];
	}
	
	public TimeMessage getGlobalMessage() {
		return this.globalMessage;
	}
	
	public void setGlobalMessage(TimeMessage message) {
		this.globalMessage = message;
	}

}

