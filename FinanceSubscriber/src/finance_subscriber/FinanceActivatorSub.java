package finance_subscriber;

import finance_publisher.FinanceMngServicePub;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class FinanceActivatorSub implements BundleActivator {

	private ServiceReference financeServiceReference;
	private ServiceRegistration financeServiceReg;
	private FinanceMngServicePub servicePublish;
	
	public void start(BundleContext context) throws Exception {
		
		System.out.println("start subscriber service");
		financeServiceReg = context.registerService(this.getClass().getName(), this, null);
		financeServiceReference = context.getServiceReference(FinanceMngServicePub.class.getName());
		servicePublish = (FinanceMngServicePub)context.getService(financeServiceReference);
		
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Goodbye!!!");
		context.ungetService(financeServiceReference);
	}
	
	public void displayMenu() {
		servicePublish.financeStart();
	}

}