package com.forinterview.car.parking.service.impl;

import com.forinterview.car.parking.client.api.Vo.CarParkVo;
import com.forinterview.car.parking.client.api.Vo.CarVo;
import com.forinterview.car.parking.client.api.exception.CarNotFoundException;
import com.forinterview.car.parking.client.api.service.CarService;
import com.forinterview.car.parking.service.database.DataBase;
import java.util.Date;
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
	public CarVo findByLicensePlateNumber(String licensePlateNumber) throws CarNotFoundException {
		List<CarVo> cars = DataBase.getCars().stream()
				.filter(e -> e.getLicensePlateNumber().equals(licensePlateNumber))
				.collect(Collectors.toList());
		if (!cars.isEmpty()) {
			return cars.get(0);
		} else {
			throw new CarNotFoundException("Nincs autó az adatbázisban a ezzel rendszámmal");
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
		try {
			findByLicensePlateNumber(licensePlateNumber);
			return true;
		} catch (CarNotFoundException e) {
			return false;
		}
	}

	@Override
	public void deleteCarVo(CarVo car) throws CarNotFoundException {
		if (DataBase.getCars().contains(car)) {
			DataBase.getCars().remove(car);
		} else {
			throw new CarNotFoundException("Nincs ilyen autó az adatbázisban!");
		}

	}

	@Override
    public void modifyCarParkAndDateInterval(final String licensePlateNumber, final CarParkVo carPark,
            final Date parkingBegin, final Date parkingEnd) throws CarNotFoundException {
       
        CarVo actualCar = findByLicensePlateNumber(licensePlateNumber);
        actualCar.setActualCarPark(carPark);
        actualCar.setParkingBegin(parkingBegin);
        actualCar.setParkingEnd(parkingEnd);
    }
}
