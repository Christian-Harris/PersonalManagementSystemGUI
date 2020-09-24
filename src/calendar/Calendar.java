package calendar;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;

import java.time.*;

public class Calendar extends BorderPane{
	GridPane calendar = new GridPane();
	CalendarToolbar toolbar = new CalendarToolbar();
	
	public Calendar(){
		LocalDate firstOfMonth = LocalDate.of(YearMonth.now().getYear(), YearMonth.now().getMonth(), 1);
		int firstDayOfCurrentMonth = firstOfMonth.getDayOfWeek().getValue(); //Monday = 1, Tuesday = 2, ..., Sunday = 7
		
		Label[] daysOfWeek = {new Label("Sunday"), new Label("Monday"), new Label("Tuesday"), new Label("Wednesday"), new Label("Thursday"), new Label("Friday"), new Label("Saturday")};		
		for(int i = 0; i < 7; i++){
			daysOfWeek[i].setPrefSize(100, 24);
			daysOfWeek[i].setMinSize(24, 24);
			daysOfWeek[i].setMaxHeight(24);
			daysOfWeek[i].setMaxWidth(Double.MAX_VALUE);
			daysOfWeek[i].setUnderline(true);
			calendar.add(daysOfWeek[i], i, 0);
		}
		
		for(int i = 1; i <= firstOfMonth.lengthOfMonth(); i++){
			Day day = new Day(i);
			day.setPrefSize(100, 100);
			day.setMinSize(24, 24);
			day.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			calendar.add(day, (i + firstDayOfCurrentMonth - 1) % 7, ((i + firstDayOfCurrentMonth - 1) / 7) + 1);
		}
		
		calendar.setVgap(24);
		calendar.setHgap(24);
		
		BorderPane.setAlignment(calendar, Pos.CENTER);
		calendar.setAlignment(Pos.CENTER);
		//calendar.setGridLinesVisible(true);
		this.setCenter(calendar);
		this.setTop(toolbar);
	}
	
	class Day extends VBox{
		//private LocalDate date;
		private Label dayNumber;
		
		Day(int day){
			dayNumber = new Label(Integer.toString(day));
			//thid.date = date;
			//this.setStyle("-fx-border-color: black; -fx-border-width: 1");
			this.getChildren().add(dayNumber);
		}
	}
	
	class CalendarToolbar extends HBox{
		Button next = new Button("->");
		Button previous = new Button("<-");
		
		CalendarToolbar(){
			next.setPrefSize(36, 24);
			next.setMinSize(36, 24);
			next.setMaxSize(36, 24);
			
			previous.setPrefSize(36, 24);
			previous.setMinSize(36, 24);
			previous.setMaxSize(36, 24);
			
			Region spacing = new Region();
			HBox.setHgrow(spacing, Priority.ALWAYS);
			
			this.setAlignment(Pos.CENTER);
			this.getChildren().addAll(previous, spacing, next);
		}
	}
}