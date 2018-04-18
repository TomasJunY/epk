package courses;

/**
 * <b>Test Object</b> <br>
 * 
 * Object is storing data about Test
 * 
 * @author Tomas Junas
 * @version 1.0
 */
public class Test {

	/**
	 * name of the Test
	 */
	private String name;
	
	/**
	 * text of the Test
	 */
	private String text;
	
	/**
	 * Questions of the Test
	 */
	private Question[] questions;	
	
	/**
	 * maximum points 
	 */
	private int maxPoints;
	
	/**
	 * achieved points
	 */
	private int achievedPoints;
	
	/**
	 * Constructor
	 * 
	 * @param questionCount number of Questions
	 * @param name name of the Test
	 * @param text text of the Test
	 */
	public Test(int questionCount, String name, String text){
		this.questions = new Question[questionCount];
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
	 * Returns length of Questions array
	 * 
	 * @return questions.length
	 */
	public int getQuestionsLength() {
		return this.questions.length;
	}
	
	/**
	 * Sets Question in array on position
	 * @param position position in array
	 * @param question question
	 */
	public void setQuestion(int position, Question question) {
		this.questions[position] = question;
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
