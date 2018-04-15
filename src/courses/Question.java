package courses;

/**
 * <b>Question Object</b> <br>
 * 
 * Object is storing data about Question
 * 
 * @author Tomáš Junas
 * @version 1.0
 */
public class Question {
	
	private String name;
	private String text;
	private int point;
	private String image;
	private Option[] options;
	
	/**
	 * Constructor
	 * 
	 * @param optionCount number of Options
	 * @param name name of the Question
	 * @param text text of the Question
	 */
	public Question(int optionCount, String name, String text){
		this.options = new Option[optionCount]; 
		this.name = name;
		this.text = text;
	}
	
	/**
	 * Constructor
	 * 
	 * @param optionCount number of Options
	 * @param name name of the Question
	 * @param text text of the Question
	 * @param point point of the Question
	 * @param image image of the Question
	 */
	public Question(int optionCount, String name, String text, int point, String image){
		this.options = new Option[optionCount];
		this.name = name;
		this.text = text;
		this.point = point;
		this.image = image;
	}
	
	/**
	 * Returns Question name
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns Question text
	 * 
	 * @return text
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Returns Question point
	 * 
	 * @return point
	 */
	public int getPoint() {
		return this.point;
	}
	
	/**
	 * Returns Question image
	 * 
	 * @return image
	 */
	public String getImage() {
		return this.image;
	}
	
	/**
	 * Return all Options of the Question
	 * 
	 * @return options
	 */
	public Option[] getAllOptions() {
		return this.options;
	}
	
	/**
	 * Returns Option from array on position
	 * 
	 * @param position position in array
	 * @return options[position]
	 */
	public Option getOption(int position) {
		return this.options[position];
	}
	
	/**
	 * Returns length of Options array
	 * 
	 * @return questions.length
	 */
	public int getOptionsLength() {
		return this.options.length;
	}
	
	/**
	 * Sets Option in array on position
	 * 
	 * @param position position in array
	 * @param options option
	 */
	public void setOption(int position, Option option) {
		this.options[position] = option;
	}

}
