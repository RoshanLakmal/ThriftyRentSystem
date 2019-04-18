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

	//Hashmpa to store all the vehicles objects.
	HashMap<String,Vehicle> vehicles = new HashMap<>();
	int maxVehicles = 50;
	
	
	public void runProgram() {

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
	}
	
	//Main Menu
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
	
	
	// addVehicle method - To add vehicles to the system. 
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
			
			
			//Validating the vehicleId.
			if(vehicleType.equals("C_") || vehicleType.equals("V_")){
				
				boolean vehicleContain = vehicles.containsKey(vehicleId);
				
				if(!vehicleContain){
					if(vehicleType.equals("C_")){
						
						System.out.println("Enter number of seats:                ");
						int vehicleSeats = addVehicleInput.nextInt();
						addVehicleInput.nextLine();
						
						//Validating the vehicle seats
						if(vehicleSeats == 4 || vehicleSeats == 7){
							
							//Creating a car object. 
							Car myCar = new Car(vehicleId, vehicleYear, vehicleMake, vehicleModel, vehicleSeats, "Available");
							
							//Adding the car object to the hashmap puting vehicle Id as the key. 
							vehicles.put(vehicleId, myCar);
							System.out.println(myCar.toString());
							
						}else {
							
							System.out.println("");
							throw new InvalidUserInput("A car can only have either 4 or 7 passenger seats");
							
						}
					}else{
						
						System.out.println("Enter last maintenance date(dd/mm/yyyy):");
						String lastMaintenance = addVehicleInput.nextLine();
						
						//Validating the date format. 
						if(matchDateFormat(lastMaintenance)){
							
							int day = Integer.parseInt(lastMaintenance.substring(0,2));
							int month = Integer.parseInt(lastMaintenance.substring(3,5));
							int year = Integer.parseInt(lastMaintenance.substring(6,lastMaintenance.length()));
							
							DateTime lastMaintDateFormat = new DateTime(day, month, year);
							//Creating a Van object.
							Van myVan = new Van(vehicleId, vehicleYear, vehicleMake, vehicleModel, 15, "Available", lastMaintDateFormat);
							
							//Adding the van object to the hashmap puting vehicle Id as the key.
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
	
	
	//rentVehicle method - To rent vehicles in the system. 
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
		
		//Validating the date format. 
		if(matchDateFormat(rentDate)){
			
			int day = Integer.parseInt(rentDate.substring(0,2));
			int month = Integer.parseInt(rentDate.substring(3,5));
			int year = Integer.parseInt(rentDate.substring(6,rentDate.length()));
			
			DateTime rentDateFormat = new DateTime(day, month, year);
			
			//Checking the vehicleId
			if(vehicles.containsKey(vehicleId)){
				//Calling the rent function to check whether the vehicle can be rented. 
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
	
	
	//returnVehicle method - To return a vehicle back to the system. 
	private void returnVehicle() throws InvalidPattern, NotFound{
		
		displayAllVehiclesAvailable("Rented");
		Scanner returnVehicleInput = new Scanner(System.in);
		
		System.out.println("Enter vehicle id:                     ");
		String vehicleId = returnVehicleInput.nextLine();
		
		System.out.println("Enter return date(dd/mm/yyyy):                     ");
		String actReturnDate = returnVehicleInput.nextLine();
		
		//Validate date format. 
		if(matchDateFormat(actReturnDate)){
			
			int day = Integer.parseInt(actReturnDate.substring(0,2));
			int month = Integer.parseInt(actReturnDate.substring(3,5));
			int year = Integer.parseInt(actReturnDate.substring(6,actReturnDate.length()));
			
			DateTime returnDateFormat = new DateTime(day, month, year);
			
			//Checking for vehicleId in the system. 
			if(vehicles.containsKey(vehicleId)){
				
				//Checking whether the vehicle can be returned. 
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
	
	
	// maintain method - To add the vehicle to maintaince. 
	private void maintainVehicle() throws NotFound{
		
		displayAllVehiclesAvailable("Available");
		Scanner  maintainVehicleInput = new Scanner(System.in);
		
		System.out.println("Enter vehicle id:                     ");
		String vehicleId = maintainVehicleInput.nextLine();
		
		//Checking for the vhicle id.
		if(vehicles.containsKey(vehicleId)){
			
			//Checking to perform maintenance. 
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
	
	//Complete maintenance of the vehicle. 
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

	//Chekcing the dateFormat
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
	
	//Display Vehicleformat
	private void displayAllVehiclesFormat() {
		for (HashMap.Entry<String,Vehicle> entry : vehicles.entrySet()) {
			System.out.println(entry.getValue().getDetails());
		} 
	}
	
	//Display all vehicle. 
	private void displayAllVehiclesAvailable(String status) {
		for (HashMap.Entry<String,Vehicle> entry : vehicles.entrySet()) {
			if(entry.getValue().getStatus().equals(status)){
				System.out.println(entry.getValue().toString());
			}
		} 
	}
}
