package event;

import java.time.*;

public class Event{
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
		this.name = name;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.location = location;
		this.repeats = repeats;
	}
}