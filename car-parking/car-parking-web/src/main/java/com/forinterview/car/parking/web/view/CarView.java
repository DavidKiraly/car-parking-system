package com.forinterview.car.parking.web.view;

import com.forinterview.car.parking.client.api.Vo.CarVo;
import com.forinterview.car.parking.client.api.service.CarService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Data;


@ViewScoped
@Data
@Named("carView")
public class CarView implements Serializable {

	private CarVo selectedCar;

	@EJB(mappedName="CarService")
	private CarService carService;

	public List<CarVo> listAllCars() {
		return carService.findAll();
	}

}
