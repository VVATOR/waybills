package com.gok.waybill.waybillservice.data.model.waybill;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gok.waybill.waybillservice.data.model.Model;
import com.gok.waybill.waybillservice.data.model.Waybill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "task")
public class Task extends Model {

    @Column(name = "customer")
    private String customer;

    @Column(name = "date_arriving")
    private LocalDate dateArriving;

    @Column(name = "date_departure")
    private LocalDate dateDeparture;

    @Column(name = "departure_point")
    private String departurePoint;

    @Column(name = "destination_point")
    private String destinationPoint;

    @Column(name = "cargo")
    private String cargo;

    @OneToOne(optional = false, mappedBy = "task")
    @JsonIgnore
    private Waybill waybill;

    public Task() {
        super();
    }
}
