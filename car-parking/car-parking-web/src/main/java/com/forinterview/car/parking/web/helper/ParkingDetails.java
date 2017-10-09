/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forinterview.car.parking.web.helper;

import com.forinterview.car.parking.client.api.Vo.CarParkVo;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingDetails {

    private CarParkVo carPark;
    private Date parkBegin;
    private Date parkEnd;
}