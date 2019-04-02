import java.util.Scanner;

import util.DateTime;

public class ThriftyRentSystem {
	
	public void runProgram() {

		Vehicle[] vehicles = new Vehicle[50];
		int vehicleCounter = 0;
		
		
		while(true){
			
			try{	
			systemMenu();
			Scanner inputMenuItem = new Scanner(System.in);
			int num = inputMenuItem.nextInt();
			
			switch(num){
			
				case 1:
					
					Scanner addVehicleInput = new Scanner(System.in);
					boolean accept = true;
					
					System.out.println("Enter vehicle id:                     ");
					String vehicleId = addVehicleInput.nextLine();
					String vehicleType = vehicleId.substring(0,2);
					
					System.out.println("Enter vehicle year:                   ");
					int vehicleYear = addVehicleInput.nextInt();
					addVehicleInput.nextLine();
					
					System.out.println("Enter vehicle make:                   ");
					String vehicleMake = addVehicleInput.nextLine();
					
					System.out.println("Enter vehicle model:                  ");
					String vehicleModel = addVehicleInput.nextLine();
					
					
					if(vehicleType.equals("C_") || vehicleType.equals("V_")){
						for(Vehicle v : vehicles){
								if(v != null){
									if(v.getVehicleId().equals(vehicleId)){
										System.out.println("");
										System.err.println("Vehicle ID Already Exists: please enter a different vehicle id");
										System.out.println("");
										accept = false;
								}
							}
						}

					}else{
						System.out.println("");
						System.err.println("Invalid Vehicle ID: Vehicle ID need to be starts with C_ for car and V_ for van");
						System.out.println("");
						accept = false;
					}
					
					if(accept){
						if(vehicleType.equals("C_")){
							
							System.out.println("Enter number of seats:                ");
							int vehicleSeats = addVehicleInput.nextInt();
							addVehicleInput.nextLine();
							
							if(vehicleSeats == 4 || vehicleSeats == 7){
								Car myCar = new Car(vehicleId, vehicleYear, vehicleMake, vehicleModel, vehicleSeats, "rent");
								vehicles[vehicleCounter] = myCar;
								vehicleCounter++;
								System.err.println("A car with ID - "+vehicleId+" created.");
							}else {
								System.err.println("A car can have either 4 or 7 passenger seats");
							}
						}else{
							System.out.println("Enter last maintenance date:");
							System.out.println("Enter day:                  ");
							int day = addVehicleInput.nextInt();
							System.out.println("Enter month:                ");
							int month = addVehicleInput.nextInt();
							System.out.println("Enter year:                 ");
							int year = addVehicleInput.nextInt();
							
							int[] numDayMonth = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
							if(day>0 && day <32 && month > 0 && month < 13 && year>0 && day <= numDayMonth[month-1]){
								Van myVan = new Van(vehicleId, vehicleYear, vehicleId, vehicleId, vehicleYear, vehicleId, new DateTime(day,month,year));
								vehicles[vehicleCounter] = myVan;
								vehicleCounter++;
								System.err.println("A van with ID - "+vehicleId+" created.");
							}else{
								System.err.println("Invalid Date");
							}
						}
						System.out.println("Done");
					}
//					DateTime vehicleMaintenanceDay = 
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
				System.err.println("Invalid Input: Please try again...!");
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
