package event;

import java.time.*;
import java.util.UUID;

public class Event{
	private UUID ID;
	private String name;
	private LocalDate date;
	private LocalTime startTime;
	private LocalTime endTime;
	private String description;
	private String location;
	private boolean repeats;
	private LocalDate startDate;
	private LocalDate endDate;
	boolean[][] repetitionMask;
	
	public Event(String name, LocalDate date, LocalTime startTime, LocalTime endTime, String description, String location, boolean repeats, LocalDate startDate, LocalDate endDate, boolean[][] repetitionMask){
		ID = UUID.randomUUID();
		this.name = name;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.location = location;
		this.repeats = repeats;
		this.startDate = startDate;
		this.endDate = endDate;
		this.repetitionMask = repetitionMask;
	}
	
	public Event(String name, LocalDate date, LocalTime startTime, LocalTime endTime, String description, String location, boolean repeats){
		ID = UUID.randomUUID();
		this.name = name;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.location = location;
		this.repeats = repeats;
	}
	
	public String getName(){
		return this.name;
	}
	
	public boolean getRepeats(){
		return this.repeats;
	}
	
	public LocalDate getDate(){
		return this.date;
	}
	
	public LocalDate getStartDate(){
		return this.startDate;
	}
	
	public LocalDate getEndDate(){
		return this.endDate;
	}
	
	public String summary(){
		String value = "\n" + this.name + "\n" + this.startTime.toString() + "\n" + this.endTime.toString() + "\n" + this.description + "\n" + this.location + "\n";
		return value;
	}
	
	public int getRepetitonWeeksLength(){
		return repetitionMask.length;
	}
	
	public boolean getMaskValue(int row, int column){
		return repetitionMask[row][column];
	}
}