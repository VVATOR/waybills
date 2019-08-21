package com.gok.waybill.waybillservice.data.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

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
    private Waybill waybill;

    public Machine() {
    }
}
