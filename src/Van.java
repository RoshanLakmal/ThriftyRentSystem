import util.DateTime;

public class Van extends Vehicle{

	private DateTime lastMaintenance;
	
	public Van(String vehicleId, int year, String make, String model, int numSeats, String vehicleType,
			String vehicleStatus, DateTime lastMaintenance) {
		super(vehicleId, year, make, model, numSeats, vehicleType, vehicleStatus);
		this.lastMaintenance = lastMaintenance;
	}

	@Override
	public String toString() {
		return this.getVehicleId()+":"+this.getYear()+":"+this.getMake()+":"+this.getModel()+":"+this.getNumOfSeats()+":"+this.getStatus()+":"+this.lastMaintenance;
	}

	@Override
	public String getDetails() {
		String details = 
				"Vehicle ID:     "+this.getVehicleId()+"\n"+
				"Year:           "+this.getYear()+"\n"+
				"Make:           "+this.getMake()+"\n"+
				"Model           "+this.getModel()+"\n"+
				"Number of seats:"+this.getNumOfSeats()+"\n"+
				"Status:         "+this.getStatus()+"\n"+
				"Last maintenance date:         "+this.lastMaintenance+"\n";
		if(this.getRentalRecord().isEmpty()){
			details += "RENTAL RECORD:         "+"empty";
		}else{
			details += "RENTAL RECORD:         "+"\n";
			for(int i =this.getRentalRecord().size()-1 ; i>0;i--){
				details += "Record ID:         "+this.getRentalRecord().get(i).getRecordId()+"\n"+
						   "Rent Date:         "+this.getRentalRecord().get(i).getRentDate()+"\n"+
						   "Estimated Return Date:         "+this.getRentalRecord().get(i).getEstiReturnDate()+"\n";
				if(this.getRentalRecord().get(i).getRentalFee()==0){
					details += "-------------------------------------------------------------------"+"\n";
					break;
				}else{
					details += "Actual Return Date:         "+this.getRentalRecord().get(i).getActReturnDate()+"\n"+
					           "Rental Fee:         "+this.getRentalRecord().get(i).getRentalFee()+"\n"+
					           "Late Fee:         "+this.getRentalRecord().get(i).getLateFee()+"\n"+
					           "-------------------------------------------------------------------"+"\n";
				}
			}
		}
		return details;
	}
	
	
	
}
