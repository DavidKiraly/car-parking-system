package com.forinterview.car.parking.client.api.exception;


public class CarNotFoundException extends Exception{
	
	public CarNotFoundException() {
    }
	
	 public CarNotFoundException(final String msg) {
        super(msg);
    }
}
