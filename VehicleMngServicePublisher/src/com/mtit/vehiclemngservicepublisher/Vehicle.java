package com.mtit.vehiclemngservicepublisher;

public class Vehicle {
	
	private String vehicleId;
	private String vehicleNumber;
	private String vehicleBrand;
	private String chassieNumber;
	private String insurence;
	private String OwnerName;
	private String date;
	
	//Setting up a empty constructor.
	public Vehicle() {
		
	}
	
	//Setter & getter for the vehicleId.
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	//Setter & getter for the vehicleNumber.
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	
	//Setter & getter for the vehicleBrand.
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	
	//Setter & getter for the vehicleChassieNumber.
	public String getChassieNumber() {
		return chassieNumber;
	}
	public void setChassieNumber(String chassieNumber) {
		this.chassieNumber = chassieNumber;
	}
	
	//Setter & getter for the vehicleInsurance.
	public String getInsurence() {
		return insurence;
	}
	public void setInsurence(String insurence) {
		this.insurence = insurence;
	}
	
	//Setter & getter for the OwnerName.
	public String getOwnerName() {
		return OwnerName;
	}
	public void setOwnerName(String ownerName) {
		OwnerName = ownerName;
	}
	
	////Setter & getter for the date.
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}


	
	
}