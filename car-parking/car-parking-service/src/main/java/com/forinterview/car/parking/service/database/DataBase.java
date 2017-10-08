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

		CarParkVo defaultCarPark;
		defaultCarPark = CarParkVo.builder()
				.name("nincs")
				.build();

		String from = "0000-00-00 00:00";
		String to = "0000-00-00 00:00";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd kk:mm", Locale.ROOT);
		Date begin = null;
		Date end = null;
		try {
			begin = df.parse(from);
			end = df.parse(to);
		} catch (ParseException ex) {
			Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
		}

		CarVo defaultCar;
		defaultCar = CarVo.builder()
				.brand("nincs")
				.type("nincs")
				.color("nincs")
				.licensePlateNumber("nincs")
				.actualCarPark(defaultCarPark)
				.parkingBegin(begin)
				.parkingEnd(end)
				.build();

		cars = new ArrayList<>(Arrays.asList(defaultCar));

	}
	private DataBase() {
    }

}
