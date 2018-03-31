package message;

import java.util.Date;

public class TimeMessage extends Message {
	//zatvori sa sama po case neda sa vypat
	
	private Date expiration;
	
	public TimeMessage(String message) {
		super(message);
	}
	
	public Date getExpiration() {
		return this.expiration;
	}
	
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

}
