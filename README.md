# Clock
The base of a clockify-style application
IT495 Capstone Exam – Programming (Part 1b) – 50%
Question 1A. (40%) Create a class that will hold the information about a clock, called Clock. You need to keep minutes, hours and seconds in military time (24-hour) format. Include member functions that will setTime ( this will set the hours, minutes and seconds of the clock), getHours (return the hours), getMinutes (return the minutes) and getSeconds (return the seconds). Another method printTime which will print the time out like this 03:13:09 (hours:minutes:seconds). Overloaded constructors that will take in hours, minutes and seconds or the default constructor that will take in nothing and set hours, minutes and seconds all to 0.
Your class should also include the following methods
incrementSeconds() //A method to increment the time by one second. //The time is incremented by one second. // If the before-increment time is // 23:59:59, the time is reset to 00:00:00.
incrementMinutes() //A method to increment the time by one minute. // The time is incremented by one minute. // If the before-increment time is // 23:59:53, the time is reset to 00:00:53.
incrementHours() //A method to increment the time by one hour. // The time is incremented by one hour. // If the before-increment time is // 23:45:53, the time is reset to 00:45:53.
Question 1B. (10%) Show possible calls to do the following
 Create a clock that is set to 9:0:0
 Create another clock that is set to 9:30:20
 Add one hour to the first clock
 Add 30 minutes to the second clock
