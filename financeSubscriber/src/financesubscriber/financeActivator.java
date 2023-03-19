package financesubscriber;

import com.mtit.finance.financeMngServicePub;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class financeActivator implements BundleActivator {

	private ServiceReference serviceRef;
	private ServiceRegistration financeReg;
	private financeMngServicePub servicePublish;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("start subscriber service");
		financeReg = context.registerService(this.getClass().getName(), this, null);
		serviceRef = context.getServiceReference(financeMngServicePub.class.getName());
		servicePublish = (financeMngServicePub)context.getService(serviceRef);
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye!!!");
		context.ungetService(serviceRef);
	}
	
	public void displayMenu() {
		servicePublish.financeStart();
	}

}
