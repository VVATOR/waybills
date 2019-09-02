package com.gok.waybill.waybillservice.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "category_machine")
public class CategoryMachine extends Model {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "categoryMachine", fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Machine> machines;

    public CategoryMachine() {
        super();
    }
}

