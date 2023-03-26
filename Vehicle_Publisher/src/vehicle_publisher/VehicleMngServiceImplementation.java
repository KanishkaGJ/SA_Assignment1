package vehicle_publisher;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleMngServiceImplementation implements VehicleMngServicePublish {

	private final ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();

	// Creating a scanner class object to get keyboard inputs.
	Scanner sc_int = new Scanner(System.in);
	Scanner sc_string = new Scanner(System.in);

	// Creating and object from the vehicle class.
	Vehicle vehicle = new Vehicle();

	@Override
	public void mainMenu() {

		System.out.println("======================================");
		System.out.println("Main menu");
		System.out.println("======================================");
		System.out.println("Select Your option...");
		System.out.println("======================================");
		System.out.println("");
		System.out.println("1. Register a new Vehicle.");
		System.out.println("2. Vehicle details. ");
		System.out.println("3. Update vehicle details.");
		System.out.println("4. Delete vehicle details.");
		System.out.println("");

		System.out.print("Enter your choice here: ");
		int option = sc_int.nextInt();

		if (option > 0 && option < 5) {
			switch (option) {
			case 1:
				registerVehicle();
				break;

			case 2:
				getVehicleDetails();
				break;

			case 3:
				updateVehicleDetails();
				break;

			case 4:
				deleteVehicleDetails();
				break;

			default:
				System.out.println("cannot offer a service for the input.");
				mainMenu();
			}
		} else {
			System.out.println("Select the correct option and tru again.....");
			mainMenu();
		}
	}

	@Override
	public void exitConfirmation() {

		System.out.println("");
		System.out.println("");
		System.out.println("Press 1 to Exit ?");
		int exit = sc_int.nextInt();

		if (exit == 1) {
			mainMenu();
		} else {
			System.out.println("invalid output. tryagain...");
			exitConfirmation();
		}
	}

	@Override
	public void registerVehicle() {

		System.out.println("\t Vehicle Registration.");
		System.out.println("=======================================");
		System.out.println("");
		System.out.print("Enter Vehicle ID: ");
		vehicle.setVehicleId(sc_string.next());

		System.out.print("Enter Vehicle Registration Number: ");
		vehicle.setVehicleNumber(sc_string.next());

		System.out.print("Enter Vehicle brand: ");
		vehicle.setVehicleBrand(sc_string.next());

		System.out.print("Enter Vehicle Chassie number : ");
		vehicle.setChassieNumber(sc_string.next());

		System.out.print("insurance company: ");
		vehicle.setInsurence(sc_string.next());

		System.out.print("Enter Owner's name: ");
		vehicle.setOwnerName(sc_string.next());

		System.out.print("Enter Vehicle date of registration: ");
		vehicle.setDate(sc_string.next());

		vehicleList.add(vehicle);
		System.out.println("Vehicle registered successfully...");

		exitConfirmation();

	}

	@Override
	public void getVehicleDetails() {

		System.out.print("Enter the vehicle number to get the details:");
		String vehicleNum = sc_string.next();

		for (int i = 0; i < vehicleList.size(); i++) {

			if (vehicleNum.equals(vehicleList.get(i).getVehicleNumber())) {

				System.out.println("Vehicle details");
				System.out.println("======================================");
				System.out.println();

				System.out.println("Vehicle ID: " + vehicleList.get(i).getVehicleId());
				System.out.println("Owner's name: " + vehicleList.get(i).getOwnerName());
				System.out.println("Vehicle Number: " + vehicleList.get(i).getVehicleNumber());
				System.out.println("Vehicle Brand: " + vehicleList.get(i).getVehicleBrand());
				System.out.println("Vehicle insurance: " + vehicleList.get(i).getInsurence());
				System.out.println("Date registered: " + vehicleList.get(i).getDate());

				exitConfirmation();
				break;
			} else {

				System.out.println("Vehicle can not be found.");
				System.out.println("check the vehicle number and re enter...");

				mainMenu();

			}

			exitConfirmation();
		}

	}

	@Override
	public void updateVehicleDetails() {

		int index = 0;

		System.out.print("Enter the vehicle ID to update:");
		String updateVID = sc_string.next();

		for (int i = 0; i < vehicleList.size(); i++) {

			Vehicle updateV = vehicleList.get(i);
			if (updateVID.equals(updateV.getVehicleId())) {
				index = i;
				break;
			} else {
				System.out.println("Connot find the vehicle ID..");
				mainMenu();
			}
		}

		System.out.println("Select to update");
		System.out.println("1. Update Vehicle ID.");
		System.out.println("2. Update Owner's name.");
		System.out.println("3. Update Vehicle number.");
		System.out.println("4. Update Vehicle brand.");
		System.out.println("5. Update Vehicle insurance.");
		System.out.println("6. Update Register date.");
		int updateSelection = sc_int.nextInt();

		if (updateSelection > 0 && updateSelection < 5) {
			switch (updateSelection) {
			case 1:
				System.out.print("Enter new Vehicle ID: ");
				String newVehicleID = sc_string.next();
				vehicleList.get(index).setVehicleId(newVehicleID);
				exitConfirmation();
				break;

			case 2:
				System.out.print("Enter new Owner's name: ");
				String newOwnersName = sc_string.next();
				vehicleList.get(index).setOwnerName(newOwnersName);
				exitConfirmation();
				break;

			case 3:
				System.out.print("Enter new Vehicle number: ");
				String newVehicleNumber = sc_string.next();
				vehicleList.get(index).setVehicleNumber(newVehicleNumber);
				exitConfirmation();
				break;

			case 4:
				System.out.print("Enter new Vehicle brand: ");
				String newVehicleBrand = sc_string.next();
				vehicleList.get(index).setVehicleBrand(newVehicleBrand);
				exitConfirmation();
				break;

			case 5:
				System.out.print("Enter new Vehicle insurance: ");
				String newVehicleInsurance = sc_string.next();
				vehicleList.get(index).setInsurence(newVehicleInsurance);
				exitConfirmation();
				break;

			case 6:
				System.out.print("Enter new registered date: ");
				String newRegisteredDate = sc_string.next();
				vehicleList.get(index).setDate(newRegisteredDate);
				exitConfirmation();
				break;

			default:
				System.out.println("cannot offer a service for the input.");
				mainMenu();
			}
		} else {
			System.out.println("Select the correct option and try again.....");
			mainMenu();
		}

	}

	@Override
	public void deleteVehicleDetails() {

		int index = 0;

		System.out.print("Enter the vehicleID that you whant to delete:");
		String deleteVID = sc_string.next();

		for (int i = 0; i < vehicleList.size(); i++) {
			Vehicle deleteV = vehicleList.get(i);

			if (deleteVID.equals(deleteV.getVehicleId())) {
				index = i;
				break;
			} else {
				System.out.println("Connot find the vehicle ID..");
				mainMenu();
			}
		}

		vehicleList.remove(index);
		System.out.println("Vehicle deleted successfully.");
		exitConfirmation();

	}

}
