package com.gok.waybill.waybillservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@MappedSuperclass
public abstract class Model {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="is_deleted")
    private boolean isDeleted = false;

    public Model() {
    }
}

