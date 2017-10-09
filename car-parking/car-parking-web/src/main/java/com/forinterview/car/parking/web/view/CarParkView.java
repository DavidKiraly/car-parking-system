package com.forinterview.car.parking.web.view;

import com.forinterview.car.parking.client.api.Vo.CarParkVo;
import com.forinterview.car.parking.client.api.Vo.CarVo;
import com.forinterview.car.parking.client.api.exception.CarNotFoundException;
import com.forinterview.car.parking.client.api.service.CarParkService;
import com.forinterview.car.parking.client.api.service.CarService;
import com.forinterview.car.parking.web.helper.ParkingDetails;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import lombok.Data;

@ManagedBean(name = "carParkView")
@ViewScoped
@Data
public class CarParkView {
	private String licensePlateNumber;
    private CarVo selectedCar;
	
	private List<ParkingDetails> parkingDetailsList;

    @EJB
    private CarService carService;

    @EJB
    private CarParkService carParkService;
	
	 @PostConstruct
    public void init() {

        parkingDetailsList = new ArrayList<>();
        getCarParks().stream()
                .forEach(e -> {
                    parkingDetailsList.add(
                            ParkingDetails.builder()
                                   .carPark(e)
                                    .build()
                    );
                });
    }

	
	public void parking(ParkingDetails parkingDetails) throws CarNotFoundException
		 {

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            carService.modifyCarParkAndDateInterval(selectedCar.getLicensePlateNumber(),
                    parkingDetails.getCarPark(), parkingDetails.getParkBegin(), parkingDetails.getParkEnd());
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "A parkolás sikeres!",
                    "Sikeresen mentve!");
            context.addMessage(null, message);
            init();
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "A parkolás sikertelen!",
                    e.getMessage() + " Sikertelen Mentés!");
            context.addMessage(null, message);
            Logger.getLogger(CarParkView.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
        
	
	public List<CarParkVo> getCarParks() {
        return carParkService.findAll();
    }
	 public CarVo getSelectedCar() {
        
		if (selectedCar == null) {
            try {
                selectedCar = carService.findByLicensePlateNumber(licensePlateNumber);
            } catch (CarNotFoundException ex) {
                Logger.getLogger(CarParkView.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return selectedCar;
		
            
      
    }
}
