# PersonalManagementSystemGUI
 A GUI for my personal management application.

## Synopsis
This project allowed me to build a GUI on top of a previous project which I called a personal management system.

## How to Run
Explain what files are needed to run and which file to run. It is also helpful to include a screenshot of the program running. Make sure image is in your repository.
![Application](https://github.com/Christian-Harris/PersonalManagementSystemGUI/blob/master/PMS%20Running.png)

## Code Example
The following code is an algorithm for determining if a given event object is on a particular day. In particulr this algorithm accounts for the events repetition and
correctly determines if the given day falls on one of the repeated days.
```
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
```
