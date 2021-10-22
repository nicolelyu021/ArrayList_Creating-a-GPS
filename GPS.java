import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class GPS {
	/*
	 * Many Global Positioning Satellite (GPS) units can record waypoints. The
	 * waypoint marks the coordinates of a location on a map along with a timestamp.
	 * Consider a GPS unit that stores waypoints in terms of an (X,Y) coordinate on
	 * a map together with a timestamp t that records the number of seconds that
	 * have elapsed since the unit was turned on. Write a program that allows the
	 * user to enter as many waypoints as desired, storing each waypoint in an
	 * ArrayList, where each waypoint is represented by a class that you design.
	 * Each waypoint represents a successive sample point during a hike along some
	 * route. The coordinates should be input as doubles, and the timestamp as an
	 * integer. Have your program compute the total distance traveled and the
	 * average speed in miles per hour. Use the map scaling factor of 1 = 0.1 miles.
	 * For example, if the only two waypoints are (X=1,Y=1,T=0) and
	 * (X=2,Y=1,T=3600), then the hiker traveled a distance of 0.1 miles in 3,600
	 * seconds, or 0.1 miles per hour.
	 * 
	 * Prompt the user for values of X, Y, and T. The initial values of X, Y, T are
	 * 0, 0, 0. X < 0 marks the end of the list. Round printed values to 2 decimal
	 * places. Make the Waypoint class an inner class of the program.
	 */
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	public class Waypoint {
		//Waypoint class: an inner class of the program
		private double xPos;
		private double yPos;
		private int time;

		public Waypoint(double x, double y, int time) {
			this.xPos = x;
			this.yPos = y;
			this.time = time;
		}

		public void setX(double x) {
			this.xPos = x;
		}

		public void setY(double y) {
			this.yPos = y;
		}

		public void setTime(int time) {
			this.time = time;
		}

		public double getX() {
			return xPos;
		}

		public double getY() {
			return yPos;
		}

		public int getTime() {
			return time;
		}

		public String toString() {
			return "Waypoint: " + "X:" + xPos + "Y:" + yPos + "time:" + time;
		}
	}
	

	public static void main(String[] args) {
		
		Scanner scan =new Scanner(System.in);
		//create an arrayList with capacity 1000
		ArrayList<Waypoint> waypoint = new ArrayList<Waypoint>(1000);
		GPS gps = new GPS();
		
		//Prompt the user for values of x, y, and t.
		while(true) {
			System.out.println("Enter x point of location:");
			double x = scan.nextDouble();
			if (x<0)
				break;
			System.out.println("Enter y point of location:");
			double y = scan.nextDouble();
			if (y<0)
				break;
			System.out.println("Enter time:");
			int t = scan.nextInt();
			if (t<0)
				break;
			//each time x,t,y is entered, create a new Waypoint object in the waypoint ArrayList
			GPS.Waypoint campSite = gps.new Waypoint(x,y,t);
			waypoint.add(campSite);
		}
		
		//The initial values of x, y, t are 0, 0, 0.
		Waypoint lastpoint = gps.new Waypoint(0,0,0);
		//need to points to calculate the distance
		Waypoint currentpoint = null;
		double distance = 0;
		double totalTime =0;
		
		for (int i=0; i<waypoint.size();i++) {
			//start the loop at second spot because we already have the initial values of x,y,t
			currentpoint = waypoint.get(i);
			distance += Math.sqrt(Math.pow(currentpoint.getX()-lastpoint.getX(),2)+Math.pow(currentpoint.getY()-lastpoint.getY(),2));
			totalTime+=waypoint.get(i).getTime();
			currentpoint=lastpoint;
		}
		
		double milePerHour =(distance/10)/(totalTime/3600);//convert the time into hour and the map scaling factor of 1 = 0.1 miles.
		
		//Round printed values to 2 decimal places
		System.out.println("The hiker traveled "+df.format(distance/10)+" miles.");
		System.out.println("The hiker traveled at a speed of "+df.format(milePerHour)+" MPH");

	}

}
