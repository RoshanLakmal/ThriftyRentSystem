import util.DateTime;

public class Car extends Vehicle implements Rentable,Maintainable{

	public Car(String vehicleId, int year, String make, String model, int numSeats,
			String vehicleStatus) {
		super(vehicleId, year, make, model, numSeats, vehicleStatus);
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public boolean rent(String customerId, DateTime rentDate, int numOfRentDay) {
		DateTime today = new DateTime();
		if(DateTime.diffDays(rentDate,today)>0){
			if(this.getStatus().equals("Available")){
				DateTime estiReturnDate = new DateTime(rentDate,numOfRentDay);
					if(numOfRentDay>=2 && numOfRentDay<=14) {
						if(numOfRentDay<3 && (rentDate.getNameOfDay().equals("Friday") || rentDate.getNameOfDay().equals("Saturday"))){
							System.out.println("Can can only be rented for minimum of 3 days for Friday or Saturdarday");
							return false;
						}else{
							this.setStatus("rented");
							String recordId = this.getVehicleId() +"_"+ customerId +"_"+ rentDate.getEightDigitDate();
							RentalRecord myRentalRecord = new RentalRecord(recordId, rentDate, estiReturnDate, null, 0.00, 0.00);
//							int listSize = 0;
//							if(this.getRentalRecord() != null){
//								listSize = this.getRentalRecord().size();
//							}
							int listSize = this.getRentalRecord().size();
									
							if(listSize==10){
								this.getRentalRecord().removeLast();
								this.getRentalRecord().addFirst(myRentalRecord);
							}else{
								this.getRentalRecord().addFirst(myRentalRecord);;
							}
							return true;	
						}		
					}else{
						System.out.println("Car can only be rented for maximum of 14 days and minimum of 2 days if the rental day is between Sunday and Thursday inclusively or minimum of 3 days if the rental day is Friday or Saturday");
						return false;
					}
			}else{
				return false;
			}
		}else{
			System.out.println("Rent date need to be a future date");
			return false;
		}
	}

	@Override
	public boolean returnvehicle(DateTime returnDate) {
		
		
		
		if(this.getStatus().equals("rented")){
			RentalRecord latest = this.getRentalRecord().getLast();
			DateTime rentDate = latest.getRentDate();
			int numOfRentDay =  DateTime.diffDays(returnDate,rentDate);
			int numlateDays = DateTime.diffDays(returnDate,latest.getEstiReturnDate());
			int numestiDays = DateTime.diffDays(latest.getEstiReturnDate(),rentDate);
			if(numOfRentDay>0){
				
				double rentalRate = 0.00;
				double lateFee = 0.00;
				
				if(this.getNumOfSeats() == 4){
					rentalRate =  78 * numestiDays;
				}else{
					rentalRate =  113 * numestiDays;
				}
				
				if(numlateDays>0){
					if(this.getNumOfSeats() == 4){
						lateFee =  (125/100) * 78 * numlateDays;
					}else{
						lateFee =  (125/100) * 113 * numlateDays;
					}
					
				}
				
				rentalRate += lateFee;
				
				this.setStatus("Available");
				latest.setActReturnDate(returnDate);
				latest.setLateFee(lateFee);
				latest.setRentalFee(rentalRate);
				
				return true;
			}else{
				System.out.println("Return date need to be after the rent date");
				return false;
			}
		}else{
			System.out.println("Only rented vehicles can be returned");
			return false;
		}
	}

	@Override
	public boolean performMaintenance() {
		if(this.getStatus().equals("Available")){
			this.setStatus("maintenance");
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean completeMaintenance(DateTime completionDate) {
		if(this.getStatus().equals("maintenance")){
			DateTime today = new DateTime();
			if(DateTime.diffDays(completionDate,today)>=0){
				this.setStatus("Available");
				System.out.println("Vehicle "+this.getVehicleId()+" maintenance complete");
				return true;
			}else{
				System.out.println("Rent date need to be a future date");
				return false;
			}
		}else{
			System.out.println("Can only complete maintain vehicles that are under maintenance");
			return false;
		}
	}
	
	
	
}
