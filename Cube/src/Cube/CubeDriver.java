package Cube;
import java.util.Scanner;
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
		System.out.println("The surface area is: "+ inputCube.surfaceArea());
		System.out.println("The volume is: "+ inputCube.volume());
		scanner.close();
	}//ends main

}//ends class
