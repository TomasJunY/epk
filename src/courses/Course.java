package courses;

public class Course {
	
	private String name;
	private String text;
	private CustomFile[] file;
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
	
	public boolean isNotFinished() {
		return !this.finished;
	}
	
	public CustomFile getFile(int position) {
		return this.file[position];
	}
	
	public int getFileLength() {
		return this.file.length;
	}
	
	public void setFile(int position, CustomFile file) {
		this.file[position] = file;
	}
	
	public void setFileAll(int pocet) {
		this.file	= new CustomFile[pocet];
	}
	
}
