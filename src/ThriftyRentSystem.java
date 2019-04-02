import java.util.Scanner;

import util.DateTime;

public class ThriftyRentSystem {

	public void runProgram() {
		
		Vehicle[] vehicles = new Vehicle[50];
		
		
		
		while(true){
			try{
			systemMenu();
			Scanner input = new Scanner(System.in);
			int num = input.nextInt();
			switch(num){
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					System.exit(0);
					break;
				default:
					System.err.println("Invalid Input: Please enter an input between 1 and 7");
					System.out.println("");
					break;
			}
			}catch(Exception e){
				System.err.println("Invalid Input: Please enter a number from the menu");
				System.out.println("");
			}
		}
		/*
//		double value = 200.3456;
//		System.out.printf("Value: %.2f", value);
//		DateTime test = new DateTime();
//		System.out.println(test);
		
		// create a datetime object to store today's date
				DateTime today = new DateTime();
				System.out.println(today); // output: current date
				
				//create any day by passing day month year as integers
				//to a constructor of the DateTime class
				DateTime goodFriday = new DateTime(19, 4, 2019);
				System.out.println(goodFriday); // output: 19/04/2019
				
				//print a datetime in the format suitable for use when constructing
				//a rental record id (more details in assignment specs)
				System.out.println(today.getEightDigitDate()); //output: current date
				System.out.println(goodFriday.getEightDigitDate()); //output: 19042019
				
				//get the name of day of a datetime
				System.out.println(today.getNameOfDay()); // name of the current day
				System.out.println(goodFriday.getNameOfDay()); // Friday
				
				//3 days from now
				DateTime threeDaysFromNow = new DateTime(today, 3);
				System.out.println(threeDaysFromNow);

				//You're encouraged to explore other constructors and methods
				//of the DateTime class
				 * 
				 */
	}
	
	private static void systemMenu(){
		System.out.println("****  ThriftyRent SYSTEM MENU  ****");
		System.out.println("");
		System.out.println("Add vehicle:                      1");
		System.out.println("Rent vehicle:                     2");
		System.out.println("Return vehicle:                   3");
		System.out.println("Vehicle Maintainance:             4");
		System.out.println("Complete Maintainance:            5");
		System.out.println("Display All Vehicle:              6");
		System.out.println("Exit Program:                     7");
		System.out.println("Enter your choice:                 ");
	}
}
