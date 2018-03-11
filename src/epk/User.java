package epk;

public class User {
	
	protected String username;
	protected String password;
	protected String name;
	protected String surname;
	protected String gender;
	protected int age;
	protected String position;
	
	//konstuktor
	public User(String username, String password) {
		this.username = username;
		this.password = password;
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

}

