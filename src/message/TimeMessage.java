package message;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeMessage extends Message {
	//zatvori sa sama po case neda sa vypnut
	
	protected Date expiration;
	protected SimpleDateFormat formatter;
	protected String formattedDate;
	protected boolean seen;
	
	public TimeMessage(String message) {
		super(message);
		this.seen = false;
	}
	
	public Date getExpiration() {
		return this.expiration;
	}
	
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
		formatter = new SimpleDateFormat("dd.MM.yyyy");
		formattedDate = formatter.format(expiration);
	}
	
	public String getFormattedExpiration() {
		return this.formattedDate;
	}
	
	public SimpleDateFormat getFormatter() {
		return this.formatter;
	}

	public void passedDate(Date currentDate) {
		if (currentDate.after(expiration)) {
			this.seen = true;
		}
	}
	
	public boolean isSeen() {
		return this.seen;
	}
	
	public boolean isNotSeen() {
		return !this.seen;
	}
	
	public void setSeen(boolean seen) {
	}
}
