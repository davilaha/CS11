
/************************************************************
* Lawn.java
* Henry Davila
* hdavilac
* Programming Assignment 1
* 	This program asks the user for input on dimensions of a house and
	the dimensions of the lot in which the house sits on
	to find out the area of its lawn. After finding the area, 
	it asks the user for the mowing speed and calculates the time 
	it will take to mowe the area of the lawn.
************************************************************/

//Import a scanner to read input from keyboard//
import java.util.Scanner;

class Lawn{
	public static void main(String [] args){
		//Declaration of variables of type double and int.//
		double length_lot, width_lot, area_lot;
		double length_house, width_house, area_house;
		double area_lawn;
		double mowing_speed;
		int time_sec;
		int  hour, min, sec;

		Scanner sc = new Scanner(System.in);

		//user input on dimensions for the Lot and calculates the area//
		System.out.print("Enter the width and length of the lot, in feet: ");
		width_lot = sc.nextDouble();
		length_lot = sc.nextDouble();
		area_lot = width_lot*length_lot;

		//user input for the dimensions of the house and calulates the area//
		System.out.print("Enter the width and length of the house, in feet: ");
		width_house = sc.nextDouble();
		length_house = sc.nextDouble();
		area_house = length_house*width_house;

		//The area of the lawn //
		area_lawn = area_lot - area_house;
		System.out.print("The lawn area is ");
		System.out.println(area_lawn + " square feet");

		//user for input on mowing rate to mowe the lawn of the house.//
		System.out.println("Enter the mowing rate, in square feet per second: ");
		mowing_speed = sc.nextDouble();
	
		//This here is what the program will print out on screen(terminal) after calculations//
		// System.out.print("The area of the lot is: ");
		// System.out.println(area_lot + " feet");
		// System.out.print("The area of the house is: ");
		// System.out.println(area_house + " feet");
		// System.out.print("The area of the Lawn is: ");
		// System.out.println(area_lawn + " feet");
		// System.out.print("The mowing speed is: ");
		// System.out.println(mowing_speed + " sq ft per second");
		
		//cast operator to convert values of of one type to the compatible type (int/double)//
		time_sec = ((int)Math.round(area_lawn/mowing_speed)); 
		min = time_sec/60;
		sec = time_sec%60;
		hour = min/60;
		min = min%60; 
		
		//Declaring variables of type String to assign hour, minute, and second + its plurals//
		String h, m, s;
		//the adjustemsts for plurals by using ternary operators to determine what is an hour,//
		//what is a minute and what is a second or hours, minutes and seconds if its 0 or more tha 1. //
		h = (hour == 1) ? hour+" hour ": hour+" hours ";
		m = (min == 1) ? min+" minute ": min+" minutes ";
		s = (sec == 1) ? sec+" second ": sec+" seconds ";

		//time it takes to mowe lawn...
		System.out.print("The mowing time is: ");
		System.out.println(h + m + s);
		
	}
}

// Sequential Execution programing assignment 1 completed// 














