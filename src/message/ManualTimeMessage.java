package message;

/**
 * <b>TimeMessage Object</b> <br>
 * 
 * Object is storing data about TimeMessage <br>
 * The Message will close at selected date <br>
 * Can be closed manually
 * 
 * @author Tomas Junas
 * @version 1.0
 */
public class ManualTimeMessage extends TimeMessage {
	
	/**
	 * Constructor
	 * 
	 * @param message message
	 */
	public ManualTimeMessage(String message) {
		super(message);
	}
	
	/**
	 * Sets seen value 
	 * 
	 * @param seen seen
	 */
	public void setSeen(boolean seen) {
		this.seen = seen;
	}
	
}
