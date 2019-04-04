import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import exception.InvalidUserInput;
import util.DateTime;

public class ThriftyRentSystem {
	
	HashMap<String,Vehicle> vehicles = new HashMap<>();
	
	public void runProgram() {

//		Vehicle[] vehicles = new Vehicle[50];
		int vehicleCounter = 0;
		
		while(true){
			
			try{	
			systemMenu();
			Scanner inputMenuItem = new Scanner(System.in);
			int num = inputMenuItem.nextInt();
			
			switch(num){
			
				case 1:
					addVehicle();
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
					System.out.println("");
					System.out.println("Invalid Input: Please enter an input between 1 and 7");
					System.out.println("");
					break;
			}
			}catch(InvalidUserInput e1){
				System.out.println("");
				System.out.println("Invalid Input: Please try again...!");
				System.out.println(e1.getMessage());
				System.out.println("");
			}catch(Exception e){
				System.out.println("");
				System.out.println("Invalid Input: Please try again...!");
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
	
	private void systemMenu(){
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
	
	private void addVehicle() throws InvalidUserInput{

		Scanner addVehicleInput = new Scanner(System.in);
		boolean accept = true;
		

		System.out.println("Enter vehicle id:                     ");
		System.out.println("Do you want to Generate automatically? Yes : No");
		String userInp = addVehicleInput.nextLine();
		String vehicleId = "";
		
		if(userInp.toUpperCase().equals("YES")){
			System.out.println("Do you wan to add a Car or Van? Car: Van");
			String temp = addVehicleInput.nextLine();
			if(temp.toUpperCase().equals("CAR")){
				vehicleId = "C_"+genRanId();
			}else if(temp.toUpperCase().equals("VAN")){
				vehicleId = "V_"+genRanId();
			}else{
				throw new InvalidUserInput("Input need to be Car or Van");
			}
		}else if(userInp.equals("No")){
			vehicleId = addVehicleInput.nextLine();
		}else{
			throw new InvalidUserInput("Input need to be Yes or No");
		}

		String vehicleType = vehicleId.substring(0,2);
		
		System.out.println("Enter vehicle year:                   ");
		int vehicleYear = addVehicleInput.nextInt();
		addVehicleInput.nextLine();
		
		System.out.println("Enter vehicle make:                   ");
		String vehicleMake = addVehicleInput.nextLine();
		
		System.out.println("Enter vehicle model:                  ");
		String vehicleModel = addVehicleInput.nextLine();
		
		
//		if(vehicleType.equals("C_") || vehicleType.equals("V_")){
////			vehicles.containsKey(key);
////			for(Vehicle v : vehicles){
////					if(v != null){
////						if(v.getVehicleId().equals(vehicleId)){
////							System.out.println("");
////							System.out.println("Vehicle ID Already Exists: please enter a different vehicle id");
////							System.out.println("");
////							accept = false;
////					}
////				}
////			}
//
//		}else{
//			System.out.println("");
//			System.out.println("Invalid Vehicle ID: Vehicle ID need to be starts with C_ for car and V_ for van");
//			System.out.println("");
//			accept = false;
//		}
		
//		if(accept){
//			if(vehicleType.equals("C_")){
//				
//				System.out.println("Enter number of seats:                ");
//				int vehicleSeats = addVehicleInput.nextInt();
//				addVehicleInput.nextLine();
//				
//				if(vehicleSeats == 4 || vehicleSeats == 7){
//					Car myCar = new Car(vehicleId, vehicleYear, vehicleMake, vehicleModel, vehicleSeats, "rent");
//					vehicles[vehicleCounter] = myCar;
//					vehicleCounter++;
//					System.out.println("A car with ID - "+vehicleId+" created.");
//				}else {
//					System.out.println("");
//					System.out.println("A car can only have either 4 or 7 passenger seats");
//					System.out.println("");
//				}
//			}else{
//				System.out.println("Enter last maintenance date:");
//				System.out.println("Enter day:                  ");
//				int day = addVehicleInput.nextInt();
//				System.out.println("Enter month:                ");
//				int month = addVehicleInput.nextInt();
//				System.out.println("Enter year:                 ");
//				int year = addVehicleInput.nextInt();
//				
//				int[] numDayMonth = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//				if(day>0 && day <32 && month > 0 && month < 13 && year>0 && day <= numDayMonth[month-1]){
//					Van myVan = new Van(vehicleId, vehicleYear, vehicleId, vehicleId, vehicleYear, vehicleId, new DateTime(day,month,year));
//					vehicles[vehicleCounter] = myVan;
//					vehicleCounter++;
//					System.out.println("A van with ID - "+vehicleId+" created.");
//				}else{
//					System.out.println("");
//					System.out.println("Invalid Date");
//					System.out.println("");
//				}
//			}
//			System.out.println("Done");
//		} 
	}
	
	private int genRanId(){
		int randNum = 10000 + new Random().nextInt(9000);
		return randNum;
	}
}
