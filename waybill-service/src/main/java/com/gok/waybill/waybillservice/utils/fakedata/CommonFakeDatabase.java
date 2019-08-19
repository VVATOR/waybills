package com.gok.waybill.waybillservice.utils.fakedata;

import com.gok.waybill.waybillservice.data.model.CategoryMachine;
import com.gok.waybill.waybillservice.data.model.Driver;
import com.gok.waybill.waybillservice.data.model.Machine;
import com.gok.waybill.waybillservice.data.model.Waybill;
import com.gok.waybill.waybillservice.data.model.waybill.Result;
import com.gok.waybill.waybillservice.data.model.waybill.TSM;
import com.gok.waybill.waybillservice.data.model.waybill.WorkDriverAndMachine;

import java.util.List;

import static com.gok.waybill.waybillservice.utils.fakedata.RandomGenerator.*;

public final class CommonFakeDatabase {
    ///// additional
    public static List<TSM> tsm = randomTsmList();

    public static List<Result> results = randomResultList();

    public static List<WorkDriverAndMachine> workDriverAndMachines = randomWorkDriverAndMachinesList();

    /// base
    public static List<CategoryMachine> categoryMachine = randomCategoryList();

    public static List<Driver> drivers = randomDriverList();

    public static List<Machine> machines = randomMachineList();

    public static List<Waybill> waybills = randomWaybillList();


}
