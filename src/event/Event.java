package event;

import java.time.*;
import java.util.UUID;

/**
 * <h2>Event</h2>
 * <p>This class implements and Event object for tracking personalized events in a calendar.</p>
 * <p>Created on 1 October 2020</p>
 * @author Christian Harris
 */

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
	private boolean[][] repetitionMask;
	
	/**
	*	Constructs an event. This constructor should be called when the event is meant to repeat.
	*	@param name - The name of the event.
	*	@param date - The first date the event is to occur on.
	*	@param startTime - The starting time of the event.
	*	@param endTime - The ending time of the event.
	*	@param description - a user specified description of the event.
	*	@param location - a user specified location of the event.
	*	@param repeats - True if the event is set to repeat, false otherwise.
	*	@param startDate - The first date the event is to occur on when repeated.
	*	@param endDate - The final date the event is to occur on when repeated.
	*	@param repetitionMask - A two dimensional array storing information about how the event is going to repeat.
	*/
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
	
	/**
	*	Constructs an event. This constructor should be called when the event is not meant to repeat.
	*	@param name - The name of the event.
	*	@param date - The first date the event is to occur on.
	*	@param startTime - The starting time of the event.
	*	@param endTime - The ending time of the event.
	*	@param description - a user specified description of the event.
	*	@param location - a user specified location of the event.
	*	@param repeats - True if the event is set to repeat, false otherwise.
	*/
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
	
	/**
	*	This method returns the name of the event.
	*	@return the name of this event.
	*/
	public String getName(){
		return this.name;
	}
	
	/**
	*	This method returns true if the event repeats and false otherwise.
	*	@return true if this repeats, false otherwise.
	*/
	public boolean getRepeats(){
		return this.repeats;
	}
	
	/**
	*	This method returns the date of the event.
	*	@return the first date the event is to occur on.
	*/
	public LocalDate getDate(){
		return this.date;
	} 
	
	/**
	*	This method returns the startDate of the event. This field is only initialized if the event is set to repeat.
	*	@return the first date the event is to occur on.
	*/
	public LocalDate getStartDate(){
		return this.startDate;
	}
	
	/**
	*	This method returns the endDate of the event. This field is only initialized if the event is set to repeat.
	*	@return the final date the event is to occur on.
	*/
	public LocalDate getEndDate(){
		return this.endDate;
	}
	
	/**
	*	This method returns a formatted string representing a summary of this event.
	*	@return a summary of this event.
	*/
	public String summary(){
		String value = "\n" + this.name + "\n" + this.startTime.toString() + "\n" + this.endTime.toString() + "\n" + this.description + "\n" + this.location + "\n";
		return value;
	}
	
	/**
	*	This method returns how many weeks it takes for the events repetition pattern to begin repeating itself.
	*	@return the number of weeks in the repetition cycle of this event.
	*/
	public int getRepetitonWeeksLength(){
		return repetitionMask.length;
	}
	
	/**
	*	This method returns the mask value of repetitionMask at index (row, column);
	*	@param row - the row index of the mask value to retrieve.
	*	@param column - the column index of the mask value to retrieve.
	*	@return the mask value of repetitionMask at index (row, column);
	*/
	public boolean getMaskValue(int row, int column){
		return repetitionMask[row][column];
	}
	
	/**
	*	This method returns a unique ID associated with this event.
	*	@return this ID.
	*/
	public UUID getID(){
		return this.ID;
	}
}