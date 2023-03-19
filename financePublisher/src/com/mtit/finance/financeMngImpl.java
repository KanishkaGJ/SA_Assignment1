package com.mtit.finance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.mtit.finance.finance;

public class financeMngImpl implements financeMngServicePub{

	private final ArrayList<finance> financeDetails = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public void exitService() {
		System.out.println("\nReturn to Home: ");
		System.out.println("1. Yes");
		System.out.println("2. No");
		int num = sc.nextInt();
		if (num == 1) {
			financeStart();
		} else {
			System.out.println("No code?");
		}
	}

	
	public void financeStart() {
		System.out.println("Select a service");
		System.out.println("1. ADD NEW DETAILS");
		System.out.println("2. VIEW ALL DETAILS");
		System.out.println("3. GET DETAILS OF ONE RECORD");
		System.out.println("4. UPDATE DETAILS");
		System.out.println("5. DELETE DETAILS");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			enterFinance();
			break;
		case 2:
			getAllFinanceDetails();
			break;
		case 3:
			getFinance();
			break;
		case 4:
			updateFinance();
			break;
		case 5:
			deleteFinance();
			break;
		default:
			System.out.println("No service found");
		}
	}
	
	
	@Override
	public void enterFinance() {
		finance newFinance = new finance();
		System.out.println("Enter ID: ");
		newFinance.setFinanceID(sc.next().toLowerCase());
		System.out.println("Enter date: ");
		newFinance.setDate(sc.next());
		System.out.println("Enter transaction type: ");
		newFinance.setTransactionType(sc.next());
		System.out.println("Enter amount: ");
		newFinance.setAmount(sc.nextInt());
		System.out.println("Enter description: ");
		newFinance.setDescription(sc.next());
		financeDetails.add(newFinance);
		System.out.println("\nDetails successfuly added");
		exitService();
	}


	public void getAllFinanceDetails() {
		System.out.format("%-10s %5s %10s %10s %10s\n","ID", "DATE", "TYPE", "AMOUNT", "DESCRIPTION");
		System.out.println("--------------------------------------------");

		for (int i = 0; i < financeDetails.size(); i++) {
			finance getFinanceDetails = financeDetails.get(i);
			System.out.format("%-10s %5s %10s %10s %10s", getFinanceDetails.getFinanceID(), getFinanceDetails.getDate(), getFinanceDetails.getTransactionType(),
					getFinanceDetails.getAmount(), getFinanceDetails.getDescription()  + "\n");
		}
		System.out.println("\n\nAll details retrieved");
		exitService();
	}


	@Override
	public void getFinance() {
		System.out.println("Enter ID of the detail you want to see details");
		String seeID = sc.next().toLowerCase();
		for (int i = 0; i < financeDetails.size(); i++) {
			if (seeID.equals(financeDetails.get(i).getFinanceID())) {
				System.out.println("ID: "+financeDetails.get(i).getFinanceID());
				System.out.println("Date: " + financeDetails.get(i).getDate());
				System.out.println("Type: " + financeDetails.get(i).getTransactionType());
				System.out.println("Amount: " + financeDetails.get(i).getAmount());
				System.out.println("Description: " + financeDetails.get(i).getDescription());
				break;
			}
		}
		exitService();
	}
	


	@Override
	public void updateFinance() {
		int index = 0;
		System.out.println("Enter ID of the record you want to update details");
		String upName = sc.next().toLowerCase();
		for (int i = 0; i < financeDetails.size(); i++) {
			finance updD = financeDetails.get(i);
			if (upName.equals(updD.getDate())) {
				index = i;
				break;
			}
		}

		System.out.println("Choose field to update");
		System.out.println("1. Date");
		System.out.println("2. Type");
		System.out.println("3. Amount");
		System.out.println("4. Description");

		int num = sc.nextInt();

		switch (num) {
		case 1:
			System.out.println("\nEnter new date: ");
			String newDate = sc.next();
			financeDetails.get(index).setDate(newDate);;
			break;
		case 2:
			System.out.println("\nEnter new type: ");
			String newType = sc.next();
			financeDetails.get(index).setTransactionType(newType);;
			break;
		case 3:
			System.out.println("\nEnter new amount: ");
			String newAmount = sc.next();
			financeDetails.get(index).setAmount(num);
			break;
		case 4:
			System.out.println("\nEnter new description: ");
			String newDescription = sc.next();
			financeDetails.get(index).setDescription(newDescription);
			break;
		default:
			System.out.println("Invalid input");
		}
		System.out.println("\nDetails successfully updated");
		exitService();
	}

	
  	@Override
	public void deleteFinance() {
		int index = 0;
		System.out.println("Enter ID of the detail you want to delete");
		String delID = sc.next().toLowerCase();
		for (int i = 0; i < financeDetails.size(); i++) {
			finance delD = financeDetails.get(i);
			if (delID.equals(delD.getFinanceID())) {
				index = i;
				break;
			}
		}
		financeDetails.remove(index);
		System.out.println("\nDetails deleted");
		exitService();

	}
//
}
