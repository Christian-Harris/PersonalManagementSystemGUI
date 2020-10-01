package menu;

import calendar.Calendar;
import event.Event;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;

import java.time.*;
import java.time.format.*;
import java.util.Arrays;

public class EventBuilderMenu extends GridPane{
	private TextField name;
	private TextField location;
	private TextField date;
	private ComboBox<Integer> startTimeHour;
	private ComboBox<Integer> startTimeMinute;
	private ComboBox<String> startTimeAMPM;
	private ComboBox<Integer> endTimeHour;
	private ComboBox<Integer> endTimeMinute;
	private ComboBox<String> endTimeAMPM;
	private TextArea description;
	private CheckBox repeats;
	private TextField startDate;
	private TextField endDate;
	private ComboBox<Integer> weeksOfRepition;
	private EventBuilderToolbar toolbar;
	private Button create;
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
	
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
		date.setPrefSize(200, 24);
		date.setMaxSize(200, 24);
		date.setMinSize(100, 24);
		date.setText(selectedDate.format(formatter));
		
		startTimeHour = new ComboBox<Integer>();
		startTimeHour.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
		startTimeHour.setValue(12);
		
		startTimeMinute = new ComboBox<Integer>();
		startTimeMinute.getItems().addAll(0, 15, 30, 45);
		startTimeMinute.setValue(0);
		
		startTimeAMPM = new ComboBox<String>();
		startTimeAMPM.getItems().addAll("AM", "PM");
		startTimeAMPM.setValue("AM");
		
		endTimeHour = new ComboBox<Integer>();
		endTimeHour.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
		endTimeHour.setValue(12);
		
		endTimeMinute = new ComboBox<Integer>();
		endTimeMinute.getItems().addAll(0, 15, 30, 45);
		endTimeMinute.setValue(0);
		
		endTimeAMPM = new ComboBox<String>();
		endTimeAMPM.getItems().addAll("AM", "PM");
		endTimeAMPM.setValue("AM");
		
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
					weeksOfRepition.setDisable(false);
				}
				else{
					startDate.setDisable(true);
					endDate.setDisable(true);
					weeksOfRepition.setDisable(true);
				}
			}
		});
		
		startDate = new TextField();
		startDate.setPrefSize(200, 24);
		startDate.setMaxSize(200, 24);
		startDate.setMinSize(100, 24);
		startDate.setDisable(true);
		startDate.textProperty().bindBidirectional(date.textProperty());
		
		endDate = new TextField();
		endDate.setPrefSize(200, 24);
		endDate.setMaxSize(200, 24);
		endDate.setMinSize(100, 24);
		endDate.setDisable(true);
		endDate.setText(selectedDate.format(formatter));
		
		weeksOfRepition = new ComboBox<Integer>();
		for(int i = 0; i < 10; i++){
			weeksOfRepition.getItems().add(i + 1);
		}
		weeksOfRepition.setValue(1);
		weeksOfRepition.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				((EventBuilderMenu)((ComboBox)e.getSource()).getParent()).paintEventBuilderMenu();
			}
		});
		weeksOfRepition.setDisable(true);
		
		create = new Button("Create");
		
		toolbar = new EventBuilderToolbar(calendar);
		
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
		this.add(description, 0, 7, 4, 2);
		
		this.add(repeats, 4, 1);
		
		this.add(new Label("Start Date: "), 4, 2);
		this.add(startDate, 5, 2);
		
		this.add(new Label("End Date: "), 4, 3);
		this.add(endDate, 5, 3);
		
		this.add(new Label("Weeks to Repeat"), 4, 4);
		this.add(weeksOfRepition, 5, 4);
		for(int i = 0; i < weeksOfRepition.getValue(); i++){
			this.add(new Label("Week " + (i + 1)), 4, 5 + i);
			this.add(new RepeatDay("Su"), 5, 5 + i);
			this.add(new RepeatDay("Mo"), 6, 5 + i);
			this.add(new RepeatDay("Tu"), 7, 5 + i);
			this.add(new RepeatDay("We"), 8, 5 + i);
			this.add(new RepeatDay("Th"), 9, 5 + i);
			this.add(new RepeatDay("Fr"), 10, 5 + i);
			this.add(new RepeatDay("Sa"), 11, 5 + i);
		}
	}
	
	class EventBuilderToolbar extends HBox{
		Button back;
		Button create;
		
		public EventBuilderToolbar(Calendar calendar){
			back = new Button("<-");
			back.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
					((Stage)((Button)e.getSource()).getScene().getWindow()).close();
				}
			});
			
			create = new Button("Create Event");
			create.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
					try{
						LocalDate eventDate = LocalDate.parse(date.getText(), formatter);
						LocalTime eventStartTime;
						LocalTime eventEndTime;
						LocalDate eventStartDate = eventDate;
						LocalDate eventEndDate = eventDate;
						boolean[][] repetitionMask = new boolean[weeksOfRepition.getValue()][7];
						if(startTimeAMPM.getValue().equals("AM")){
							eventStartTime = LocalTime.of(startTimeHour.getValue() - 1, startTimeMinute.getValue());
						}
						else{
							eventStartTime = LocalTime.of(startTimeHour.getValue() + 11, startTimeMinute.getValue());
						}
						if(endTimeAMPM.getValue().equals("AM")){
							eventEndTime = LocalTime.of(endTimeHour.getValue() - 1, endTimeMinute.getValue());
						}
						else{
							eventEndTime = LocalTime.of(endTimeHour.getValue() + 11, endTimeMinute.getValue());
						}
						if(eventStartTime.compareTo(eventEndTime) > 0){
							throw new DateTimeException("End time is before start time.");
						}
						
						if(repeats.isSelected()){
							eventStartDate = LocalDate.parse(startDate.getText(), formatter);
							eventEndDate = LocalDate.parse(endDate.getText(), formatter);
							if(eventStartDate.compareTo(eventEndDate) > 0){
								throw new DateTimeException("End date is before start date.");
							}
							for(int r = 0; r < weeksOfRepition.getValue(); r++){
								for(int c = 0; c < 7; c++){
									if(((RepeatDay)((EventBuilderMenu)((HBox)((Button)e.getSource()).getParent()).getParent()).getNode((5 + c), (5 + r))).isSelected()){
										repetitionMask[r][c] = true;
									}
								}
							}
						}
						if(!repeats.isSelected()){
							calendar.addEvent(new Event(name.getText(), eventDate, eventStartTime, eventEndTime, description.getText(), location.getText(), false));
							calendar.paintCalendar();
							((Stage)((Button)e.getSource()).getScene().getWindow()).close();
						}
						else{
							calendar.addEvent(new Event(name.getText(), eventDate, eventStartTime, eventEndTime, description.getText(), location.getText(), true, eventStartDate, eventEndDate, repetitionMask));
							calendar.paintCalendar();
							((Stage)((Button)e.getSource()).getScene().getWindow()).close();
						}	
					}catch(DateTimeParseException ex){
						System.out.println("Invalid date string");
					}
					catch(DateTimeException ex){
						System.out.println("Invalid time fields");
					}
				}
			});
			this.getChildren().addAll(back, create);
		}
	}
	
	class RepeatDay extends Label{
		private boolean selected;
		public RepeatDay(String text){
			super(text);
			selected = false;
			this.setOnMouseClicked(new EventHandler<MouseEvent>(){
				public void handle(MouseEvent e){
					if(selected){
						selected = false;
						((RepeatDay)e.getSource()).setStyle("-fx-border-color: null");
					}
					else{
						selected = true;
						((RepeatDay)e.getSource()).setStyle("-fx-border-color: blue");
					}
				}
			});
		}
		
		public boolean isSelected(){
			return this.selected;
		}
	}
	
	private Node getNode(int col, int row) {
    for (Node node : this.getChildren()) {
        if (this.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
            return node;
        }
    }
    return null;
}
}