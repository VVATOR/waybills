package com.gok.waybill.waybillservice.utils.fakedata;

import com.github.javafaker.Faker;
import com.gok.waybill.waybillservice.data.model.CategoryMachine;
import com.gok.waybill.waybillservice.data.model.Driver;
import com.gok.waybill.waybillservice.data.model.Machine;
import com.gok.waybill.waybillservice.data.model.Waybill;
import com.gok.waybill.waybillservice.data.model.constants.Status;
import com.gok.waybill.waybillservice.data.model.user.Role;
import com.gok.waybill.waybillservice.data.model.user.User;
import com.gok.waybill.waybillservice.data.model.waybill.Result;
import com.gok.waybill.waybillservice.data.model.waybill.TSM;
import com.gok.waybill.waybillservice.data.model.waybill.Task;
import com.gok.waybill.waybillservice.data.model.waybill.WorkDriverAndMachine;

import java.time.LocalDate;
import java.util.*;

import static com.gok.waybill.waybillservice.utils.TimeUtils.convertToLocalDateViaMilisecond;
import static com.gok.waybill.waybillservice.utils.fakedata.CommonFakeDatabase.*;

public final class RandomGenerator {

    private static Faker faker = new Faker(new Locale("ru"));
    private static Random r = new Random(3);

    private RandomGenerator() {
    }

    public static List<User> randomUsersList() {
        List<User> randomUserList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            User user = User.builder()
                    .login(faker.pokemon().name())
                    .password(faker.number().digits(3))
                    .role(Role.values()[r.nextInt(Role.values().length)])
                    .build();
            user.setId(i);
            randomUserList.add(user);
        }

        return randomUserList;
    }

    public static List<CategoryMachine> randomCategoryList() {
        List<CategoryMachine> randomCategoryMachineList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            CategoryMachine categoryMachine = CategoryMachine.builder()
                    .name(faker.company().name())
                    .build();
            categoryMachine.setId(i);
            randomCategoryMachineList.add(categoryMachine);
        }

        return randomCategoryMachineList;
    }

    public static List<Machine> randomMachineList() {
        List<Machine> randomMachineList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Machine machine = Machine.builder()
                    .name(faker.app().name())
                    .garageNumber(faker.number().digit())
                    .registrationNumber(faker.number().digit())
                    .categoryMachine(categoryMachine.get(new Random().nextInt(categoryMachine.size())))
                    .build();
            machine.setId(i);
            randomMachineList.add(machine);
        }

        return randomMachineList;
    }


    public static List<Driver> randomDriverList() {
        List<Driver> randomDriverList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Driver driver = Driver.builder()
                    .name(faker.name().name())
                    .personalNumber("" + r.nextInt(10000))
                    .build();
            driver.setId(i);
            randomDriverList.add(driver);
        }

        return randomDriverList;
    }


    public static List<TSM> randomTsmList() {
        List<TSM> randomTsmList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            TSM tsm = TSM.builder()
                    .amountOfFuel(faker.number().numberBetween(0, 100))
                    .fuelingDate(LocalDate.now().plusDays(r.nextInt(100)))
                    .startedAmountOfFuel(faker.number().numberBetween(0, 100))
                    .finalAmountOfFuel(faker.number().numberBetween(0, 20))
                    .fuelType(faker.beer().name())
                    .build();
            tsm.setId(i);
            randomTsmList.add(tsm);
        }

        return randomTsmList;
    }

    public static List<Task> randomTasksList() {
        List<Task> randomTaskList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Task task = Task.builder()
                    .cargo(faker.beer().name())
                    .customer(faker.pokemon().name())
                    .dateArriving(LocalDate.now().plusDays(r.nextInt(100)))
                    .dateDeparture(LocalDate.now().minusDays(r.nextInt(100)))
                    .departurePoint(faker.address().city())
                    .destinationPoint(faker.address().city())
                    .build();
            task.setId(i);
            randomTaskList.add(task);
        }

        return randomTaskList;
    }

    public static List<Result> randomResultList() {
        List<Result> randomTsmList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Result result = Result.builder()
                    // .amountOfFuel(faker.number().numberBetween(0,100))
                    // .fuelingDate(faker.date().birthday())
                    //  .startedAmountOfFuel(faker.number().numberBetween(0,100))
                    //  .finalAmountOfFuel(faker.number().numberBetween(0,20))
                    //  .fuelType(faker.beer().name())
                    //.machine(machines.get(new Random().nextInt(machines.size())))
                    .build();
            result.setId(i);
            randomTsmList.add(result);
        }

        return randomTsmList;
    }

    public static List<WorkDriverAndMachine> randomWorkDriverAndMachinesList() {
        List<WorkDriverAndMachine> workDriverAndMachines = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            WorkDriverAndMachine workDriverAndMachine = WorkDriverAndMachine.builder()
                    // .amountOfFuel(faker.number().numberBetween(0,100))
                    // .fuelingDate(faker.date().birthday())
                    //  .startedAmountOfFuel(faker.number().numberBetween(0,100))
                    //  .finalAmountOfFuel(faker.number().numberBetween(0,20))
                    //  .fuelType(faker.beer().name())
                    //.machine(machines.get(new Random().nextInt(machines.size())))
                    .build();
            workDriverAndMachine.setId(i);
            workDriverAndMachines.add(workDriverAndMachine);
        }

        return workDriverAndMachines;
    }

    public static List<Waybill> randomWaybillList() {
        List<Waybill> randomWaybillList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Waybill waybill = Waybill.builder()
                    .status(Status.values()[new Random().nextInt(Status.values().length)])
                    .number(faker.number().digits(5))
                    .date(convertToLocalDateViaMilisecond(faker.date().birthday()))
                    .drivers(Arrays.asList(drivers.get(new Random().nextInt(drivers.size()))))
                    .machine(machines.get(new Random().nextInt(machines.size())))
                    .tsm(tsm.get(new Random().nextInt(tsm.size())))
                    .task(tasks.get(new Random().nextInt(tasks.size())))
                    .result(results.get(new Random().nextInt(results.size())))
                    .workDriverAndMachine(workDriverAndMachines.get(new Random().nextInt(workDriverAndMachines.size())))
                    //.machine(machines.get(new Random().nextInt(machines.size())))
                    .build();
            waybill.setId(i);
            randomWaybillList.add(waybill);
        }
        return randomWaybillList;
    }

}
