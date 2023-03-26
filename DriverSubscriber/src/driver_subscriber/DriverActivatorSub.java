package driver_subscriber;

import driver_publisher.DriverMngServicePub;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class DriverActivatorSub implements BundleActivator {

	
	private ServiceReference driverServiceReference;
	private ServiceRegistration driverServiceReg;
	private DriverMngServicePub servicePublish;

	public void start(BundleContext context) throws Exception {
		
		System.out.println("start subscriber service");
		driverServiceReg = context.registerService(this.getClass().getName(), this, null);
		driverServiceReference = context.getServiceReference(DriverMngServicePub.class.getName());
		servicePublish = (DriverMngServicePub)context.getService(driverServiceReference);
		
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye!!!");
		context.ungetService(driverServiceReference);
	}
	
	public void displayMenu() {
		servicePublish.UserStart();
	}

}