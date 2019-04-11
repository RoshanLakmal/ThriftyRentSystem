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
	int maxVehicles = 1;
	
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
		
		
		
		
		
		Car C_1 = new Car("C_1", 2000, "Toyata", "Axio", 4, "rent");
		Car C_2 = new Car("C_2", 2008, "Honda", "Civic", 7, "rent");
		Van V_1 = new Van("V_1", 2010, "Mazda", "MV1", 15, "rent", new DateTime(23,03,2019));
		Van V_2 = new Van("V_2", 2015, "BMW", "K8", 15, "rent", new DateTime(02,02,2019));
		Car C_3 = new Car("C_3", 2007, "Posh", "P1", 7, "rented");
		Van V_3 = new Van("V_3", 1999, "Benz", "Bug", 15, "rented", new DateTime(01,02,2018));
		
		vehicles.put("C_1", C_1);
		vehicles.put("C_2", C_2);
		vehicles.put("V_1", V_1);
		vehicles.put("V_2", V_2);
		vehicles.put("C_3", C_3);
		vehicles.put("V_3", V_3);
//		
//
//		String vehicleId = "C_2";
//		if(vehicles.get(vehicleId).rent("test", new DateTime(24, 04, 2019), 4)){
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
	
	private void addVehicle() throws InvalidUserInput, OutOfBound{

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
							Car myCar = new Car(vehicleId, vehicleYear, vehicleMake, vehicleModel, vehicleSeats, "rent");
							vehicles.put(vehicleId, myCar);
							System.out.println("A car with ID - "+vehicleId+" created.");
						}else {
							System.out.println("");
							throw new InvalidUserInput("A car can only have either 4 or 7 passenger seats");
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
							Van myVan = new Van(vehicleId, vehicleYear, vehicleMake, vehicleModel, 15, "rent", new DateTime(day,month,year));
							vehicles.put(vehicleId, myVan);
							System.out.println("A van with ID - "+vehicleId+" created.");
						}else{
							System.out.println("");
							throw new InvalidUserInput("Invalid Date");
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
		
		String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
		Pattern pattern = Pattern.compile(regex); 
		Matcher matcher = pattern.matcher(rentDate);
		if(matcher.matches()){
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
}
