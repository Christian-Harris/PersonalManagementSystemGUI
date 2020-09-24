package user;

import calendar.Calendar;

public class User{
	private String username = "";
	private String password = "";
	private Calendar calendar;
	
	public User(String username, String password){
		this.username = username;
		this.password = password;
		calendar = new Calendar();
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public Calendar getCalendar(){
		return this.calendar;
	}
}