package booking_subscriber;

import booking_publisher.bookingPublish;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class BookingActivatorSub implements BundleActivator {

	private ServiceReference bookingServiceRefernce;
	private ServiceRegistration bookingServiceReg;
	private bookingPublish servicePublish;

	public void start(BundleContext context) throws Exception {
		
		System.out.println("Subscriber started");
		bookingServiceReg = context.registerService(this.getClass().getName(), this, null);
		bookingServiceRefernce = context.getServiceReference(bookingPublish.class.getName());
		servicePublish = (bookingPublish)context.getService(bookingServiceRefernce);
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Subscriber stoped");
		context.ungetService(bookingServiceRefernce);
	}
	
	public void displayMenu() {
		servicePublish.mainMenu();
	}

}