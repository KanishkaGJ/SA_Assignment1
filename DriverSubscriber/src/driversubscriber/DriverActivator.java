package driversubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import driver_subscriber.DriverMngServicePub;

public class DriverActivator implements BundleActivator {

	
	private ServiceReference serviceRef;
	private ServiceRegistration driverServiceReg;
	private DriverMngServicePub servicePublish;

	public void start(BundleContext context) throws Exception {
		System.out.println("start subscriber service");
		driverServiceReg = context.registerService(this.getClass().getName(), this, null);
		serviceRef = context.getServiceReference(DriverMngServicePub.class.getName());
		servicePublish = (DriverMngServicePub)context.getService(serviceRef);
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye!!!");
		context.ungetService(serviceRef);
	}
	
	public void displayMenu() {
		servicePublish.UserStart();
	}

}
