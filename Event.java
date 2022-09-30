import java.time.Duration;
/**
 * {@Summary} The implementation of an event with a starting time, an ending time, and a description. 
 * It also implements Comparable. 
 * The ordering of two events is determined by the ordering of their starting times.
 * @author Warisa Khan.
 */
// TO DO: add your implementation and JavaDocs.

public class Event implements Comparable<Event> {
	/**
	 * startTime variable.
	 */
	private MyTime startTime;	

	/**
	 * endTime varibale. 
	 */
	private MyTime endTime;
		
	//description of the event
	/**
	 * description variable. 
	 */
	private String description;

	/**
	 * constructor.
	 * @param startTime is the intitial startTime given.
	 * @param endTime the initial endtime given.
	 */
	
	public Event(MyTime startTime, MyTime endTime){
		// constructor with start and end times
		// set description to be empty string ""
		this.startTime = startTime;
		this.endTime = endTime;
		description = "";
	

		// Throw IllegalArgumentException if endTime comes before startTime
		// Use this _exact_ error message for the exception 
		// (quotes are not part of the message):
		// "End Time cannot come before Start Time!"
		if (endTime.compareTo(startTime) < 0){
			throw new IllegalArgumentException("End Time cannot come before Start Time!");
		}

		// - Assume that the start time can be the same as the end time 
		//(0-duration event allowed)
		if(endTime == null || startTime == null ){
			throw new IllegalArgumentException("Null Time object!");
		}
		// Throw IllegalArgumentException if either time is null. 
		// - Use this _exact_ error message for the exception 
		//(quotes are not part of the message):
		//"Null Time object!"
				
	}

	/**
	 * constructor. 
	 * @param startTime sets the start time to a value.
	 * @param endTime sets the end time to a value. 
	 * @param description sets the description. 
	 */
	
	public Event(MyTime startTime, MyTime endTime, String description){
		//constructor with start time, end time, and description

		this.startTime = startTime;
		this.endTime = endTime;
	
		// perform the same checking of start/end times and 
		// throw the same exception as the constructor above
		if (endTime.compareTo(startTime) < 0){
			throw new IllegalArgumentException("End Time cannot come before Start Time!");
		}
		// if description argument is null, 
		// set description of the event to be empty string ""

		if(endTime == null || startTime == null ){
			throw new IllegalArgumentException("Null Time object!");
		}

		if (description == null){
			this.description = "";
		}

		this.description = description;			
	}

	/**
	 * getter method for start Time. 
	 * @return startTime.
	 */
	
	public MyTime getStart(){
		// report starting time

		return this.startTime; //default return, remove/change as needed
	}

	/**
	 * getter method for endTime.
	 * @return endTime;
	 */
	
	public MyTime getEnd(){
		// report starting time

		return this.endTime; //default return, remove/change as needed
	}

	/**
	 * getter for the description variable. 
	 * @return description value. 
	 */

	public String getDescription(){
		// report description
		
		return this.description; //default return, remove/change as needed
	}

	/**
	 * compare to method that compares the order of the events.
	 * @param otherEvent is the event being compared to the original this.event. 
	 * @return int value for the compareTo method.
	 */
	
	@Override 
	public int compareTo(Event otherEvent){
		// compare two times for ordering
		
		
		// Throw IllegalArgumentException if otherEvent is null. 
		// - Use this _exact_ error message for the exception 
		//  (quotes are not part of the message):
		//    "Null Event object!"
		if(otherEvent == null){
			throw new IllegalArgumentException("Null Event object!");
		}

		if (this.startTime.compareTo(otherEvent.getStart()) == 0){
			return 0;
		}

		if (this.startTime.compareTo(otherEvent.getStart()) < 0){
			return -1;
		}

		// The ordering of two events is the same as the ordering of their start times
		return 1; 
	}

	/**
	 * move the startTime to the newStart time while keeping the same duration. 
	 * @param newStart is the new start time variable. 
	 * @return boolean to show if the start was sucessfully changed to newStart. 
	 */
	public boolean moveStart(MyTime newStart){
		// Move the start time of this Event to be newStart but keep the same duration. 
		// - Remember to update the end time to ensure duration unchanged.
		int num = startTime.getDuration(endTime);

		//Return false if newStart is null. 
		// The start time can be moved forward or backward but the end time cannot 
		// go beyond 23:59 of the same day.  Do not update the event if this condition
		// cannot be satisfied and return false. 
		
		if(newStart == null){
			return false;
		}

		if(startTime.compareTo(newStart) == 0){
			return true;
		}

		if(newStart.getEndTime(num) == null){
			return false;
		}	
		// Return true if the start time can be moved to newStart successfully.

		startTime = newStart;
		endTime = startTime.getEndTime(num);
		return true;
	}

	/**
	 * change the duration to the given number of minutes. 
	 * @param minute is the given minutes to calculate the new duration. 
	 * @return boolean to check if duration was sucessfully changed. 
	 */
	
	public boolean changeDuration(int minute){
		// Change the duration of event to be the given number of minutes.
		// Update the end time of event based on the updated duration.	
		if (minute < 0){
			return false;

		}

		// The given minute cannot be negative; and the updated end time cannot go 
		// beyond 23:59 of the same day.  Do not update the event if these conditions
		// cannot be satisfied and return false.  
		// Return true if the duration can be changed.

		if(startTime.getEndTime(minute) == null){
			return false;
		}

		if(startTime.getDuration(endTime) == minute){

			return true;
		}

		endTime = startTime.getEndTime(minute);
		return true;


		
		// Note: a false return value means the specified duration is invalid for some reason. 
		//Hence if minute argument is the same as the current duration we will still return true.
	
	}

	/**
	 * change the new description. 
	 * @param newDescription is the newdescription being provided. 
	 */
	
	
	public void setDescription(String newDescription){
		// set the description of this event


		// if newDescription argument is null, 
		// set description of the event to be empty string ""
		if(newDescription == null){
			description = "";
		}

		this.description = newDescription;

	
	}

	/**
	 * String method that puts the starttime, endtime, and description into a sentence. \
	 * @return String is the end final String. 
	 */
	
	
	public String toString(){
		// return a string representation of the event in the form of
		// startTime-endTime/description
		// example: "06:30-07:00/breakfast"

		// Hint: String.format() can be helpful here...
		
		// The format of start/end times is the same as .toString() of MyTime


		return String.format("%s-%s/%s", startTime.toString(), endTime.toString(), getDescription()); //default return, remove/change as needed
	
	}

	/**
	 * main method. 
	 * @param args are the parameters being passed in. 
	 */
	
	public static void main(String[] args){
		// creating an event
		Event breakfast = new Event(new MyTime(7), new MyTime(7,30), "breakfast");
		
		// checking start/end times
		if (breakfast.getStart()!=null && breakfast.getEnd()!=null &&
			breakfast.getStart().getHour() == 7 && breakfast.getEnd().getHour() == 7 && 
			breakfast.getStart().getMin() == 0 && breakfast.getEnd().getMin() == 30){
			System.out.println("Yay 1");			
		}		
		//System.out.println(breakfast);
		//expected output (excluding quote):
		//"07:00-07:30/breakfast"

		// moveStart
		if (breakfast.moveStart(new MyTime(6,30)) && breakfast.getStart().getHour() == 6
			&& breakfast.getStart().getMin() == 30 && breakfast.getEnd().getMin() == 0){
			System.out.println("Yay 2");					
		}
		//System.out.println(breakfast);
		
		//longer duration
		if (breakfast.changeDuration(45) && breakfast.getStart().getHour() == 6
			&& breakfast.getStart().getMin() == 30 && breakfast.getEnd().getMin() == 15
			&& breakfast.getEnd().getHour() == 7){

			System.out.println("Yay 3");					
		}
		//System.out.println(breakfast);
		
		//shorter duration
		if (!breakfast.changeDuration(-10) && breakfast.changeDuration(15) 
			&& breakfast.getStart().getHour() == 6 && breakfast.getStart().getMin() == 30 
			&& breakfast.getEnd().getMin() == 45 && breakfast.getEnd().getHour() == 6){
			System.out.println("Yay 4");					
		}
		
		
		// compareTo
		Event jogging = new Event(new MyTime(5), new MyTime(6), "jogging");
		Event morningNews = new Event(new MyTime(6, 30), new MyTime(7), "morning news");
		if (breakfast.compareTo(jogging)>0 && jogging.compareTo(breakfast)<0
			&& breakfast.compareTo(morningNews) == 0){
			System.out.println("Yay 5");								
		}

		//System.out.println(breakfast);



	}



}