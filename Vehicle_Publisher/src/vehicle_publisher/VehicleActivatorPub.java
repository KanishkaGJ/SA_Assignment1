package vehicle_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class VehicleActivatorPub implements BundleActivator {

	
	private static BundleContext context;
	ServiceRegistration publisherServiceRegistration;
	VehicleMngServicePublish publishService;
	
	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext context) throws Exception {
		
		System.out.println("publisher started.");
		VehicleActivatorPub.context = context;
		
		publishService =  new VehicleMngServiceImplementation();
		publisherServiceRegistration = context.registerService(VehicleMngServicePublish.class.getName(), publishService, null);
		
		
	}


	public void stop(BundleContext context) throws Exception {
		
		VehicleActivatorPub.context = null;
		
		System.out.println("Publisher Stopped.");
		publisherServiceRegistration.unregister();
		
	}

}