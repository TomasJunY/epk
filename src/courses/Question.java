package courses;

public class Question {
	
	public String name;
	public String text;
	public Option[] options;
	
	//konstruktor
	public Question(int optionCount, String name, String text){
		this.options = new Option[optionCount]; //pocet moznosti
		this.name = name;
		this.text = text;
	}

}
