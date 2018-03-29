package courses;

public class Course {
	
	private String name;
	private String text;
	private Test test;
	private boolean finished;
	
	//konstruktor
	public Course(String name, String text){
		this.name = name;
		this.text = text;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getText() {
		return this.text;
	}
	
	public Test getTest() {
		return this.test;
	}
	
	public void setTest(Test test) {
		this.test = test;
	}
	
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	public boolean isFinished() {
		return this.finished;
	}
}
