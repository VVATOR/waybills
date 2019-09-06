package com.gok.waybill.waybillservice.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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
    @JsonIgnore
    private Collection<Waybill> waybills;

    public Driver() {
        super();
    }
}
