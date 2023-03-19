package driver_subscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class DriverActivator implements BundleActivator {

	ServiceRegistration publishServiceReg;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("publisher start");
		DriverMngServicePub publisherService = new DriverMngImpl();
		
		publishServiceReg = context.registerService(DriverMngServicePub.class.getName(), publisherService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("publisher stop");
		publishServiceReg.unregister();
	}

}
