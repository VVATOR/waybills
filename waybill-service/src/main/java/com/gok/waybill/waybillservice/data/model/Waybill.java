package com.gok.waybill.waybillservice.data.model;


import com.gok.waybill.waybillservice.constants.Status;
import com.gok.waybill.waybillservice.data.model.waybill.Result;
import com.gok.waybill.waybillservice.data.model.waybill.TSM;
import com.gok.waybill.waybillservice.data.model.waybill.Task;
import com.gok.waybill.waybillservice.data.model.waybill.WorkDriverAndMachine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "waybill")
public class Waybill extends Model {

    private Status status = Status.ACTIVE;

    @Column
    private String number;

    @Column
    private LocalDate date;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "machine_id")
    private Machine machine;

    @ManyToMany(cascade = CascadeType.ALL, fetch = EAGER)
    @JoinTable(
            name = "waybill_driver",
            joinColumns = @JoinColumn(name = "way_id"),
            inverseJoinColumns = @JoinColumn(name = "driv_id")
    )
    private Collection<Driver> drivers;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private Task task; //+

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "work_id")
    private WorkDriverAndMachine workDriverAndMachine; //+

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "result_id")
    private Result result; //+

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "tsm_id")
    private TSM tsm; //+

    public Waybill() {
    }
}
