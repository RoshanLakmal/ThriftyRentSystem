import util.DateTime;

public class Van extends Vehicle implements Rentable,Maintainable{

	private DateTime lastMaintenance;
	
	public Van(String vehicleId, int year, String make, String model, int numSeats,
			String vehicleStatus, DateTime lastMaintenance) {
		super(vehicleId, year, make, model, numSeats, vehicleStatus);
		this.lastMaintenance = lastMaintenance;
	}



	@Override
	public boolean rent(String customerId, DateTime rentDate, int numOfRentDay) {

		DateTime today = new DateTime();
		if(DateTime.diffDays(rentDate,today)>0){
			if(this.getStatus().equals("Available")){
				DateTime estiReturnDate = new DateTime(rentDate,numOfRentDay);
					if(numOfRentDay>=1 && numOfRentDay<=30) {
						if(DateTime.diffDays(estiReturnDate,lastMaintenance)>=0 && DateTime.diffDays(lastMaintenance, rentDate) >= 0){
							System.out.println("Renting is not allowed due to Van maintenance due on "+lastMaintenance + " please select another day...!");
							return false;
						}else{
							this.setStatus("Rented");
							String recordId = this.getVehicleId() + "_" +customerId + "_" + rentDate.getEightDigitDate();
							RentalRecord myRentalRecord = new RentalRecord(recordId, rentDate, estiReturnDate, null, 0.00, 0.00);
							System.out.println("Rental record created");
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
		
		
		if(this.getStatus().equals("Rented")){
			RentalRecord latest = this.getRentalRecord().getFirst();
			DateTime rentDate = latest.getRentDate();
			int numOfRentDay =  DateTime.diffDays(returnDate,rentDate);
			int numlateDays = DateTime.diffDays(returnDate,latest.getEstiReturnDate());
			int numestiDays = DateTime.diffDays(latest.getEstiReturnDate(),rentDate);
			if(numOfRentDay>0){
				double rentalRate = 235 * numestiDays;	
				double lateFee = 0.00;
				
				if(numlateDays>0){
					lateFee = 299 * numlateDays;
				}
				
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
			this.setStatus("Maintenance");
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean completeMaintenance(DateTime completionDate) {
		if(this.getStatus().equals("Maintenance")){
			DateTime today = new DateTime();
			if(DateTime.diffDays(completionDate,today)>=0){
				this.setStatus("Available");
				this.lastMaintenance = completionDate;
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
	
	@Override
	public String toString() {
		return getVehicleId()+":"+getYear()+":"+getMake()+":"+getModel()+":"+getNumOfSeats()+":"+getStatus()+":"+lastMaintenance;
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
			for(int i = 0; i <getRentalRecord().size();i++){
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
