package courses;

public class Test {

	public String name;
	public String text;
	public Question[] questions;
	
	//konstruktor
	public Test(int questionCount, String name, String text){
		this.questions = new Question[questionCount]; //pocet otazok
		this.name = name;
		this.text = text;
	}
	

}
