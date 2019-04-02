import util.DateTime;

public class Car extends Vehicle implements IRentable,IMaintainable{

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
		// TODO Auto-generated method stub
		return false;
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
	
	
	
}
