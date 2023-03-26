package driver_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class DriverActivatorPub implements BundleActivator {

	private static BundleContext context;
	ServiceRegistration publishServiceReg;
	DriverMngServicePub publisherService; 
	
	static BundleContext getContext() {
		return context;
	}
	
	public void start(BundleContext context) throws Exception {
		
		System.out.println("publisher start");
		DriverActivatorPub.context = context;
		
		publisherService = new DriverMngImpl();
		publishServiceReg = context.registerService(DriverMngServicePub.class.getName(), publisherService, null);
	}

	public void stop(BundleContext context) throws Exception {
		
		DriverActivatorPub.context = null;
		
		System.out.println("publisher stop");
		publishServiceReg.unregister();
	}
}