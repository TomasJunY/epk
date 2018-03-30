package courses;

public class Test {

	private String name;
	private String text;
	private Question[] questions;
	
	private int maxPoints;
	private int achievedPoints;
	
	//konstruktor
	public Test(int questionCount, String name, String text){
		this.questions = new Question[questionCount]; //pocet otazok
		this.name = name;
		this.text = text;
	}
	
	public void setInfo(String name, String text){
		this.name = name;
		this.text = text;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getText() {
		return this.text;
	}
	
	public Question[] getAllQuestions() {
		return this.questions;
	}
	
	public Question getQuestion(int position) {
		return this.questions[position];
	}
	
	public int getQuestionsLength() {
		return this.questions.length;
	}
	
	public void setQuestion(int position, Question questions) {
		this.questions[position] = questions;
	}
	
	public int getMaxPoints() {
		return this.maxPoints;
	}
	
	public void setMaxPoints(int maxPoints) {
		this.maxPoints = maxPoints;
	}
	
	public int getAchievedPoints() {
		return this.achievedPoints;
	}
	
	public void setAchievedPoints(int achievedPoints) {
		this.achievedPoints = achievedPoints;
	}
}
