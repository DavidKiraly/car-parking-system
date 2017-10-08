package com.forinterview.car.parking.service.database;

import com.forinterview.car.parking.client.api.Vo.CarParkVo;
import com.forinterview.car.parking.client.api.Vo.CarVo;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


public final class DataBase {
	
	@Getter
    @Setter
    private static List<CarVo> cars;

    @Getter
    @Setter
    private static List<CarParkVo> carParks;
	
}
