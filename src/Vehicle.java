import java.util.LinkedList;

public abstract class Vehicle {
	
	private String vehicleId;
	private int year;
	private String make;
	private String model;
	private int numOfSeats;
	private String status;
	private LinkedList<RentalRecord> rentalRecord;
	
	public Vehicle(String vehicleId, int year, String make, String model, int numSeats,
			String vehicleStatus) {
		this.vehicleId = vehicleId;
		this.year = year;
		this.make = make;
		this.model = model;
		this.numOfSeats = numSeats;
		this.status = vehicleStatus;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getNumOfSeats() {
		return numOfSeats;
	}

	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LinkedList<RentalRecord> getRentalRecord() {
		return rentalRecord;
	}

	public void setRentalRecord(LinkedList<RentalRecord> rentalRecord) {
		this.rentalRecord = rentalRecord;
	}

	public String toString() {
		//"vehicleId:year:make:model:numOfSeats:status"
		return vehicleId+":"+year+":"+make+":"+model+":"+numOfSeats+":"+status;
	}
	
	public String getDetails() {
		String details = 
				"Vehicle ID:     "+this.vehicleId+"\n"+
				"Year:           "+this.year+"\n"+
				"Make:           "+this.make+"\n"+
				"Model           "+this.model+"\n"+
				"Number of seats:"+this.numOfSeats+"\n"+
				"Status:         "+this.status+"\n";
		if(rentalRecord.isEmpty()){
			details += "RENTAL RECORD:         "+"empty";
		}else{
			details += "RENTAL RECORD:         "+"\n";
			for(int i =rentalRecord.size()-1 ; i>0;i--){
				details += "Record ID:         "+rentalRecord.get(i).getRecordId()+"\n"+
						   "Rent Date:         "+rentalRecord.get(i).getRentDate()+"\n"+
						   "Estimated Return Date:         "+rentalRecord.get(i).getEstiReturnDate()+"\n";
				if(rentalRecord.get(i).getRentalFee()==0){
					details += "-------------------------------------------------------------------"+"\n";
					break;
				}else{
					details += "Actual Return Date:         "+rentalRecord.get(i).getActReturnDate()+"\n"+
					           "Rental Fee:         "+rentalRecord.get(i).getRentalFee()+"\n"+
					           "Late Fee:         "+rentalRecord.get(i).getLateFee()+"\n"+
					           "-------------------------------------------------------------------"+"\n";
				}
			}
		}
		return details;
	}
	
	
}
