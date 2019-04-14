import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.InvalidPattern;
import exception.InvalidUserInput;
import exception.NotFound;
import exception.OutOfBound;
import util.DateTime;

public class ThriftyRentSystem {
	
	HashMap<String,Vehicle> vehicles = new HashMap<>();
	int maxVehicles = 50;
	
	public void runProgram() {
//		DateTime today = new DateTime(12, 4, 2019);
//		DateTime test = new DateTime(11, 4, 2019);
//		System.out.println("Today - "+today);
//		System.out.println("test - "+test);
//		System.out.println(DateTime.diffDays(test,today));
////		DateTime goodFriday = new DateTime(19, 4, 2019);
//		String rentDate = "31/12/2001";
//		String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
//		Pattern pattern = Pattern.compile(regex); 
//		Matcher matcher = pattern.matcher(rentDate);
//		if(matcher.matches()){
//			System.out.println("yes");
//		}else{
//			System.out.println("No");
//		}
		
//		Scanner test = new Scanner(System.in);
//		System.out.println("Enter vehicle id:                     ");
//		String vehicleId = "C_2";
//		if(vehicles.get(vehicleId).rent("test", new DateTime(24, 04, 2019), 4)){
//			System.out.println("Yes");
//		}else{
//			System.out.println("No");
//		}
//
//		String vehicleId = "V_3";
//		if(vehicles.get(vehicleId).returnvehicle(new DateTime(24, 04, 2019))){
//			System.out.println("Yes");
//		}else{
//			System.out.println("No");
//		}		
		
		
		
		
 


		
		
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
					rentVehicle();
					break;
				case 3:
					returnVehicle();
					break;
				case 4:
					maintainVehicle();
					break;
				case 5:
					completeVehicleMaintenance();
					break;
				case 6:
					displayAllVehiclesFormat();
//					for (HashMap.Entry<String,Vehicle> entry : vehicles.entrySet()) {
//					    System.out.println(entry.getKey()+" : "+entry.getValue().getStatus()+" : "+entry.getValue().getNumOfSeats());
//					    for(int i=0;i<entry.getValue().getRentalRecord().size();i++){
//					    	System.out.println(entry.getValue().getRentalRecord().get(i).getRecordId());
//					    	System.out.println(entry.getValue().getRentalRecord().get(i).getRentDate());
//					    	System.out.println(entry.getValue().getRentalRecord().get(i).getEstiReturnDate());
//					    	System.out.println(entry.getValue().getRentalRecord().get(i).getActReturnDate());
//					    	System.out.println(entry.getValue().getRentalRecord().get(i).getRentalFee());
//					    	System.out.println(entry.getValue().getRentalRecord().get(i).getLateFee());
//					    }
//					} 
//					System.out.println(vehicles);
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
			}catch(OutOfBound e2){
				System.out.println("");
				System.out.println("Limit exceeds: Please try again...!");
				System.out.println(e2.getMessage());
				System.out.println("");
			}catch(InvalidPattern e3){
				System.out.println("");
				System.out.println("Invalid pattern: Please try again...!");
				System.out.println(e3.getMessage());
				System.out.println("");
			}catch(NotFound e4){
				System.out.println("");
				System.out.println("Not found: Please try again...!");
				System.out.println(e4.getMessage());
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
	
	private void addVehicle() throws InvalidUserInput, OutOfBound, InvalidPattern{

		Scanner addVehicleInput = new Scanner(System.in);

		if(vehicles.size() < maxVehicles){
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
				boolean vehicleContain = vehicles.containsKey(vehicleId);
				if(!vehicleContain){
					if(vehicleType.equals("C_")){
						System.out.println("Enter number of seats:                ");
						int vehicleSeats = addVehicleInput.nextInt();
						addVehicleInput.nextLine();
						
						if(vehicleSeats == 4 || vehicleSeats == 7){
							Car myCar = new Car(vehicleId, vehicleYear, vehicleMake, vehicleModel, vehicleSeats, "Available");
							vehicles.put(vehicleId, myCar);
							System.out.println(myCar.toString());
						}else {
							System.out.println("");
							throw new InvalidUserInput("A car can only have either 4 or 7 passenger seats");
						}
					}else{
						System.out.println("Enter last maintenance date(dd/mm/yyyy):");
						String lastMaintenance = addVehicleInput.nextLine();
						
						if(matchDateFormat(lastMaintenance)){
							int day = Integer.parseInt(lastMaintenance.substring(0,2));
							int month = Integer.parseInt(lastMaintenance.substring(3,5));
							int year = Integer.parseInt(lastMaintenance.substring(6,lastMaintenance.length()));
							
							DateTime lastMaintDateFormat = new DateTime(day, month, year);
							Van myVan = new Van(vehicleId, vehicleYear, vehicleMake, vehicleModel, 15, "Available", lastMaintDateFormat);
							vehicles.put(vehicleId, myVan);
							System.out.println(myVan.toString());
						}else{
							System.out.println("");
							throw new InvalidPattern("Date need to be dd/mm/yyyy format...!");
						}
					}
				}else{
					System.out.println("");
					throw new InvalidUserInput("Vehicle ID Already Exists: please enter a different vehicle id");
				}
			}else{
				System.out.println("");
				throw new InvalidUserInput("Invalid Vehicle ID: Vehicle ID need to be starts with C_ for car and V_ for van");
			}
		}else{
			System.out.println("");
			throw new OutOfBound("Cannot add any more vehicles the system is full...!");
		}
		
	}
	
	private void rentVehicle() throws InvalidPattern, NotFound{
		displayAllVehiclesAvailable("Available");
		Scanner rentVehicleInput = new Scanner(System.in);
		
		System.out.println("Enter vehicle id:                     ");
		String vehicleId = rentVehicleInput.nextLine();

		System.out.println("Enter customer id:                     ");
		String customerId = rentVehicleInput.nextLine();
		
		System.out.println("Enter rent date(dd/mm/yyyy):                     ");
		String rentDate = rentVehicleInput.nextLine();
		
		System.out.println("Enter how many days?:                   ");
		int rentDays = rentVehicleInput.nextInt();
		rentVehicleInput.nextLine();
		
		
		if(matchDateFormat(rentDate)){
			int day = Integer.parseInt(rentDate.substring(0,2));
			int month = Integer.parseInt(rentDate.substring(3,5));
			int year = Integer.parseInt(rentDate.substring(6,rentDate.length()));
			
			DateTime rentDateFormat = new DateTime(day, month, year);
			if(vehicles.containsKey(vehicleId)){
				if(vehicles.get(vehicleId).rent(customerId, rentDateFormat, rentDays)){
					System.out.println("Vehicle " + vehicleId + " is now rented by customer " +customerId);
				}else{
					System.out.println("Vehicle " + vehicleId + " could not be rented");
				}
			}else{
				System.out.println("");
				throw new NotFound("vehicle Id not found...!");
			}
		}else{
			System.out.println("");
			throw new InvalidPattern("Date need to be dd/mm/yyyy format...!");
		}
	}
	
	private void returnVehicle() throws InvalidPattern, NotFound{
		displayAllVehiclesAvailable("Rented");
		Scanner returnVehicleInput = new Scanner(System.in);
		
		System.out.println("Enter vehicle id:                     ");
		String vehicleId = returnVehicleInput.nextLine();
		
		System.out.println("Enter return date(dd/mm/yyyy):                     ");
		String actReturnDate = returnVehicleInput.nextLine();
		
		if(matchDateFormat(actReturnDate)){
			int day = Integer.parseInt(actReturnDate.substring(0,2));
			int month = Integer.parseInt(actReturnDate.substring(3,5));
			int year = Integer.parseInt(actReturnDate.substring(6,actReturnDate.length()));
			
			DateTime returnDateFormat = new DateTime(day, month, year);
			if(vehicles.containsKey(vehicleId)){
				if(vehicles.get(vehicleId).returnvehicle(returnDateFormat)){
					System.out.println("Vehicle " + vehicleId + " is now returned");
				}else{
					System.out.println("Vehicle " + vehicleId + " could not be returned");
				}
			}else{
				System.out.println("");
				throw new NotFound("vehicle Id not found...!");
			}
		}else{
			System.out.println("");
			throw new InvalidPattern("Date need to be dd/mm/yyyy format...!");
		}
	}
	
	private void maintainVehicle() throws NotFound{
		displayAllVehiclesAvailable("Available");
		Scanner  maintainVehicleInput = new Scanner(System.in);
		
		System.out.println("Enter vehicle id:                     ");
		String vehicleId = maintainVehicleInput.nextLine();
		
		if(vehicles.containsKey(vehicleId)){
			if(vehicles.get(vehicleId).performMaintenance()){
				System.out.println("Vehicle "+vehicleId+" is now under maintenance");
			}else{
				System.out.println("Vehicle " + vehicleId + " could not be maintained");
			}
		}else{
			System.out.println("");
			throw new NotFound("vehicle Id not found...!");
		}
	}
	
	private void completeVehicleMaintenance() throws NotFound, InvalidPattern{
		displayAllVehiclesAvailable("Maintenance");
		Scanner completeVehicleMainInput = new Scanner(System.in);
		
		System.out.println("Enter vehicle id:                     ");
		String vehicleId = completeVehicleMainInput.nextLine();
		
		System.out.println("Enter complete maintenance date(dd/mm/yyyy):                     ");
		String actReturnDate = completeVehicleMainInput.nextLine();
		
		
		if(matchDateFormat(actReturnDate)){
			int day = Integer.parseInt(actReturnDate.substring(0,2));
			int month = Integer.parseInt(actReturnDate.substring(3,5));
			int year = Integer.parseInt(actReturnDate.substring(6,actReturnDate.length()));
			
			DateTime returnDateFormat = new DateTime(day, month, year);
			if(vehicles.containsKey(vehicleId)){
				if(vehicles.get(vehicleId).completeMaintenance(returnDateFormat)){
					System.out.println("Vehicle " + vehicleId + " has all maintainance completed and ready for rent");
				}else{
					System.out.println("Vehicle " + vehicleId + " could not complete maintenance");
				}
			}else{
				System.out.println("");
				throw new NotFound("vehicle Id not found...!");
			}
		}else{
			System.out.println("");
			throw new InvalidPattern("Date need to be dd/mm/yyyy format...!");
		}
		
	}

	private boolean matchDateFormat(String rentDate){
		String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
		Pattern pattern = Pattern.compile(regex); 
		Matcher matcher = pattern.matcher(rentDate);
		if(matcher.matches()){
			return true;
		}else{
			return false;
		}
	}
	
	private void displayAllVehiclesFormat() {
		for (HashMap.Entry<String,Vehicle> entry : vehicles.entrySet()) {
			System.out.println(entry.getValue().getDetails());
//		    System.out.println(entry.getKey()+" : "+entry.getValue().getStatus()+" : "+entry.getValue().getNumOfSeats());
//		    for(int i=0;i<entry.getValue().getRentalRecord().size();i++){
//		    	
//		    }
		} 
//		System.out.println(vehicles);
	}
	
	private void displayAllVehiclesAvailable(String status) {
		for (HashMap.Entry<String,Vehicle> entry : vehicles.entrySet()) {
			if(entry.getValue().getStatus().equals(status)){
				System.out.println(entry.getValue().toString());
			}
		} 
	}
}
