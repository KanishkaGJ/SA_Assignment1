package driver_publisher;

public class Driver {
	
	private String name;
	private String email;
	private String telNum;
	private String address;
	
	public Driver() {}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setTelNum(String username) {
		this.telNum = username;
	}
	
	public String getTelNum() {
		return this.telNum;
	}
	
	public void setAddress(String password) {
		this.address = password;
	}
	
	public String getAddress() {
		return this.address;
	}
}
