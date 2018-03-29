package courses;

public class Question {
	
	private String name;
	private String text;
	private Option[] options;
	
	//konstruktor
	public Question(int optionCount, String name, String text){
		this.options = new Option[optionCount]; //pocet moznosti
		this.name = name;
		this.text = text;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getText() {
		return this.text;
	}
	
	public Option[] getAllOptions() {
		return this.options;
	}
	
	public Option getOption(int position) {
		return this.options[position];
	}
	
	public int getOptionsLength() {
		return this.options.length;
	}
	
	public void setOption(int position, Option options) {
		this.options[position] = options;
	}

}
