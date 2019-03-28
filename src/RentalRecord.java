import util.DateTime;

public class RentalRecord {

	private String recordId;
	private DateTime rentDate;
	private DateTime estiReturnDate;
	private DateTime actReturnDate;
	private double rentalFee;
	private double lateFee;
	
	public RentalRecord(String recordId, DateTime rentDate, DateTime estiReturnDate, DateTime actReturnDate,
			double rentalFee, double lateFee) {
		this.recordId = recordId;
		this.rentDate = rentDate;
		this.estiReturnDate = estiReturnDate;
		this.actReturnDate = actReturnDate;
		this.rentalFee = rentalFee;
		this.lateFee = lateFee;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public DateTime getRentDate() {
		return rentDate;
	}

	public void setRentDate(DateTime rentDate) {
		this.rentDate = rentDate;
	}

	public DateTime getEstiReturnDate() {
		return estiReturnDate;
	}

	public void setEstiReturnDate(DateTime estiReturnDate) {
		this.estiReturnDate = estiReturnDate;
	}

	public DateTime getActReturnDate() {
		return actReturnDate;
	}

	public void setActReturnDate(DateTime actReturnDate) {
		this.actReturnDate = actReturnDate;
	}

	public double getRentalFee() {
		return rentalFee;
	}

	public void setRentalFee(double rentalFee) {
		this.rentalFee = rentalFee;
	}

	public double getLateFee() {
		return lateFee;
	}

	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}
}
