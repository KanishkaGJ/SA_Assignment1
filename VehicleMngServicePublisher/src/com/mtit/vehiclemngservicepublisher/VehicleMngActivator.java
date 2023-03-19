package com.mtit.vehiclemngservicepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class VehicleMngActivator implements BundleActivator {

	ServiceRegistration publisherServiceRegistration;

	public void start(BundleContext context) throws Exception {
		
		System.out.println("publisher started.");
		VehicleMngServicePublish publishService =  new VehicleMngServiceImplementation();
		
		publisherServiceRegistration = context.registerService(VehicleMngServicePublish.class.getName(), publishService, null);
		
		
	}


	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Publisher Stopped.");
		publisherServiceRegistration.unregister();
		
	}

}
