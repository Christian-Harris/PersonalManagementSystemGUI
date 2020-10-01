package myExceptions;

public class EventAlreadyExistsException extends Exception{
	private String name;
	
	public EventAlreadyExistsException(String name){
		super(name + " already exists");
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}