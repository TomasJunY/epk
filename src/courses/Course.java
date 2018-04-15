package courses;

/**
 * <b>Course Object</b> <br>
 * 
 * Object is storing data about course
 * 
 * @author Tomáš Junas
 * @version 1.0
 */
public class Course {
	
	private String name;
	private String text;
	private CustomFile[] file;
	private Test test;
	private boolean finished;
	
	/**
	 * Constructor
	 * 
	 * @param name course name
	 * @param text course text
	 */
	public Course(String name, String text){
		this.name = name;
		this.text = text;
	}
	
	/**
	 * Returns course name
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns course text
	 * 
	 * @return text
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Returns course test
	 * 
	 * @return test
	 */
	public Test getTest() {
		return this.test;
	}
	
	/**
	 * Sets test
	 * 
	 * @param test test
	 */
	public void setTest(Test test) {
		this.test = test;
	}
	
	/**
	 * Sets finished course
	 * 
	 * @param finished finished boolean
	 */
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	/**
	 * Returns finished course
	 * 
	 * @return finished
	 */
	public boolean isFinished() {
		return this.finished;
	}
	
	/**
	 * Returns not finished course
	 * 
	 * @return !finished
	 */
	public boolean isNotFinished() {
		return !this.finished;
	}
	
	/**
	 * Returns custom file form array in position
	 * @param position position in array
	 * @return file[position]
	 */
	public CustomFile getFile(int position) {
		return this.file[position];
	}
	
	/**
	 * Returns length of File array
	 * 
	 * @return file.length
	 */
	public int getFileLength() {
		return this.file.length;
	}
	
	/**
	 * Sets File on position in array
	 * @param position position in array
	 * @param file file
	 */
	public void setFile(int position, CustomFile file) {
		this.file[position] = file;
	}
	
	/**
	 * Sets length of File array
	 * @param pocet
	 */
	public void setFileAll(int pocet) {
		this.file = new CustomFile[pocet];
	}
	
}
