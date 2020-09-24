package calendar;

import event.Event;

import java.util.ArrayList;

import javafx.scene.layout.Pane;

public class Calendar extends Pane{
	private ArrayList<Event> events;
	
	public Calendar(){
		events = new ArrayList<Event>();
	}
	
	public void addEvent(Event event){
		this.events.add(event);
	}
}