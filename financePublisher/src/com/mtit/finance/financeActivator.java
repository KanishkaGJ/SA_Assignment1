package com.mtit.finance;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

//import com.mtit.driver.DriverMngImpl;
//import com.mtit.driver.DriverMngServicePub;

public class financeActivator implements BundleActivator {
	
	ServiceRegistration publishServiceReg;

	public void start(BundleContext context) throws Exception {
		System.out.println("publisher start");
		financeMngServicePub publisherService = new financeMngImpl();
		
		publishServiceReg = context.registerService(financeMngServicePub.class.getName(), publisherService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("publisher stop");
		publishServiceReg.unregister();
	}

}
