/**
 * {@Summary} The class representing a time with two integer components: an hour within [0,23] and a minute within [0,59]. 
 * It implements Comparable interface. 
 * Comparison of MyTime objects is the basis of ordering events in our day planner.
 * @author Warisa Khan.
 */

public class MyTime implements Comparable<MyTime> {
	//initializing variables hour and min.
	// Hour and minute of a time.
	/**
	 * hour variable.
	 */
	private int hour;
	/**
	 * minute variable.
	 */
	private int min;
	
	/**
	 * this is a constructor.
	 */
	public MyTime(){
		hour = 0;
		min= 0;
		// Constructor.
		// initialize time to be 00:00.
		
	}

	/**
	 * this is a constructor that sets the specific hour.
	 * @param hour is the specified hour that is given.
	 */
	
	public MyTime(int hour){
		// Constructor with hour specified
		// initialize time to be hour:00]
		this.hour = hour;
		this.min = 0;

		//checking to make sure hour given is acceptable and meets restraints and throwing exception if it does not.

		if (hour<0 || hour>23){
			throw new IllegalArgumentException("Hour must be within [0,23]");

		}
		
		// A valid hour can only be within [0, 23].
		// For an invalid hour, throw IllegalArgumentException.
		// Use this _exact_ error message for the exception 
		//  (quotes are not part of the message):
		// "Hour must be within [0, 23]!"


	}

	/**
	 * this is another constructor that assigns specific values to min and hour.
	 * @param hour is the specified hour given. 
	 * @param min is the specified min given. 
	 */
	
	public MyTime(int hour, int min){
		// Constructor with hour and minutes specified
		// initialize time to be hour:minute
		this.hour = hour;
		this.min = min;

		// A valid hour can only be within [0, 23].
		// A valid minute can only be within [0, 59].

		//exception handling 

		if(hour<0 || hour>23 || min<0 || min>59){
			throw new IllegalArgumentException("Hour must be within [0,23]; Minute must be within [0,59]!");

		}



		// For an invalid hour / minute, throw IllegalArgumentException.
		// Use this _exact_ error message for the exception 
		//  (quotes are not part of the message):
		// "Hour must be within [0, 23]; Minute must be within [0, 59]!");


	}
	/**
	 * getter method for hour.
	 * @return hour value. 
	 */
	
	public int getHour(){
		// report hour

		
		return hour; //default return, remove/change as needed
	}

	/**
	 * getter method for min. 
	 * @return min value.
	 */

	public int getMin(){
		// report minute
		
		return min; //default return, remove/change as needed
	}

	/**
	 * {@summary}this functon compares the intiial time to the other time to place it.  
	 * @param otherTime is being used to create a comparison between initial time given and otherTime which is an object of myTime. 
	 * @return int value for compareTo method.
	 */
	
	@Override 
	public int compareTo(MyTime otherTime){
		//compare two times for ordering
		//Throw IllegalArgumentException if otherTime is null. 
		if(otherTime == null){
			throw new IllegalArgumentException("Null Time object!");
		}

		// return the value 0 if the argument Time has the same hour and minute of this Time;

		if(this.hour == otherTime.hour && this.min == otherTime.min){
			return 0;
		}

		// return a value less than 0 if this Time is before the otherTime argument; 

		if((this.hour < otherTime.hour) || (this.hour == otherTime.hour && this.min < otherTime.min))
		{
			return -1;
		}

		// return a value greater than 0 if this Time is after the otherTime argument.

		return 1;
		//Throw IllegalArgumentException if otherTime is null. 
		//Use this _exact_ error message for the exception 
		//(quotes are not part of the message):
		//"Null Time object!"
	}

	/**
	 * {@summary} creating a new and updated duration based on endtime.
	 * @param endTime is being used to create a new duration and manage the endtime and starttime. 
	 * @return finalAnswer which is the total duration of hours and minutes.
	 */
	
	public int getDuration(MyTime endTime){
		
	
		// Throw IllegalArgumentException if endTime is null. 
		// - Use this _exact_ error message for the exception 
		//  (quotes are not part of the message):
		//    "Null Time object!"

		

		if(endTime == null){
			throw new IllegalArgumentException("Null Time object!");
		}

		// return -1 if endTime is before this Time

		if(endTime.compareTo(this) < 0){
			return -1;


		}

		// return the number of minutes starting from this Time and ending at endTime

		int newHour = endTime.hour - this.hour;
		int newMin = endTime.min - this.min;

		int finalAnswer = (newHour * 60) + newMin;



		//get the end time hour (call get hour method ) subtract hour 
		//same thing for min  
		//return the number for hour times 60 and adding it to minutes 

		return finalAnswer; 		
	}

	/**
	 * {@summary} is used to create a Time Object that is a duration (in minutes) from the original Time provided.
	 * @param duration is the new duration. 
	 * @return findingEndTime which is the calculated duration.
	 */
	
	public MyTime getEndTime(int duration){
		

		// Throw IllegalArgumentException if duration is negative. 
		// Use this _exact_ error message for the exception 
		//  (quotes are not part of the message):
		// "Duration must be non-negative!"		
		
		if(duration < 0){
			throw new IllegalArgumentException("Duration must be non-negative!");
		}

		// initializing variables 

		int newHour = duration/60;
		int newMin = duration%60;
		int tempHours = this.hour + newHour;
		int tempMin = this.min + newMin;

		// return null if endTime passes 23:59 given this Time and duration argument

		if(tempHours > 23 || tempHours == 23 && tempMin > 59){
			return null;
		}
		// return a Time object that is duration minute from this Time

		if(tempMin >= 60 && tempHours<= 22){
			int finalHours = tempHours + 1;
			int finalMin = tempMin%60;

			MyTime tempEndTime = new MyTime(finalHours,finalMin);
			return tempEndTime;
			
		}

		MyTime findingEndTime = new MyTime(tempHours,tempMin);
		return findingEndTime;
	}

	/**8
	 * toString method converts the time into a string format.
	 * @return String is the updated String. 
	 */

	public String toString() {
		// return a String representation of this object in the form of hh:mm
		// hh is the hour of the time (00 through 23), as two decimal digits
		// mm is the minute of the time (00 through 59), as two decimal digits
		
		// Hint: String.format() can be helpful here...
		

		return String.format("%02d:%02d", this.hour, this.min);
		//default return, remove/change as needed		
	}
	
	/**
	 * main method that tests values.
	 * @param args are the arguments being passed through myTime.
	 */
	public static void main(String[] args){
		//This method is provided for testing 
		//(use/modify as much as you'd like)

		//time objects
		MyTime time1 = new MyTime(7);
		MyTime time2 = new MyTime(9,30);
		
		//checking hour/minute
		if (time1.getHour() == 7 && time1.getMin() == 0 && time2.getHour() == 9
			&& time2.getMin() == 30){
			System.out.println("Yay 1");			
		}		
	
		//compareTo, duration
		if (time1.compareTo(time2) < 0 && time1.compareTo(new MyTime(7,0)) == 0
			&& time2.compareTo(time1) > 0 && time1.getDuration(time2) == 150){
			System.out.println("Yay 2");						
		}
		
		//getEndTime
		MyTime time3 = time1.getEndTime(500);
		if (time3!=null && time3.getHour() == 15 && time3.getMin() == 20 
			&& time2.getEndTime(870) == null){
			System.out.println("Yay 3");								
		}

		//sample test cases for toString method 

		//System.out.println(time1);
		//System.out.println(time2);
		//System.out.println(time3);
		
	}
}