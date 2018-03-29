package courses;

public class CustomFile {
	
	private String name;
	private String location;
	private String path;
	
	//konstruktor
	public CustomFile(String name){
		this.name = name;
	}
	
	public CustomFile(String name, String location){
		this.name = name;
		this.location = location;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public String getPath() {
		return this.path;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
}
