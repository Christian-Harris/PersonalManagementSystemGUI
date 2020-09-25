package calendar;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.Text;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Calendar extends BorderPane{
	private GridPane calendar;
	private CalendarNavigation navBar;
	private YearMonth current;
	private YearMonth view;
	private static Label[] daysOfWeek = {new Label("Sunday"), new Label("Monday"), new Label("Tuesday"), new Label("Wednesday"), new Label("Thursday"), new Label("Friday"), new Label("Saturday")};
	private Text eventSummary;
	
	public Calendar(){
		calendar = new GridPane();
		navBar = new CalendarNavigation(this);
		current = YearMonth.now();
		view = current;
		eventSummary = new Text("\n\nEvents");
		eventSummary.setWrappingWidth(100);
		this.paintCalendar();
	}
	
	private void paintCalendar(){
		int year = view.getYear();
		Month month = view.getMonth();
		LocalDate firstOfMonth = LocalDate.of(year, month, 1);
		int firstDayOfCurrentMonth = firstOfMonth.getDayOfWeek().getValue(); //Monday = 1, Tuesday = 2, ..., Sunday = 7	

		calendar.getChildren().clear();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
		String text = view.format(formatter);
		
		calendar.add(new Label(text), 0, 0, 7, 1);
		
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
	
	class Day extends VBox{
		private LocalDate date;
		
		Day(LocalDate date, Calendar calendar){
			this.date = date;
			this.getChildren().add(new Label(Integer.toString(date.getDayOfMonth())));
			
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
					
				}
			});
		}
	}
	
	class CalendarNavigation extends HBox{
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