package epk;

public class GlobalMessage {
	
	private String message;
	private boolean seen;
	
	public GlobalMessage(String message) {
		this.message = message;
		this.seen = false;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean isSeen() {
		return this.seen;
	}
	
	public void setSeen(boolean seen) {
		this.seen = seen;
	}

}
