package booking_publisher;

import java.util.ArrayList;
import java.util.Scanner;

import booking_publisher.Booking;
import booking_publisher.bookingPublish;

public class bookingPublishImpl implements bookingPublish {
	
	private final ArrayList<Booking> bookingList = new ArrayList<>();
		
	//Creating a scanner class object to get keyboard inputs.
	Scanner sc_int = new Scanner(System.in);
	Scanner sc_string = new Scanner(System.in);
		
	//Creating an object from booking class.
	Booking booking = new Booking();
		
		
	@Override
	public void mainMenu() {
	
		System.out.println("======================================");
		System.out.println("Main menu");
		System.out.println("======================================");
		System.out.println("Select Your option...");
		System.out.println("======================================");
		System.out.println("");
		System.out.println("1. Add Booking");
		System.out.println("2. View booking ");
		System.out.println("3. Update booking.");
		System.out.println("4. Delete booking.");
		System.out.println("");
				
		System.out.print("Enter your choice here: ");
		int option = sc_int.nextInt();
				
		if(option > 0 && option < 5) {
			switch(option) {
			case 1:
				addBooking();
				break;
							
			case 2:
				viewAllBookings();
				break;
							
			case 3:
				updateBooking();
				break;
							
			case 4:
				deleteBooking();
				break;
							
			default:
				System.out.println("cannot offer a service for the input.");
				mainMenu();
			}
		}			
		else {	
			System.out.println("Select the correct option and try again.....");
			mainMenu();
		}	
	}

	@Override
	public void exitConfirmation() {
			
		System.out.println("");
		System.out.println("");
		System.out.println("Are you sure ?");
		System.out.println("1. Yes");
		int exit = sc_int.nextInt();
			
		if( exit == 1) {
			mainMenu();
		}else {
			System.out.println("invalid output. tryagain...");
			exitConfirmation();
		}	
	}

	@Override
	public void addBooking() {
			
		System.out.println("Press any button to add booking....");
		System.out.println("99. back");
		int back = sc_int.nextInt();
		System.out.println("");
				
		if( back != 99) {
					
			System.out.println("\t Create booking");
			System.out.println("=======================================");
			System.out.println("");
			System.out.print("Enter Booking ID: ");
			booking.setBookingID(sc_int.nextInt());	
					
			System.out.print("Enter driver ID: ");
			booking.setDriverID(sc_int.nextInt());
					
			System.out.print("Enter Booking date: ");
			booking.setBookingDate(sc_string.next());
					
			System.out.print("Enter Vehicle number : ");
			booking.setVehicleNo(sc_string.next());
					
			System.out.print("Enter customer name: ");
			booking.setCustomerName(sc_string.next());
			
				
					
			System.out.print("Enter booking descripion: ");
			booking.setDescription(sc_string.next());
			
			bookingList.add(booking);
			System.out.println("Booking added successfully...");	
				
			exitConfirmation();
					
		}else{
			mainMenu();
		}
	}


	@Override
	public void viewAllBookings() {
			
		System.out.println("Booking details");
		System.out.println("======================================");
		System.out.println();
			
		System.out.format("%10s %15s %15s %15s %15s %15s\n", "BookingID", "DriverID", "BookingDate", "Vehicle No.", "CustomerName", "Description");
		System.out.println("--------------------------------------------");
			
		for (int i = 0; i < bookingList.size(); i++) {
			Booking details = bookingList.get(i);
			System.out.format("%-10s %15s %15s %15s %15s", details.getBookingID(), details.getDriverID(), details.getBookingDate(), details.getVehicleNo(), details.getCustomerName(), details.getDescription() + "\n");

		}
		
		System.out.println("");
		System.out.println("All the bookings retrieved.");
		exitConfirmation();
			
	}

	@Override
	public void updateBooking() {
		int index = 0;
		
		System.out.println("Press any button to update....");
		System.out.println("99. back");
		int back = sc_int.nextInt();
		System.out.println("");
			
		if( back != 99) {
			
			System.out.print("Enter the Booking ID to update:");
			int updateBID = sc_int.nextInt();
			
			for(int i = 0; i < bookingList.size(); i++) {
				
				Booking updateB = bookingList.get(i);
				if(updateBID == updateB.getBookingID()) {
					index = i;
					break;
				}
				else {
					System.out.println("Connot find the Booking ID..");
					mainMenu();
				}
			}
			
			System.out.println("Select to update");
			System.out.println("1. Update Booking ID.");
			System.out.println("2. Update Driver ID.");
			System.out.println("3. Update Booking date.");
			System.out.println("4. Update Vehicle Number.");
			System.out.println("5. Update Customer Name");
			System.out.println("6. Update Description.");
			int updateSelection = sc_int.nextInt();
			
			if(updateSelection > 0 && updateSelection < 5) {
				switch(updateSelection) {
				case 1:
					System.out.print("Enter new Booking ID: ");
					int newBookingID = sc_int.nextInt();
					bookingList.get(index).setBookingID(newBookingID);
					exitConfirmation();
					break;
					
				case 2:
					System.out.print("Enter new Driver ID: ");
					int newDriverID = sc_int.nextInt();
					bookingList.get(index).setDriverID(newDriverID);
					exitConfirmation();
					break;
					
				case 3:
					System.out.print("Enter new Booking date: ");
					String newBookingDate = sc_string.next();
					bookingList.get(index).setBookingDate(newBookingDate);
					exitConfirmation();
					break;
					
				case 4:
					System.out.print("Enter new Vehicle Number: ");
					String newVehicleNumber = sc_string.next();
					bookingList.get(index).setVehicleNo(newVehicleNumber);
					exitConfirmation();
					break;
					
				case 5:
					System.out.print("Enter new Customer name: ");
					String newCustomerName = sc_string.next();
					bookingList.get(index).setCustomerName(newCustomerName);
					exitConfirmation();
					break;
					
				case 6:
					System.out.print("Enter new Description: ");
					String newDescription = sc_string.next();
					bookingList.get(index).setDescription(newDescription);
					exitConfirmation();
					break;
					
				default:
					System.out.println("cannot offer a service for the input.");
					mainMenu();
				}
			}else {
				System.out.println("Select the correct option and try again.....");
				mainMenu();
			}
				
				
		}else {
			mainMenu();
		}
	}

	@Override
	public void deleteBooking() {
		
		int index = 0; 
		
		System.out.println("Press any button to update....");
		System.out.println("99. back");
		int back = sc_int.nextInt();
		System.out.println("");
			
		if( back != 99) {
			System.out.print("Enter the BookingID that you whant to delete:");
			int deleteBID = sc_int.nextInt();
			
			for(int i = 0; i < bookingList.size(); i++) {
				Booking deleteB = bookingList.get(i);
				
				if(deleteBID == deleteB.getBookingID()) {
					index = i;
					break;
				}else {
					System.out.println("Connot find the Booking ID..");
					mainMenu();
				}
			}
			
			bookingList.remove(index);
			System.out.println("Booking cancled successfully.");
			exitConfirmation();
			
				
				
		}else {
			mainMenu();
		}
	}

		

	
}
