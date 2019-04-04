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
		if(this.getStatus().equals("rent")){
			DateTime estiReturnDate = new DateTime(rentDate,numOfRentDay);
				if(numOfRentDay<=14 && (numOfRentDay>=2 && rentDate.getNameOfDay().equals("Sunday") || rentDate.getNameOfDay().equals("Monday") || rentDate.getNameOfDay().equals("Tuesday") || rentDate.getNameOfDay().equals("Wednesday") || rentDate.getNameOfDay().equals("Thursday")) || (numOfRentDay>=3 && rentDate.getNameOfDay().equals("Friday") || rentDate.getNameOfDay().equals("Saturday"))){
						
						double rentalRate = 0.00;
						
						if(this.getNumOfSeats() == 4){
							rentalRate =  78 * numOfRentDay;
						}else{
							rentalRate =  113 * numOfRentDay;
						}
						
						this.setStatus("rented");
						RentalRecord myRentalRecord = new RentalRecord(customerId, rentDate, estiReturnDate, null, rentalRate, 0.00);
						System.out.println("Rental record created");
						int listSize = this.getRentalRecord().size();
						if(listSize==10){
							this.getRentalRecord().removeLast();
							this.getRentalRecord().addFirst(myRentalRecord);
						}else{
							this.getRentalRecord().addFirst(myRentalRecord);;
						}
						return true;	
				}else{
					System.out.println("Car can only be rented for maximum of 14 days and minimum of 2 days if the rental day is between Sunday and Thursday inclusively or minimum of 3 days if the rental day is Friday or Saturday");
					return false;
				}
		}else{
			return false;
		}
		
	}

	@Override
	public boolean returnvehicle(DateTime returnDate) {
		int dayDiff = DateTime.diffDays(endDate, startDate)
		if(){
			
		}
		return false;
	}

	@Override
	public boolean performMaintenance() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean completeMaintenance(DateTime completionDate) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
