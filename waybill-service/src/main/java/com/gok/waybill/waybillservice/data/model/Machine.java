package com.gok.waybill.waybillservice.data.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "machine")
public class Machine extends Model {
    @Column(name = "name")
    private String name;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "machine_id")
    private CategoryMachine categoryMachine;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "garage_number")
    private String garageNumber;

    @OneToOne(optional = false, mappedBy = "machine")
    @JsonIgnore
    private Waybill waybill;

    public Machine() {
        super();
    }
}
