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
		if(this.getStatus().equals("rented") || this.getStatus().equals("maintenance")){
			return false;
		}else{
			this.setStatus("rented");
			new RentalRecord(customerId, rentDate, rentDate, rentDate, numOfRentDay, numOfRentDay);
			return true;
		}
		// TODO Auto-generated method stub
		
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
