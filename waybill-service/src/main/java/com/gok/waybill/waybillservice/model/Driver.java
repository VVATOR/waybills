package com.gok.waybill.waybillservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name="driver")
public class Driver extends Model {
    @Column(name="name")
    private String name;

    @Column(name="personal_number")
    private String personalNumber;

    public Driver() {
    }
}
