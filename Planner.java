// TO DO: add your implementation and JavaDocs.

/**
 * {@Summary} The implementation of a day planner.
 *  It stores a collection of events in ascending order of their starting times. 
 * The planner supports multiple operations for maintenance, including adding a new event, deleting an event, and updating an event.
 * @author Warisa Khan.
 */

public class Planner{

	// DO NOT MODIFY INSTANCE VARIABLES PROVIDED BELOW
	
	//underlying array of events  -- you MUST use this for credit!
	//Do NOT change the name or type

	/**
	 * events is a object of MySortedArray.
	 */
	private MySortedArray<Event> events;
	/**
	 * size is the integer value. 
	 */
	private int size;
	
	// ADD MORE PRIVATE MEMBERS HERE IF NEEDED!

	
	/**
	 * constructor. 
	 */
	
	public Planner(){
		
		//events is an array.
		
		events = new MySortedArray<>(); 
		
		//size variable. 
		 
		size = 0;
	


		// Constructor with no arguments.
		
		// A list of events should be created.  The initial capacity should be 
		// DEFAULT_CAPACITY defined in our MySortedArray class. 
		// The list should be empty (with no events).
		
	}

	/**
	 * size returns the event of size.
	 * @return int of the events. 
	 */

	public int size(){
		// return the number of events in the list.
		// O(1)
		
		return size; //default return, remove/change as needed
	}

	/**
	 * To String method. 
	 * @return String toString method. 
	 */
	
	public String toString(){
		StringBuilder finalString = new StringBuilder();
		for (int i =0; i < events.size(); i ++){
			finalString.append("[").append(i).append("]").append(getEvent(i));
			if(i != events.size() - 1){
				finalString.append("\n");
			}

			
		}


		
		


		return finalString.toString();
	}

	/**
	 * adds an event to the the events. 
	 * @param event is the event being added.
	 */
	
	public void addEvent(Event event){
		Event temporary = event;
		if(event == null){
			throw new IllegalArgumentException("Null Event object!");
		}

		if(events.size() == 0){
			events.add(temporary);
			size += 1;
			
		}

		for (int i = 0; i < events.capacity(); i ++){
			if(temporary.compareTo(getEvent(i)) < 0){
				events.add(i, temporary);
				size += 1;
			}

			if(temporary.compareTo(getEvent(i)) == 0){
				events.add(i, temporary);
				size += 1;

			}

			if (temporary.compareTo(getEvent(i)) > 0){
				events.add(i,temporary);
				size +=1;
			}
		}




		
		
		// Add a new event into the list
		//	- make sure events are sorted after addition

		// Throw IllegalArgumentException if event is null. 
		// - Use this _exact_ error message for the exception 
		//  (quotes are not part of the message):
		//    "Null Event object!"
		
		// O(N) where N is the number of events in the list

	}
	/**
	 * moves event to a new start time. 
	 * @param index is the location where the event is being moved. 
	 * @param newStart is the new start time. 
	 * @return boolean which returns true if able to move the start. 
	 */
	
	public boolean moveEvent(int index, MyTime newStart){

		if(index < 0 || index > events.size()){
			return false; 
		}

		if (newStart == null){
			return false; 
		}

		events.get(index).moveStart(newStart);
		return true; 




		
		
		

	}

	/**
	 * changes the duration. 
	 * @param index index location.
	 * @param minute is the minute. 
	 * @return boolean is true if able to change the duration. 
	 */


	public boolean changeDuration (int index, int minute){

		if (index < 0 || index >= events.size()){
			return false; 
		}

		if (minute < 0){
			return false; 
		}

		if(getEvent(index).changeDuration(minute) == false){
			return false; 
		}

		events.get(index).changeDuration(minute);
		return true; 

		
		// Change the duration of event at index to be the given number of minutes.
		
		// Return true if the duration can be changed.
		// Return false if:
		// - index is invalid; or
		// - minute is negative; or
		// - the duration of event at index can not be updated with the specified minute

		// O(1)		
		//default return, remove/change as needed
	
	}

	/**
	 * changes the description. 
	 * @param index is the index where description needs to be changed. 
	 * @param description is the content of the description. 
	 * @return boolean if able to change the description. 
	 */

	
	public boolean changeDescription(int index, String description){

		if (description == null){
			description = ""; 
			return true;
		}

		if (index < 0 || index > events.size()){
			return false; 
		}

		getEvent(index).setDescription(description);
		return true;
	
		

		// Change the description of event at index.
		
		// Return true if the event can be changed.
		// Return false for an invalid index.

		// If description argument is null, 
		// set description of the event to be empty string ""
		
		// O(1)

	}

	/**
	 * removes the event. 
	 * @param index is the index where the event needs to be removed.
	 * @return boolean if able to remove the event. 
	 */
	
	public boolean removeEvent(int index){
		if (index < 0 || index > events.capacity()){
			return false; 
		}
		

		events.delete(index);
		return true; 
		// Remove the event at index.
		
		// Return true if the event can be removed
		// Return false for an invalid index.
		
		// O(N) where N is the number of elements currently in the storage
		

	 //default return, remove/change as needed
	}

	/**
	 * gets the actual event using a getter method. 
	 * @param index is the index of the event.
	 * @return Event is the return type. 
	 */
	
	
	public Event getEvent(int index){
		// Return the event at index

		if(index < 0 || index > events.size()){
			return null;
		}
		
		// Return null for an invalid index.
		
		//O(1)
		return events.get(index); //default return, remove/change as needed
	}
	/**
	 * main method. 
	 * @param args parameters passed in. 
	 */

	public static void main(String[] args){
	
		// creating a planner
		Planner day1 = new Planner();

		// adding two events		
		Event breakfast = new Event(new MyTime(7), new MyTime(7,30), "breakfast");
		Event jogging = new Event(new MyTime(5), new MyTime(6), "jogging");
		day1.addEvent(breakfast);
		day1.addEvent(jogging);
		
		if (day1.size()==2 && day1.getEvent(0)==jogging && day1.getEvent(1)==breakfast ){
			System.out.println("Yay 1");					
		}
		
		//toString
		if (day1.toString().equals("[0]05:00-06:00/jogging\n[1]07:00-07:30/breakfast")){
			System.out.println("Yay 2");							
		}
		//System.out.println(day1);

		// move start of breakfast		
		MyTime newBFTime = new MyTime(6,30);
		
		if (day1.moveEvent(1, newBFTime) && day1.getEvent(1).getStart().getHour() == 6
			&& day1.getEvent(1).getStart().getMin() == 30){
			System.out.println("Yay 3");								
		}
		//System.out.println(day1);
		
		// change duration
		if (day1.changeDuration(0, 45) && day1.getEvent(0).getEnd().getHour() == 5 
			&& day1.getEvent(0).getEnd().getMin() == 45 && day1.changeDuration(1, 60)
			&& day1.getEvent(1).getEnd().getHour() == 7 
			&& day1.getEvent(1).getEnd().getMin() == 30){
			System.out.println("Yay 4");											
		}
		//System.out.println(day1);
		
		// change description, remove
		if (day1.changeDescription(1, "sleeping") && !day1.removeEvent(3) 
			&& !day1.removeEvent(-2) && day1.removeEvent(0)){
			System.out.println("Yay 5");							
		}
		//System.out.println(day1);
		
	}
}