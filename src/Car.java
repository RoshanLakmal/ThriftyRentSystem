import util.DateTime;

public class Car extends Vehicle implements IRentable,IMaintainable{

	public Car(String vehicleId, int year, String make, String model, int numSeats, String vehicleType,
			String vehicleStatus) {
		super(vehicleId, year, make, model, numSeats, vehicleType, vehicleStatus);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public boolean performMaintenance() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean completeMaintenance() {
		// TODO Auto-generated method stub
		return false;
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
	
	
	
}
