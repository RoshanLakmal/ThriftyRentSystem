import util.DateTime;

public interface Rentable {
	public boolean rent(String customerId, DateTime rentDate, int numOfRentDay);
	public boolean returnvehicle(DateTime returnDate);
}
