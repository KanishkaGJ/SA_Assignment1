package driver_subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DriverMngImpl implements DriverMngServicePub {

	private final ArrayList<Driver> drivers = new ArrayList<>();

	Scanner sc = new Scanner(System.in);

	public void exitService() {

		System.out.println("\nReturn to Home: ");
		System.out.println("1. Yes");
		System.out.println("2. No");

		int num = sc.nextInt();

		if (num == 1) {
			UserStart();
		} else {
			System.out.println("No code?");
		}

	}

	// Login as a new driver
	public void UserStart() {

		System.out.println("Select a service");
		System.out.println("1. REGISTER NEW DRIVER");
		System.out.println("2. VIEW ALL DRIVERS");
		System.out.println("3. GET DETAILS OF A DRIVER");
		System.out.println("4. UPDATE DRIVER DETAILS");
		System.out.println("5. DELETE A DRIVER");

		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			enterUser();
			break;
		case 2:
			getAllDrivers();
			break;
		case 3:
			getUser();
			break;
		case 4:
			updateUser();
			break;
		case 5:
			deleteUser();
			break;
		default:
			System.out.println("No service found");
		}
	}

	// register a driver
	@Override
	public void enterUser() {

		Driver newMem = new Driver();

		System.out.println("Enter Name: ");
		newMem.setName(sc.next().toLowerCase());
		System.out.println("Enter email: ");
		newMem.setEmail(sc.next());
		System.out.println("Enter Phone-Number: ");
		newMem.setTelNum(sc.next());
		System.out.println("Enter Address: ");
		newMem.setAddress(sc.next());

		drivers.add(newMem);

		System.out.println("\nDriver successfuly added");
		exitService();

	}

	// display details of all drivers
	public void getAllDrivers() {

		System.out.format("%5s %10s %10s %10s\n", "NAME", "EMAIL", "TEL-NUM", "ADRESS");
		System.out.println("--------------------------------------------");

		for (int i = 0; i < drivers.size(); i++) {
			Driver getMem = drivers.get(i);
			System.out.format("%-10s %8s %8s %10s", getMem.getName(), getMem.getEmail(), getMem.getTelNum(),
					getMem.getAddress() + "\n");
//			System.out.println(getMem.getName() + "\t" + getMem.getEmail() + "\t" + getMem.getTelNum() + "\t"
//					+ getMem.getAddress());
		}

		System.out.println("\n\nAll drivers retrieved");
		exitService();
	}

	// get details of one driver
	@Override
	public void getUser() {

		System.out.println("Enter name of the driver you want to see details");
		String seeName = sc.next().toLowerCase();

		for (int i = 0; i < drivers.size(); i++) {

			if (seeName.equals(drivers.get(i).getName())) {
				System.out.println("Name: " + drivers.get(i).getName());
				System.out.println("Email: " + drivers.get(i).getEmail());
				System.out.println("Phone Number: " + drivers.get(i).getTelNum());
				System.out.println("Address: " + drivers.get(i).getAddress());
				break;
			}
		}

		// System.out.println("\nDriver not found");
		exitService();

	}

	// Update details of a driver
	@Override
	public void updateUser() {

		int index = 0;

		System.out.println("Enter name of the driver you want to update details");
		String upName = sc.next().toLowerCase();

		for (int i = 0; i < drivers.size(); i++) {
			Driver updD = drivers.get(i);
			if (upName.equals(updD.getName())) {
				index = i;
				break;
			}
		}

		System.out.println("Choose field to update");
		System.out.println("1. Name");
		System.out.println("2. Email");
		System.out.println("3. Phone-Number");
		System.out.println("4. Address");

		int num = sc.nextInt();

		switch (num) {
		case 1:
			System.out.println("\nEnter new name: ");
			String newName = sc.next();
			drivers.get(index).setName(newName);
			break;
		case 2:
			System.out.println("\nEnter new email: ");
			String newEmai = sc.next();
			drivers.get(index).setEmail(newEmai);
			break;
		case 3:
			System.out.println("\nEnter new Phone-Number: ");
			String newNum = sc.next();
			drivers.get(index).setTelNum(newNum);
			break;
		case 4:
			System.out.println("\nEnter new Address: ");
			String newAdd = sc.next();
			drivers.get(index).setAddress(newAdd);
			break;
		default:
			System.out.println("Invalid user input");
		}

		System.out.println("\nDriver successfully updated");
		exitService();

	}

	// delete a driver details
	@Override
	public void deleteUser() {

		int index = 0;

		System.out.println("Enter name of the driver you want to delete");
		String delName = sc.next().toLowerCase();
		for (int i = 0; i < drivers.size(); i++) {
			Driver delD = drivers.get(i);
			if (delName.equals(delD.getName())) {
				index = i;
				break;
			}
		}
		drivers.remove(index);
		System.out.println("\nDriver deleted");
		exitService();

	}

}
