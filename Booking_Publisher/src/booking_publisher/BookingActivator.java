package booking_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import booking_publisher.bookingPublish;
import booking_publisher.bookingPublishImpl;

public class BookingActivator implements BundleActivator {

	
	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext context) throws Exception {
		
		System.out.println("Publisher start");
		bookingPublish publishService = new bookingPublishImpl();
		
		publishServiceRegistration = context.registerService(bookingPublish.class.getName(), publishService, null);
		
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Publisher stop");
		publishServiceRegistration.unregister();
		
		
	}
	

}
