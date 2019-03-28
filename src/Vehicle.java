import java.util.Arrays;

public abstract class Vehicle {
	
	private String vehicleId;
	private int year;
	private String make;
	private String model;
	private int numOfSeats;
	private String type;
	private String status;
	private RentalRecord[] rentalRecord;
	
	public Vehicle(String vehicleId, int year, String make, String model, int numSeats, String vehicleType,
			String vehicleStatus) {
		this.vehicleId = vehicleId;
		this.year = year;
		this.make = make;
		this.model = model;
		this.numOfSeats = numSeats;
		this.type = vehicleType;
		this.status = vehicleStatus;
		this.rentalRecord = new RentalRecord[10];
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public RentalRecord[] getRentalRecord() {
		return rentalRecord;
	}

	public void setRentalRecord(RentalRecord[] rentalRecord) {
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
		if(rentalRecord.length == 0 || rentalRecord == null){
			details += "RENTAL RECORD:         "+"empty";
		}else{
			details += "RENTAL RECORD:         "+"\n";
			for(int i = 0; i<rentalRecord.length;i++){
				details += "RENTAL RECORD:         "+"\n";
			}
		}
		return details;
	}
	
	
}
