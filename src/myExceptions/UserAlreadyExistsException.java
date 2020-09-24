package myExceptions;

public class UserAlreadyExistsException extends Exception{
	private String username;
	
	public UserAlreadyExistsException(String username){
		super(username + " already exists");
		this.username = username;
	}
	
	public String getUsername(){
		return this.username;
	}
}