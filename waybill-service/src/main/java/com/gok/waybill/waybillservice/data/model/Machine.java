package com.gok.waybill.waybillservice.data.model;


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

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_machine", nullable = false, updatable = false)
    private CategoryMachine categoryMachine;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "garage_number")
    private String garageNumber;

    public Machine() {
    }
}
