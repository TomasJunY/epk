package courses;

/**
 * <b>Test Object</b> <br>
 * 
 * Object is storing data about test
 * 
 * @author Tomáš Junas
 * @version 1.0
 */
public class Test {

	private String name;
	private String text;
	private Question[] questions;	
	private int maxPoints;
	private int achievedPoints;
	
	/**
	 * Constructor
	 * 
	 * @param questionCount number of questions
	 * @param name name of the Test
	 * @param text text of the Test
	 */
	public Test(int questionCount, String name, String text){
		this.questions = new Question[questionCount]; //pocet otazok
		this.name = name;
		this.text = text;
	}
	
	/**
	 * Sets information about Test
	 * 
	 * @param name name of the Test
	 * @param text text of the Test
	 */
	public void setInfo(String name, String text){
		this.name = name;
		this.text = text;
	}
	
	/**
	 * Returns Test name
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns Test text
	 * 
	 * @return text
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Return all Questions of the Test
	 * 
	 * @return questions
	 */
	public Question[] getAllQuestions() {
		return this.questions;
	}
	
	/**
	 * Returns Question from array on position
	 * 
	 * @param position position in array
	 * @return questions[position]
	 */
	public Question getQuestion(int position) {
		return this.questions[position];
	}
	
	/**
	 * Returns length of Question array
	 * 
	 * @return questions.length
	 */
	public int getQuestionsLength() {
		return this.questions.length;
	}
	
	/**
	 * Sets Question in array on position
	 * @param position position in array
	 * @param questions question
	 */
	public void setQuestion(int position, Question questions) {
		this.questions[position] = questions;
	}
	
	/**
	 * Returns maximum points 
	 *  
	 * @return maxPoints
	 */
	public int getMaxPoints() {
		return this.maxPoints;
	}
	
	/**
	 * Sets maximum points 
	 * 
	 * @param maxPoints maximum points 
	 */
	public void setMaxPoints(int maxPoints) {
		this.maxPoints = maxPoints;
	}
	
	/**
	 * Returns achieved points
	 * 
	 * @return achievedPoints
	 */
	public int getAchievedPoints() {
		return this.achievedPoints;
	}
	
	/**
	 * Sets achievedPoints
	 * @param achievedPoints achievedPoints
	 */
	public void setAchievedPoints(int achievedPoints) {
		this.achievedPoints = achievedPoints;
	}
}
