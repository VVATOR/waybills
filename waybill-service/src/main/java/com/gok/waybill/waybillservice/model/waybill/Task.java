package com.gok.waybill.waybillservice.model.waybill;

import com.gok.waybill.waybillservice.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Task extends Model {
    private String customer;
    private Date dateArriving;
    private Date dateDeparture;
    private String departurePoint;
    private String destinationPoint;
    private String cargo;

}
