package courses;

/**
 * <b>Custom File Object</b> <br>
 * 
 * Object is storing file name (placeholder.txt)
 * in folder (./data/1/)
 * path to file is (./data/1/placeholder.txt)
 * 
 * @author Tomáš Junas
 * @version 1.0
 */
public class CustomFile {
	
	private String name;
	private String location;
	private String path;
	
	/**
	 * Constructor
	 * 
	 * @param name name of the file
	 */
	public CustomFile(String name){
		this.name = name;
	}
	
	/**
	 * Constructor
	 * 
	 * @param name name of the file
	 * @param location folder of the file
	 */
	public CustomFile(String name, String location){
		this.name = name;
		this.location = location;
	}
	
	/**
	 * Returns File name
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns File folder
	 * 
	 * @return location folder of the file
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * Returns File path
	 * 
	 * @return path path of the file
	 */
	public String getPath() {
		return this.path;
	}
	
	/**
	 * Sets File name
	 * 
	 * @param name name of the file
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets File folder
	 * @param location folder of the file
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Sets File path
	 * 
	 * @param path path of the file
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
}
