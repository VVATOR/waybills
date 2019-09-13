package com.gok.waybill.waybillservice.utils.fakedata;

import com.gok.waybill.waybillservice.constants.UserRole;
import com.gok.waybill.waybillservice.data.model.CategoryMachine;
import com.gok.waybill.waybillservice.data.model.Driver;
import com.gok.waybill.waybillservice.data.model.Machine;
import com.gok.waybill.waybillservice.data.model.Waybill;
import com.gok.waybill.waybillservice.data.model.user.User;
import com.gok.waybill.waybillservice.data.model.waybill.Result;
import com.gok.waybill.waybillservice.data.model.waybill.TSM;
import com.gok.waybill.waybillservice.data.model.waybill.Task;
import com.gok.waybill.waybillservice.data.model.waybill.WorkDriverAndMachine;

import java.util.ArrayList;
import java.util.List;

import static com.gok.waybill.waybillservice.utils.fakedata.RandomGenerator.*;

public final class CommonFakeDatabase {

    // Access
    public static List<User> users = new ArrayList<User>() {{
        addAll(randomUsersList());
        add(new User(100, true, "admin", "admin", UserRole.ADMIN));
        add(new User(200, true, "user", "user", UserRole.USER));
        add(new User(300, true, "vikhlaev", "vikhlaev", UserRole.USER));

    }};

    ///// additional
    public static List<TSM> tsm = randomTsmList();

    public static List<Task> tasks = randomTasksList();

    public static List<Result> results = randomResultList();

    public static List<WorkDriverAndMachine> workDriverAndMachines = randomWorkDriverAndMachinesList();

    /// base
    public static List<CategoryMachine> categoryMachine = randomCategoryList();

    public static List<Driver> drivers = randomDriverList();

    public static List<Machine> machines = randomMachineList();

    public static List<Waybill> waybills = randomWaybillList();


}
