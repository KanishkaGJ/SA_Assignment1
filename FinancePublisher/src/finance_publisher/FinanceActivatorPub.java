package finance_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class FinanceActivatorPub implements BundleActivator {
	
	private static BundleContext context;
	ServiceRegistration publishServiceRegistration;
	FinanceMngServicePub publisherService;
	
	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext context) throws Exception {
		
		System.out.println("publisher start");
		FinanceActivatorPub.context = context;
		
		publisherService = new FinanceMngImpl();		
		publishServiceRegistration = context.registerService(FinanceMngServicePub.class.getName(), publisherService, null);
	}

	public void stop(BundleContext context) throws Exception {
		FinanceActivatorPub.context = null;
		
		System.out.println("publisher stop");
		publishServiceRegistration.unregister();
	}

}
