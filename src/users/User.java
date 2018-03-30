package users;

import courses.Course;
import courses.Option;
import courses.Test;
import epk.GlobalMessage;

public class User {
	
	protected String username;
	protected String password;
	protected String name;
	protected String surname;
	protected String gender;
	protected int age;
	protected String position;
	protected Course course[];	
	protected GlobalMessage globalMessage;
	
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
	public void setInfo(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	public void setInfo(String name, String surname, String gender, int age, String position) {
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.age = age;
		this.position = position;
	}
	public void setPassword(String password){
		this.password = password;
	}
	//send info
	public String printLoginInfo() {
		String message;
		message = "meno: " + this.username + ", heslo: " + this.password;
		return message;
	}
	public String printFullInfo() {
		String message;
		message = "meno: " + this.name + ", priezvisko: " + this.surname + ", pohlavie: " + this.gender + ", vek: " + this.age + ", pozicia: " + this.position;
		return message;
	}
	public String getUsername() {
		return this.username;
	}
	public String getPassword() {
		return this.password;
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
	
	public GlobalMessage getMessage() {
		return this.globalMessage;
	}
	
	public void setMessage(String message) {
		//
		this.globalMessage = new GlobalMessage(message);
	}

}

