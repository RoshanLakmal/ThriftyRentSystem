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
	
	
}
