package booking_publisher;

public class Booking {
	
	private int bookingID;
	private int DriverID;
	private String bookingDate;
	private String vehicleNo;
	private String customerName;
	private String Description;
	
	
	public Booking() {}
	


	public int getBookingID() {
		return bookingID;
	}


	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}


	public int getDriverID() {
		return DriverID;
	}


	public void setDriverID(int driverID) {
		DriverID = driverID;
	}


	public String getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}


	public String getVehicleNo() {
		return vehicleNo;
	}


	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}

}

