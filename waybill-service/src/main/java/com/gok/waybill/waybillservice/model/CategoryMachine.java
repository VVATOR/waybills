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
@Table(name="category_machine")
public class CategoryMachine extends Model {

    @Column(name="name")
    private String name;

    public CategoryMachine() {
    }
}

