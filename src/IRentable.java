import util.DateTime;

public interface IRentable {
	public boolean rent(String customerId, DateTime rentDate, int numOfRentDay);
	public boolean returnvehicle(DateTime returnDate);
}
