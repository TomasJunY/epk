package courses;

public class Option {
	
	public String text;
	public boolean correct;
	public boolean selected;
	
	//konstruktor
	public Option(String text, boolean correct) {
		this.text = text;
		this.correct = correct;
		this.selected = false;
	}
	
}
