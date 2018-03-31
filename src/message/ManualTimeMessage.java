package message;

import java.util.Date;

public class ManualTimeMessage extends TimeMessage {
	//zatvori sa sama po case da sa vypat
	
	private boolean seen;
	
	public ManualTimeMessage(String message) {
		super(message);
	}
	
	public boolean isSeen() {
		return this.seen;
	}
	
	public boolean isNotSeen() {
		return !this.seen;
	}
	
	public void setSeen(boolean seen) {
		this.seen = seen;
	}
}
