package menu;

import calendar.Calendar;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.time.*;

public class EventBuilderMenu extends GridPane{
	private TextField name;
	private TextField location;
	private TextField date;
	private ComboBox<String> startTimeHour;
	private ComboBox<String> startTimeMinute;
	private ComboBox<String> startTimeAMPM;
	private ComboBox<String> endTimeHour;
	private ComboBox<String> endTimeMinute;
	private ComboBox<String> endTimeAMPM;
	private TextArea description;
	private CheckBox repeats;
	private TextField startDate;
	private TextField endDate;
	private EventBuilderToolbar toolbar;
	private Button create;
	
	public EventBuilderMenu(LocalDate selectedDate, Calendar calendar){
		name = new TextField();
		name.setPromptText("Event Name");
		name.setPrefSize(200, 24);
		name.setMaxSize(200, 24);
		name.setMinSize(100, 24);
		
		location = new TextField();
		location.setPromptText("Location");
		location.setPrefSize(200, 24);
		location.setMaxSize(200, 24);
		location.setMinSize(100, 24);
		
		date = new TextField();
		date.setPromptText("Date");
		date.setPrefSize(200, 24);
		date.setMaxSize(200, 24);
		date.setMinSize(100, 24);
		
		startTimeHour = new ComboBox<String>();
		startTimeHour.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
		
		startTimeMinute = new ComboBox<String>();
		startTimeMinute.getItems().addAll("0", "15", "30", "45");
		
		startTimeAMPM = new ComboBox<String>();
		startTimeAMPM.getItems().addAll("AM", "PM");
		
		endTimeHour = new ComboBox<String>();
		endTimeHour.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
		
		endTimeMinute = new ComboBox<String>();
		endTimeMinute.getItems().addAll("0", "15", "30", "45");
		
		endTimeAMPM = new ComboBox<String>();
		endTimeAMPM.getItems().addAll("AM", "PM");
		
		description = new TextArea();
		description.setPrefSize(200, 200);
		description.setMaxSize(200, 200);
		description.setMinSize(100, 50);
		
		repeats = new CheckBox("Repeats");
		repeats.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				if(((CheckBox)e.getSource()).isSelected()){
					startDate.setDisable(false);
					endDate.setDisable(false);
				}
				else{
					startDate.setDisable(true);
					endDate.setDisable(true);
				}
			}
		});
		
		startDate = new TextField();
		startDate.setPromptText("Start Date");
		startDate.setPrefSize(200, 24);
		startDate.setMaxSize(200, 24);
		startDate.setMinSize(100, 24);
		startDate.setDisable(true);
		
		endDate = new TextField();
		endDate.setPromptText("End Date");
		endDate.setPrefSize(200, 24);
		endDate.setMaxSize(200, 24);
		endDate.setMinSize(100, 24);
		endDate.setDisable(true);
		
		create = new Button("Create");
		
		toolbar = new EventBuilderToolbar();
		
		this.paintEventBuilderMenu();
	}
	
	private void paintEventBuilderMenu(){
		this.getChildren().clear();
		this.add(toolbar, 0, 0);
		
		this.add(new Label("Name: "), 0, 1);
		this.add(name, 1, 1);
		
		this.add(new Label("Location: "), 0, 2);
		this.add(location, 1, 2);
		
		this.add(new Label("Date: "), 0, 3);
		this.add(date, 1, 3);
		
		this.add(new Label("Start Time: "), 0, 4);
		this.add(startTimeHour, 1, 4);
		this.add(startTimeMinute, 2, 4);
		this.add(startTimeAMPM, 3, 4);
		
		
		this.add(new Label("End Time: "), 0, 5);
		this.add(endTimeHour, 1, 5);
		this.add(endTimeMinute, 2, 5);
		this.add(endTimeAMPM, 3, 5);
		
		this.add(new Label("Description"), 0, 6);
		this.add(description, 0, 7, 2, 2);
		
		this.add(repeats, 4, 1);
		
		this.add(new Label("Start Date: "), 4, 2);
		this.add(startDate, 5, 2);
		
		this.add(new Label("End Date: "), 4, 3);
		this.add(endDate, 5, 3);
	}
	
	class EventBuilderToolbar extends HBox{
		Button back;
		
		public EventBuilderToolbar(){
			back = new Button("<-");
			back.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
					((Stage)((Button)e.getSource()).getScene().getWindow()).close();
				}
			});
			this.getChildren().add(back);
		}
	}
}