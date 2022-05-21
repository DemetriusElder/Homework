package Cube;
import java.util.Scanner;
import java.io.*;
/** This is HW1. Problem 3. 4/30/2022
 * This program is to act as a driver class to test the cube class
 */
public class CubeDriver{

	public static void main(String[] args) {
		System.out.println("Please input the side length of your cube.");
		//Accepts user input and stores it in length
		Scanner scanner = new Scanner(System.in);
		double length = scanner.nextDouble();
		//initiates the inputcube variable calling the Cube constructor
		Cube inputCube = new Cube(length);
		//Pritns out the results of the called methods surfaceArea and volume
		System.out.printf("The surface area is: %.3f %n", inputCube.surfaceArea());
		System.out.printf("The volume is: %.3f %n", inputCube.volume());
		scanner.close();
	}//ends main

}//ends class
