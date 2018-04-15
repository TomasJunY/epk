package message;

/**
 * <b>Message Object</b> <br>
 * 
 * Object is storing data about Message
 * 
 * @author Tomáš Junas
 * @version 1.0
 */
abstract class Message {
	
	protected String message;
	
	/**
	 * Constructor
	 * 
	 * @param message Message
	 */
	public Message(String message) {
		this.message = message;
	}
	
	/**
	 * Returns Message
	 * 
	 * @return message
	 */
	public String getMessage() {
		return this.message;
	}
	
	/**
	 * Sets Message
	 * 
	 * @param message Message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
