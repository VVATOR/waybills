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

    private CommonFakeDatabase() {
        super();
    }

    // Access
    public static final List<User> users = initBaseUsersList();

    private static List<User> initBaseUsersList() {
        List<User> users = new ArrayList<>(randomUsersList());
        users.add(new User(100, true, "admin", "admin", UserRole.ADMIN));
        users.add(new User(200, true, "user", "user", UserRole.USER));
        users.add(new User(300, true, "vikhlaev", "vikhlaev", UserRole.USER));
        return users;
    }

    ///// additional
    public static final List<TSM> tsm = randomTsmList();

    public static final List<Task> tasks = randomTasksList();

    public static final List<Result> results = randomResultList();

    public static final List<WorkDriverAndMachine> workDriverAndMachines = randomWorkDriverAndMachinesList();

    /// base
    public static final List<CategoryMachine> categoryMachine = randomCategoryList();

    public static final List<Driver> drivers = randomDriverList();

    public static final List<Machine> machines = randomMachineList();

    public static final List<Waybill> waybills = randomWaybillList();


}
