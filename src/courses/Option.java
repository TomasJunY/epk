package courses;

/**
 * <b>Option Object</b> <br>
 * 
 * Object is storing data about Option
 * 
 * @author Tomáš Junas
 * @version 1.0
 */
public class Option {
	
	private String text;
	private boolean correct;
	private boolean selected;
	
	/**
	 * Constructor
	 * 
	 * @param text text of the Option
	 * @param correct correct value
	 */
	public Option(String text, boolean correct) {
		this.text = text;
		this.correct = correct;
		this.selected = false;
	}
	
	/**
	 * Constructor
	 * 
	 * @param text text of the Option
	 * @param correct correct value
	 * @param selected selected value
	 */
	public Option(String text, boolean correct, boolean selected) {
		this.text = text;
		this.correct = correct;
		this.selected = selected;
	}
	
	/**
	 * Returns text of the Option
	 * 
	 * @return text
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Returns correct value
	 * 
	 * @return correct
	 */
	public boolean getCorrect() {
		return this.correct;
	}
	
	/**
	 * Returns selected value
	 * 
	 * @return selected
	 */
	public boolean getSelected() {
		return this.selected;
	}
	
	/**
	 * Sets selected value
	 * 
	 * @param selected selected value
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}
