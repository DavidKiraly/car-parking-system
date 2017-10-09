package com.forinterview.car.parking.client.api.service;

import com.forinterview.car.parking.client.api.Vo.CarParkVo;
import com.forinterview.car.parking.client.api.Vo.CarVo;
import com.forinterview.car.parking.client.api.exception.CarNotFoundException;
import java.util.Date;
import java.util.List;

public interface CarService {

	List<CarVo> findAll();

	CarVo findByLicensePlateNumber(String licensePlateNumber) throws CarNotFoundException ;

	void addCarVo(CarVo car);

	boolean isContainsCar(String licensePlateNumber);
	
	void modifyCarParkAndDateInterval(String licensePlateNumber, CarParkVo CarPark,
            Date parkingBegin, Date parkingEnd) throws CarNotFoundException;

	void deleteCarVo(CarVo car) throws CarNotFoundException;
}
