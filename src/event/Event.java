package event;

public class Event{
	private String name;
	private LocalDate date;
	private LocalTime startTime;
	private LocalTime endTime;
	private String description;
	private String location;
	private boolean repeats;	
	
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