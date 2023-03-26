package assignment_consumer;

import driver_subscriber.DriverActivatorSub;
import finance_subscriber.FinanceActivatorSub;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import booking_subscriber.BookingActivatorSub;
import vehicle_subscriber.VehicleActivatorSub;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceReference vehicleReference;
	private ServiceReference bookingReference;
	private ServiceReference driverReference;
	private ServiceReference financeReference;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		//Connecting vehicle to the consumer class.
		vehicleReference = context.getServiceReference(VehicleActivatorSub.class.getName());
		VehicleActivatorSub vehicles = (VehicleActivatorSub) bundleContext.getService(vehicleReference);
		
		//Connecting booking to the consumer class.
		bookingReference = context.getServiceReference(BookingActivatorSub.class.getName());
		BookingActivatorSub bookings = (BookingActivatorSub) bundleContext.getService(bookingReference);
		
		//Connecting driver to the consumer class.
		driverReference = context.getServiceReference(DriverActivatorSub.class.getName());
		DriverActivatorSub drivers = (DriverActivatorSub) bundleContext.getService(driverReference);
		
		//Connecting finance to the consumer class.
		financeReference = context.getServiceReference(FinanceActivatorSub.class.getName());
		FinanceActivatorSub finance = (FinanceActivatorSub) bundleContext.getService(financeReference);
		
		Scanner sc_int = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("\n=================================");
			System.out.println("Welcome to Vehicle rent system");
			int option = 0;
			
			System.out.println("");
			System.out.println("=============================================");
			System.out.println("Please select an option");
			System.out.println("1. Vehicle Management");
			System.out.println("2. Booking Management ");
			System.out.println("3. Driver Management ");
			System.out.println("4. Finance Management");
			System.out.println("5. Quit \n\n");

			System.out.print("Select an option :");
			option = sc_int.nextInt();

			switch (option) {
				case 1:
					vehicles.displayMenu();
				case 2:
					bookings.displayMenu();
					break;
				case 3:
					drivers.displayMenu();
					break;
				case 4:
					finance.displayMenu();
				case 5:
					break;

			}
			
			if(option == 5) {
				
				break;
				
			}			
			
		}
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Consumer Stopped");
	}

}