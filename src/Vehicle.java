
public class Vehicle {
	
	private String vehicleId;
	private int year;
	private String make;
	private String model;
	private int numSeats;
	private String vehicleType;
	private String vehicleStatus;
	private RentalRecord[] rentalRecord;
	
	public Vehicle(String vehicleId, int year, String make, String model, int numSeats, String vehicleType,
			String vehicleStatus) {
		this.vehicleId = vehicleId;
		this.year = year;
		this.make = make;
		this.model = model;
		this.numSeats = numSeats;
		this.vehicleType = vehicleType;
		this.vehicleStatus = vehicleStatus;
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

	public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleStatus() {
		return vehicleStatus;
	}

	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}
	
}
