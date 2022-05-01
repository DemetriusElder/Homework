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
			//if statement to print the correct prompt
			if(i==0) {
				System.out.println(""+temp+" twenty dollar bills.");
			  }
			else if(i==1) {
				System.out.println(""+temp+" ten dollar bills.");
			  }
			else if(i==2) {
				System.out.println(""+temp+" two dollar bills.");
			  }
			else if(i==3) {
				System.out.println(""+temp+" one dollar bills.");
			  }
			else if(i==4) {
				System.out.println(""+temp+" fifty cent coins.");
			  }
			else if(i==5) {
				System.out.println(""+temp+" quarters.");
			  }
			else if(i==6) {
				System.out.println(""+temp+" dimes.");
			  }
			else if(i==7) {
				System.out.println(""+temp+" nickles.");
			  }
			else if(i==8) {
				System.out.println(""+temp+" pennies.");
			  }
			else if(i==9) {
			  }
		}//end for loop
		scanner.close();
	}//end main

}//end class
