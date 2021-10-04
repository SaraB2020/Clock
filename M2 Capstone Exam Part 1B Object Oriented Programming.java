public class it495capstone{

     public static void main(String []args){

		//Question 1B
		System.out.println("Question 1B");
		//Create a clock that is set to 9:00:00
		System.out.print("Create a clock that is set to 9 o'clock: ");
		Clock clock900 = new Clock(9,0,0);
		clock900.printTime();
		//Create another clock that is set to 9:30:20
		System.out.print("\nCreate a clock that is set to half past 9: ");
		Clock clock930 = new Clock(9,30,0);
		clock930.printTime();
		//Add one hour to the first clock
		System.out.print("\nAdd one hour to the first clock: ");
		clock900.incrementHours();
		clock900.printTime();
		//Add 30 minutes to the second clock
		System.out.print("\nAdd half hour to the second clock: ");
		for(int i = 0; i < 30; i++){
		clock930.incrementMinutes();
		}
		clock930.printTime();
		
		//Question 2B
		System.out.println("\n\nQuestion 2B");
		//Show calls to instantiate two objects. 
		//One of the parent type, with the time set to 23:30:30 
		Clock parent = new Clock(23,30,30);
		//and one of the child type with the same time set.
		ClockChild child = new ClockChild(23,30,30);
		//Show a call to printTime, using both objects.
		System.out.print("Show a call to printTime, using both objects:\n");
		parent.printTime();
		System.out.println("");
		child.printTime(12);
     }
}
//Question 1A
class Clock {

int hours = 0;
int minutes = 0;
int seconds = 0;

//default constructor
public Clock(){
	setTime(0,0,0);
}
//overloaded constructor 
public Clock(int hrs, int min, int sec){
	setTime(hrs, min, sec);
}
// this will set the hour, minutes seconds of the clock
public void setTime(int hrs, int min, int sec) {
  if(isValid(hrs, min, sec) == true){
	  this.hours = hrs;
	  this.minutes = min;
	  this.seconds = sec;
	  }
}
//check if valid input
public boolean isValid(int hrs, int min, int sec){
   boolean isValid = true;
   if(hrs > 23 || hrs < 0){printError("hours"); isValid = false;}
   if(min > 59 || min < 0){printError("minutes"); isValid = false;}
   if(sec > 59 || sec < 0){printError("seconds"); isValid = false;}
   return isValid;
}
//if not print an error message
public void printError(String error){
	System.out.println(error + " is not valid, please try again.");
}
//print time in hours:minutes:seconds format
public void printTime() {
    String hrs = "", min = "", sec = "", time = "";
	if(this.hours < 10) {hrs = "0";}
	if(this.minutes < 10) {min = "0";}
	if(this.seconds < 10) {sec = "0";}
	hrs += this.hours; min += this.minutes; sec += this.seconds;
	time = hrs + ":" + min + ":" + sec;
	System.out.print(time);
}
//returns minutes
public int getMinutes() {
    return this.minutes;
}
//returns hours
public int getHours() {
    return this.hours;
}
//returns seconds
public int getSeconds() {
	return this.seconds;
}
//A method to increment the time by one second. 
//If the before-increment time is 23:59:59, the time is reset to 00:00:00.
public void incrementSeconds(){
 if(this.seconds < 59) {this.seconds++;}
 else {
	 this.seconds = 0;
	 this.incrementMinutes();
 }
}
//A method to increment the time by one minute.
// If the before-increment time is 23:59:53, the time is reset to 00:00:53.
public void incrementMinutes(){
	 if(this.minutes < 59) {this.minutes++;}
	 else {
	 this.minutes = 0;
	 this.incrementHours();
 }
}
//A method to increment the time by one hour.
// If the before-increment time is 23:45:53, the time is reset to 00:45:53
public void incrementHours(){
 if(this.hours < 23) {this.hours++;}
 else {
	 this.hours = 0;
 }
}
}

//Question 2A.
//Using your clock class, create a child class, ClockChild
class ClockChild extends Clock
{  
//Create a constructor that calls the parent’s default constructor 
public ClockChild(){
	super();
}
/*overloaded constructor that takes in hours, minutes and seconds and 
sets the member variables accordingly.*/
public ClockChild(int hrs, int min, int sec){
	super(hrs,min,sec);
}
/*Create a printTime method, for the child. Now it will take in a parameter
 called typeOfClock. This will be an integer that will be either 12 or 24. 
 This tell the function how to print the time, either in military time
 (the parents type, call the parent method) or in normal type
 (12-hour) 11:30pm or 9:09am.*/
public void printTime(int typeOfClock){
	if(typeOfClock == 12){
		if(this.hours > 12){
			this.hours -= 12;
			super.printTime();
			System.out.print("pm");
			}
		else{super.printTime(); System.out.print("am");}
	}
	else if(typeOfClock == 24){super.printTime();}
	else { super.printError("typeOfClock"); }
}
    
}