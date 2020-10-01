package calendar;

import event.Event;
import myExceptions.EventAlreadyExistsException;
import menu.EventBuilderMenu;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

/**
 * <h2>Calendar</h2>
 * <p>This class implements a calendar object which displays in a window. The calendar stores an ArrayList of Event objects.</p>
 * <p>Created on 1 October 2020</p>
 * @author Christian Harris
 */
 
public class Calendar extends BorderPane{
	private GridPane calendar;
	private CalendarNavigation navBar;
	private YearMonth current;
	private YearMonth view;
	private static Label[] daysOfWeek = {new Label("Sunday"), new Label("Monday"), new Label("Tuesday"), new Label("Wednesday"), new Label("Thursday"), new Label("Friday"), new Label("Saturday")};
	private VBox eventSummary;
	
	private ArrayList<Event> events;
	
	/**
	*	Constructs a calendar object and displays the current month according to the system date.
	*/
	public Calendar(){
		calendar = new GridPane();
		navBar = new CalendarNavigation(this);
		current = YearMonth.now();
		view = current;
		eventSummary = new VBox(2);
		eventSummary.setMinWidth(100);
		eventSummary.getChildren().add(new Label("Events"));
		
		events = new ArrayList<Event>();
		
		this.setOnScroll(new EventHandler<ScrollEvent>(){
			public void handle(ScrollEvent e){
				if(e.getDeltaY() < 0){
					view = view.plusMonths(1);
					((Calendar)e.getSource()).paintCalendar();
				}
				else{
					view = view.minusMonths(1);
					((Calendar)e.getSource()).paintCalendar();
				}
			}
		});
		
		this.paintCalendar();
	}
	
	/**
	*	This method redraws the calendar and is called from other classes whenever the view needs to be updated.
	*/
	public void paintCalendar(){
		int year = view.getYear();
		Month month = view.getMonth();
		LocalDate firstOfMonth = LocalDate.of(year, month, 1);
		int firstDayOfCurrentMonth = firstOfMonth.getDayOfWeek().getValue(); //Monday = 1, Tuesday = 2, ..., Sunday = 7	

		calendar.getChildren().clear();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
		calendar.add(new Label(view.format(formatter)), 0, 0, 7, 1);
		
		for(int i = 0; i < 7; i++){
			daysOfWeek[i].setPrefSize(100, 24);
			daysOfWeek[i].setMinSize(24, 24);
			daysOfWeek[i].setMaxHeight(24);
			daysOfWeek[i].setMaxWidth(Double.MAX_VALUE);
			daysOfWeek[i].setUnderline(true);
			calendar.add(daysOfWeek[i], i, 1);
		}
		
		for(int i = 1; i <= firstOfMonth.lengthOfMonth(); i++){
			Day day = new Day(LocalDate.of(year, month, i), this);
			day.setPrefSize(100, 100);
			day.setMinSize(24, 24);
			day.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			if(LocalDate.now().equals(LocalDate.of(year, month, i))){
				day.setStyle("-fx-background-color: pink");
			}
			calendar.add(day, (i + firstDayOfCurrentMonth - 1) % 7, ((i + firstDayOfCurrentMonth - 1) / 7) + 2);
		}
		
		calendar.setVgap(12);
		calendar.setHgap(12);
		
		BorderPane.setAlignment(calendar, Pos.CENTER);
		calendar.setAlignment(Pos.CENTER);
		//calendar.setGridLinesVisible(true);
		this.getChildren().clear();
		this.setLeft(eventSummary);
		this.setCenter(calendar);
		this.setTop(navBar);
	}
	
	/**
	*	This method event to the ArrayList events.
	*	@param event - the event to be added to events.
	*/
	public void addEvent(Event event){
		events.add(event);
	}
	
	/**
	*	This method removes an event from the ArrayList events based on the unique UUID.
	*	@param ID - the ID of the event to delete from events.
	*/
	public void deleteEvent(UUID ID){
		for(int i = 0; i < events.size(); i++){
			if(events.get(i).getID().equals(ID)){
				events.remove(i);
			}
		}
	}
	
	/**
	*	This method returns a reference to the ArrayList events.
	*	@return events.
	*/
	public ArrayList<Event> getEvents(){
		return this.events;
	}
	
	//This is a helper class defining a Day object to be displayed on the calendar.
	private class Day extends VBox{
		private LocalDate date;
		private ContextMenu contextMenu;
		private MenuItem newEvent;
		
		Day(LocalDate date, Calendar calendar){
			this.date = date;
			this.getChildren().add(new Label(Integer.toString(date.getDayOfMonth())));
			for(int i = 0; i < events.size(); i++){
				if(this.eventIsOn(events.get(i))){
					this.getChildren().add(new Label(events.get(i).getName()));
				}
			}
			
			contextMenu = new ContextMenu();
			newEvent = new MenuItem("New Event");
			newEvent.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
					Stage eventStage = new Stage();
					EventBuilderMenu ebm = new EventBuilderMenu(date, calendar);
					Scene scene = new Scene(ebm, 1000, 300);
					eventStage.setTitle("Event Builder");
					eventStage.setMinWidth(300);
					eventStage.setMinHeight(300);
					eventStage.setScene(scene);
					eventStage.show();
				}
			});
			contextMenu.getItems().addAll(newEvent);
			
			this.setOnMouseEntered(new EventHandler<MouseEvent>(){
				public void handle(MouseEvent e){
					if(date.equals(LocalDate.now())){
						((VBox)e.getSource()).setStyle("-fx-border-color: blue; -fx-background-color: pink");
					}
					else{
						((VBox)e.getSource()).setStyle("-fx-border-color: blue");
					}
				}
			});
			
			this.setOnMouseExited(new EventHandler<MouseEvent>(){
				public void handle(MouseEvent e){
					if(date.equals(LocalDate.now())){
						((VBox)e.getSource()).setStyle("-fx-border-color: null; -fx-background-color: pink");
					}
					else{
						((VBox)e.getSource()).setStyle("-fx-border-color: null");
					}
				}
			});
			
			this.setOnMouseClicked(new EventHandler<MouseEvent>(){
				public void handle(MouseEvent e){
					if(e.getButton() == MouseButton.SECONDARY){
						contextMenu.show((Day)e.getSource(), Side.BOTTOM, 0, 0);
					}
					else if(e.getButton() == MouseButton.PRIMARY){
						eventSummary.getChildren().clear();
						eventSummary.getChildren().add(new Label("Events"));
						for(int i = 0; i < events.size(); i++){
							if(((Day)e.getSource()).eventIsOn(events.get(i))){
								eventSummary.getChildren().add(new summaryItem(events.get(i), calendar));
							}
						}
						calendar.paintCalendar();
					}
				}
			});
		}
			
		public boolean eventIsOn(Event event){
			if(!event.getRepeats()){
				if(this.date.compareTo(event.getDate()) == 0){
					return true;
				}
			}
			else{
				if(this.date.compareTo(event.getStartDate()) >= 0 && this.date.compareTo(event.getEndDate()) <= 0){
					int padding = event.getStartDate().getDayOfWeek().getValue();
					Period period = Period.between(event.getStartDate(), this.date).plusDays(padding);
					int daysBetween = period.getDays();
					int weeksBetween = daysBetween / 7;
					int repetitionWeekLength = event.getRepetitonWeeksLength();
					int row = weeksBetween % repetitionWeekLength;
					int column = date.getDayOfWeek().getValue() % 7;
					if(event.getMaskValue(row, column)){
						return true;
					}
				}				
			}
			return false;
		}
	}
	
	//This is a helper class defining a summaryItem object to be displayed in the calendar.
	private class summaryItem extends Text{
		private UUID ID;
		private ContextMenu contextMenu;
		private MenuItem deleteEvent;
		
		summaryItem(Event event, Calendar calendar){
			super(event.summary());
			ID = event.getID();
			contextMenu = new ContextMenu();
			deleteEvent = new MenuItem("Delete");
			deleteEvent.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
					calendar.deleteEvent(ID);
					calendar.paintCalendar();
				}
			});
			contextMenu.getItems().addAll(deleteEvent);
			
			this.setOnMouseClicked(new EventHandler<MouseEvent>(){
				public void handle(MouseEvent e){
					if(e.getButton() == MouseButton.SECONDARY){
						contextMenu.show((summaryItem)e.getSource(), Side.BOTTOM, 0, 0);
					}
				}
			});
		}
	}
	
	//This is a helper class defining a navigation toolbar for the calendar.
	private class CalendarNavigation extends HBox{
		Button next = new Button("->");
		Button previous = new Button("<-");
		Button today = new Button("Today");
		
		CalendarNavigation(Calendar calendar){
			next.setPrefSize(36, 24);
			next.setMinSize(36, 24);
			next.setMaxSize(36, 24);
			
			previous.setPrefSize(36, 24);
			previous.setMinSize(36, 24);
			previous.setMaxSize(36, 24);
			
			today.setPrefSize(60, 24);
			today.setMinSize(60, 24);
			today.setMaxSize(60, 24);
			
			Region spacing1 = new Region();
			Region spacing2 = new Region();
			HBox.setHgrow(spacing1, Priority.ALWAYS);
			HBox.setHgrow(spacing2, Priority.ALWAYS);
			
			next.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
					view = view.plusMonths(1);
					calendar.paintCalendar();
				}
			});
			
			previous.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
					view = view.minusMonths(1);
					calendar.paintCalendar();
				}
			});
			
			today.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
					view = current;
					calendar.paintCalendar();
				}
			});
			
			this.setAlignment(Pos.CENTER);
			this.getChildren().addAll(previous, spacing1, today, spacing2, next);
		}
	}
}