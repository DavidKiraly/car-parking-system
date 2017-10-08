package com.forinterview.car.parking.service.impl;

import com.forinterview.car.parking.client.api.Vo.CarVo;
import com.forinterview.car.parking.client.api.service.CarService;
import com.forinterview.car.parking.service.database.DataBase;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(mappedName = "CarService")
@Local(CarService.class)
public class CarBean implements CarService {

	@Override
	public List<CarVo> findAll() {
		return DataBase.getCars();
	}

	@Override
	public CarVo findByLicensePlateNumber(String licensePlateNumber) {
		List<CarVo> cars = DataBase.getCars().stream()
				.filter(e -> e.getLicensePlateNumber().equals(licensePlateNumber))
				.collect(Collectors.toList());
		if (!cars.isEmpty()) {
			return cars.get(0);
		} else {
			return null; //exception
		}
	}

	@Override
	public void addCarVo(CarVo car) {
		CarVo newCar = CarVo.builder()
				.licensePlateNumber(car.getLicensePlateNumber())
				.brand(car.getBrand())
				.type(car.getType())
				.color(car.getColor())
				.build();
		DataBase.getCars().add(newCar);
	}

	@Override
	public boolean isContainsCar(final String licensePlateNumber) {
		return findByLicensePlateNumber(licensePlateNumber) == null;
	}

	@Override
	public void deleteCarVo(CarVo car) {
		DataBase.getCars().remove(car);
	}

}
