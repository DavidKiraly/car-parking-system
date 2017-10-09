
package com.forinterview.car.parking.service.impl;

import com.forinterview.car.parking.client.api.Vo.CarParkVo;
import com.forinterview.car.parking.client.api.service.CarParkService;
import com.forinterview.car.parking.service.database.DataBase;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(mappedName = "CarParkService")
@Local(CarParkService.class)
public class CarParkBean implements CarParkService {

	@Override
	public List<CarParkVo> findAll() {
		return DataBase.getCarParks();
	}
	
}
