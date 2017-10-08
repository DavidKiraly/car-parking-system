package com.forinterview.car.parking.web.view;

import com.forinterview.car.parking.client.api.Vo.CarVo;
import com.forinterview.car.parking.client.api.service.CarService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Data;


@ManagedBean(name="carView")
@ViewScoped
@Data
public class CarView {

	private CarVo selectedCar;

	@EJB
	private CarService carService;

	public List<CarVo> listAllCars() {
		return carService.findAll();
	}

}
