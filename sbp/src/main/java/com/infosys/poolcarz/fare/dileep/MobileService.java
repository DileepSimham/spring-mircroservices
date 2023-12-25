package com.infosys.poolcarz.fare.dileep;

import lombok.Getter;

@Getter
public class MobileService {

	private long mobileNumber;
	private String model;

//	 default constructor
//	public void MobileService() {
//	}

	// parameterized constructor
	public void MobileService(long mobileNumber, String model) {
		this.mobileNumber = mobileNumber;
		this.model = model;
	}

	// setter method
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
