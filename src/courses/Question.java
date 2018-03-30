package courses;

public class Question {
	
	private String name;
	private String text;
	private int point;
	private String image;
	private Option[] options;
	
	//konstruktor
	public Question(int optionCount, String name, String text){
		this.options = new Option[optionCount]; //pocet moznosti
		this.name = name;
		this.text = text;
	}
	
	public Question(int optionCount, String name, String text, int point, String image){
		this.options = new Option[optionCount]; //pocet moznosti
		this.name = name;
		this.text = text;
		this.point = point;
		this.image = image;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getText() {
		return this.text;
	}
	
	public int getPoint() {
		return this.point;
	}
	
	public String getImage() {
		return this.image;
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
