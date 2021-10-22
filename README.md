# ArrayList_Creating-a-GPS

The code I created is in GPS.java
Absolute Java, Chapter 14, Project  #3

Many Global Positioning Satellite (GPS) units can record waypoints. The waypoint 
marks the coordinates of a location on a map along with a timestamp. Consider a 
GPS unit that stores waypoints in terms of an (X,Y) coordinate on a map together 
with a timestamp t that records the number of seconds that have elapsed since the 
unit was turned on. 

Write a program that allows the user to enter as many waypoints as desired, storing each waypoint in an ArrayList , where each waypoint is 
represented by a class that you design. Each waypoint represents a successive sample 
point during a hike along some route. The coordinates should be input as doubles,
and the timestamp as an integer. Have your program compute the total distance 
traveled and the average speed in miles per hour. Use the map scaling factor of 
1 = 0.1 miles. For example, if the only two waypoints are (X=1,Y=1,T=0) and 
(X=2,Y=1,T=3600), then the hiker traveled a distance of 0.1 miles in 3,600 seconds, or 0.1 miles per hour. 

Requirement from Professor:
Prompt the user for values of X, Y, and T. The initial values of
X, Y, T are 0, 0, 0.
X < 0 marks the end of the list. 
Round printed values to 2 decimal places.
Make the Waypoint class an inner class of the program.
