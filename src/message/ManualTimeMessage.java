package message;

public class ManualTimeMessage extends TimeMessage {
	//zatvori sa sama po case da sa vypat
	
	public ManualTimeMessage(String message) {
		super(message);
	}
	
	public void setSeen(boolean seen) {
		this.seen = seen;
	}
}
