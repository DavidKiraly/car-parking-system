package com.forinterview.car.parking.client.api.Vo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarVo {
	
	private String licensePlateNumber;
    private String brand;
	private String color;
	private String type;
	private Date parkingBegin;
	private Date parkingEnd;
	private CarParkVo actualCarPark;
	
	
}
