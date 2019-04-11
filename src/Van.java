import util.DateTime;

public class Van extends Vehicle implements Rentable,Maintainable{

	private DateTime lastMaintenance;
	
	public Van(String vehicleId, int year, String make, String model, int numSeats,
			String vehicleStatus, DateTime lastMaintenance) {
		super(vehicleId, year, make, model, numSeats, vehicleStatus);
		this.lastMaintenance = lastMaintenance;
	}

	@Override
	public String toString() {
		return getVehicleId()+":"+getYear()+":"+getMake()+":"+getModel()+":"+getNumOfSeats()+":"+getStatus()+":"+lastMaintenance;
	}

	@Override
	public boolean rent(String customerId, DateTime rentDate, int numOfRentDay) {

		DateTime today = new DateTime();
		if(DateTime.diffDays(rentDate,today)>0){
			if(this.getStatus().equals("rent")){
				DateTime estiReturnDate = new DateTime(rentDate,numOfRentDay);
					if(numOfRentDay>=1 && numOfRentDay<=30) {
						double rentalRate = 235 * numOfRentDay;	
						this.setStatus("rented");
						String recordId = this.getVehicleId() + customerId + rentDate.getEightDigitDate();
						RentalRecord myRentalRecord = new RentalRecord(recordId, rentDate, estiReturnDate, null, rentalRate, 0.00);
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
						System.out.println("Van can only be rented for minimum of 1 day and maximum of 30 days");
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
		// TODO Auto-generated method stub
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
	
	@Override
	public String getDetails() {
		String details = 
				"Vehicle ID:     "+getVehicleId()+"\n"+
				"Year:           "+getYear()+"\n"+
				"Make:           "+getMake()+"\n"+
				"Model           "+getModel()+"\n"+
				"Number of seats:"+getNumOfSeats()+"\n"+
				"Status:         "+getStatus()+"\n"+
				"Last maintenance date:         "+lastMaintenance+"\n";
		if(this.getRentalRecord().isEmpty()){
			details += "RENTAL RECORD:         "+"empty";
		}else{
			details += "RENTAL RECORD:         "+"\n";
			for(int i =getRentalRecord().size()-1 ; i>0;i--){
				details += "Record ID:         "+getRentalRecord().get(i).getRecordId()+"\n"+
						   "Rent Date:         "+getRentalRecord().get(i).getRentDate()+"\n"+
						   "Estimated Return Date:         "+getRentalRecord().get(i).getEstiReturnDate()+"\n";
				if(getRentalRecord().get(i).getRentalFee()==0){
					details += "-------------------------------------------------------------------"+"\n";
					break;
				}else{
					details += "Actual Return Date:         "+getRentalRecord().get(i).getActReturnDate()+"\n"+
					           "Rental Fee:         "+getRentalRecord().get(i).getRentalFee()+"\n"+
					           "Late Fee:         "+getRentalRecord().get(i).getLateFee()+"\n"+
					           "-------------------------------------------------------------------"+"\n";
				}
			}
		}
		return details;
	}
	
}
