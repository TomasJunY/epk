package message;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <b>TimeMessage Object</b> <br>
 * 
 * Object is storing data about TimeMessage <br>
 * The Message will close at selected date
 * 
 * @author Tomas Junas
 * @version 1.0
 */
public class TimeMessage extends Message {
	
	protected Date expiration;
	protected SimpleDateFormat formatter;
	protected String formattedDate;
	protected boolean seen;
	
	/**
	 * Constructor
	 * 
	 * @param message Message
	 */
	public TimeMessage(String message) {
		super(message);
		this.seen = false;
	}
	
	/**
	 * Returns expiration of the Message
	 *  
	 * @return expiration
	 */
	public Date getExpiration() {
		return this.expiration;
	}
	
	/**
	 * Sets expiration of the Message
	 * 
	 * @param expiration expiration of the Message
	 */
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
		formatter = new SimpleDateFormat("dd.MM.yyyy");
		formattedDate = formatter.format(expiration);
	}
	
	/**
	 * Returns formatted expiration (dd.MM.yyyy)
	 * 
	 * @return formattedDate
	 */
	public String getFormattedExpiration() {
		return this.formattedDate;
	}
	
	/**
	 * Returns formatter
	 * 
	 * @return formatter
	 */
	public SimpleDateFormat getFormatter() {
		return this.formatter;
	}

	/**
	 * Sets seen value if current date is after expiration
	 *  
	 * @param currentDate current date
	 */
	public void passedDate(Date currentDate) {
		if (currentDate.after(expiration)) {
			this.seen = true;
		}
	}
	
	/**
	 * Returns seen value
	 * 
	 * @return seen
	 */
	public boolean isSeen() {
		return this.seen;
	}
	
	/**
	 * Returns not seen value
	 * 
	 * @return !seen
	 */
	public boolean isNotSeen() {
		return !this.seen;
	}
	
	/**
	 * Sets seen value (do nothing)
	 * @param seen seen value
	 */
	public void setSeen(boolean seen) {	
	}
	
}
