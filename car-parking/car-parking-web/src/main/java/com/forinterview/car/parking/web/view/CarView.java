package com.forinterview.car.parking.web.view;

import com.forinterview.car.parking.client.api.Vo.CarVo;
import com.forinterview.car.parking.client.api.exception.CarNotFoundException;
import com.forinterview.car.parking.client.api.service.CarService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
	
	
	public void removeSelectedCar(){
	FacesContext context = FacesContext.getCurrentInstance();
        try {
            carService.deleteCarVo(selectedCar);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "A törlés sikeres!",
                    "Az autó törölve lett!"));
            selectedCar = null;
        } catch (CarNotFoundException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A törlés sikertelen!",
                    e.getMessage() + " Kérjük válasszon ki egy autót!"));
        }
	}
}
