package com.gok.waybill.waybillservice.data.model.waybill;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gok.waybill.waybillservice.data.model.Model;
import com.gok.waybill.waybillservice.data.model.Waybill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "work")
public class WorkDriverAndMachine extends Model {

    @OneToOne(optional = false, mappedBy = "workDriverAndMachine")
    @JsonIgnore
    private Waybill waybill;

    public WorkDriverAndMachine() {
        super();
    }
}
