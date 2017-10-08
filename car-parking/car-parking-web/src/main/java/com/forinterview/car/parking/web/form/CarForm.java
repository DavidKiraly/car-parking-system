package com.forinterview.car.parking.web.form;

import com.forinterview.car.parking.client.api.Vo.CarVo;
import com.forinterview.car.parking.client.api.service.CarService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import lombok.Data;


@RequestScoped
@Data
@Named("carForm")
public class CarForm implements Serializable{
	
	@EJB(mappedName="CarService")
	private CarService carService;

    private CarVo car;
	
	@PostConstruct
    public void init() {
        car = new CarVo();
    }
	
	public void submit() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (carService.isContainsCar(car.getLicensePlateNumber())) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sikertelen mentés!",
					String.format("Az adott autó már létezik!", car.getLicensePlateNumber())));
		} else {
			carService.addCarVo(car);
			context.addMessage(null, new FacesMessage("Sikeres mentés!", String.format("Az autó mentése sikeres!",
					car.getLicensePlateNumber())));
			init();
		}
    }
}
