package com.forinterview.car.parking.service.database;

import com.forinterview.car.parking.client.api.Vo.CarParkVo;
import com.forinterview.car.parking.client.api.Vo.CarVo;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.Setter;


public final class DataBase {

	@Getter
	@Setter
	private static List<CarVo> cars;

	@Getter
	@Setter
	private static List<CarParkVo> carParks;

	static {

		
		CarParkVo firstCarPark;
		firstCarPark = CarParkVo.builder()
				.name("EgyParkoló")
				.build();
		CarParkVo secondCarPark;
		secondCarPark = CarParkVo.builder()
				.name("MásikParkoló")
				.build();
		CarParkVo thirdCarPark;
		thirdCarPark = CarParkVo.builder()
				.name("MégegyParkoló")
				.build();
		
		carParks = new ArrayList<>(Arrays.asList(firstCarPark, secondCarPark, thirdCarPark));

		cars = new ArrayList<>();

	}
	private DataBase() {
    }

}
