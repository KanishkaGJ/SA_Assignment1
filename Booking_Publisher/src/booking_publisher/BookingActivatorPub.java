package booking_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class BookingActivatorPub implements BundleActivator {

	private static BundleContext context;
	ServiceRegistration publishServiceRegistration;
	bookingPublish publishService;

	static BundleContext getContext() {
		return context;
	}
	

	public void start(BundleContext context) throws Exception {
		
		System.out.println("Publisher start");
		BookingActivatorPub.context = context;
		
		publishService = new bookingPublishImpl();
		publishServiceRegistration = context.registerService(bookingPublish.class.getName(), publishService, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		
		BookingActivatorPub.context = null;
		
		System.out.println("Publisher stop");
		publishServiceRegistration.unregister();
	}

}
