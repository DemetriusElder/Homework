package Cube;
/** This is HW1. Problem 2. 4/30/2022
 * This program creates constructors to set length
 * as well as find volume and surface area
 * Basic assumption is that we want a cube
 */
public class Cube {
	private double x;
	//Allows the creation of object to set length
	public Cube(double sideLength) {
		x = sideLength;
	}//ends Cube
	//Calculates surface area given length
	public double surfaceArea() {
		return x*x*6;
	}//ends surfaceArea
	//calculates volume given length
	public double volume() {
		return Math.pow(x, 3);
	}//ends volume
}//ends class
