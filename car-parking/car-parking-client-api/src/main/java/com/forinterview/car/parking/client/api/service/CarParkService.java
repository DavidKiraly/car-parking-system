package com.forinterview.car.parking.client.api.service;

import com.forinterview.car.parking.client.api.Vo.CarParkVo;
import java.util.List;


public interface CarParkService {
	
	List<CarParkVo> findAll();

	
}
