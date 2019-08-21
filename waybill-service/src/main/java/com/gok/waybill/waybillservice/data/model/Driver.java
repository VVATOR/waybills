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
@Table(name = "driver")
public class Driver extends Model {
    @Column(name = "name")
    private String name;

    @Column(name = "personal_number")
    private String personalNumber;

    @ManyToMany(mappedBy = "drivers")
    private Collection<Waybill> waybills;

    public Driver() {
    }
}
