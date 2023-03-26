package vehicle_subscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import vehicle_publisher.VehicleMngServicePublish;

public class VehicleActivatorSub implements BundleActivator {
	
	private ServiceReference vehicleServiceReference;
	private ServiceRegistration vehicleServiceReg;
	private VehicleMngServicePublish servicePublish;


	public void start(BundleContext context) throws Exception {
			
		System.out.println("Subscriber started.");
		vehicleServiceReg = context.registerService(this.getClass().getName(), this, null);
		vehicleServiceReference = context.getServiceReference(VehicleMngServicePublish.class.getName());
		servicePublish = (VehicleMngServicePublish) context.getService(vehicleServiceReference);	
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Subscriber Stopped.");
		System.out.println("Thank you for your valuble time");
		context.ungetService(vehicleServiceReference);
	}
	
	public void displayMenu() {
		servicePublish.mainMenu();
	}

}