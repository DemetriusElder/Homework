package Change;

import java.util.Scanner;
/** This is HW1. Problem 1. 4/30/2022
 * This program calculates the bills and coins needed to make a certain amount
 */
public class ChangeCalculator {
	
	public static void main(String[] args) {
		//Ask for inputing amount
		System.out.println("Please enter the amount you want to calculate change for : ");
		Scanner scanner = new Scanner(System.in);
		//Declaration of variables
		double amount = scanner.nextDouble();
		double[] change = {20, 10, 5, 2, 1, 0.5, 0.25, 0.1, 0.05, 0.01};
		int temp = 0;
		System.out.println("The fewest denominations you would need to make "+change+" is :");
		//The for loops goes through the array change and performs function
		for(int i = 0; i<=9; i++) {
			/*the temp variable stores the amount of bills or coins need to reach the amount
			 * i.e. for 34 dollars temp is equal to one when looking for 20's
			 */
			temp = (int) (amount/change[i]);
			//These below calculate the amount remainder and set it equal to that and round off to solve the double error
			amount -= temp*change[i];
			amount = Math.round(amount * 100.0) / 100.0;
			//switch statement to print the correct prompt
			switch(i) {
				case 0: System.out.println(""+temp+" twenty dollar bills.");
					break;
				case 1: System.out.println(""+temp+" ten dollar bills.");
					break;
				case 2: System.out.println(""+temp+" five dollar bills.");
					break;
				case 3: System.out.println(""+temp+" two dollar bills.");
					break;
				case 4: System.out.println(""+temp+" one dollar bills.");
					break;
				case 5: System.out.println(""+temp+" fifty cent coins.");
					break;
				case 6: System.out.println(""+temp+" quarters.");
					break;
				case 7: System.out.println(""+temp+" dimes.");
					break;
				case 8: System.out.println(""+temp+" nickles.");
					break;
				case 9: System.out.println(""+temp+" pennies.");
					break;
			}//end switch
		}//end for loop
		scanner.close();
	}//end main

}//end class
