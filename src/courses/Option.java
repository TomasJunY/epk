package courses;

public class Option {
	
	private String text;
	private boolean correct;
	private boolean selected;
	
	//konstruktor
	public Option(String text, boolean correct) {
		this.text = text;
		this.correct = correct;
		this.selected = false;
	}
	
	public String getText() {
		return this.text;
	}
	
	public boolean getCorrect() {
		return this.correct;
	}
	
	public boolean getSelected() {
		return this.selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
