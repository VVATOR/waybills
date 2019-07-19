package com.gok.waybill.waybillservice.utils.fakedata;

import com.github.javafaker.Faker;
import com.gok.waybill.waybillservice.model.CategoryMachine;
import com.gok.waybill.waybillservice.model.Driver;
import com.gok.waybill.waybillservice.model.Machine;
import com.gok.waybill.waybillservice.model.Waybill;
import com.gok.waybill.waybillservice.model.waybill.Result;
import com.gok.waybill.waybillservice.model.waybill.TSM;
import com.gok.waybill.waybillservice.model.waybill.WorkDriverAndMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.gok.waybill.waybillservice.utils.fakedata.CommonFakeDatabase.*;

public final class RandomGenerator {
    private static Faker faker = new Faker();

    public static List<CategoryMachine> randomCategoryList() {
        List<CategoryMachine> randomCategoryMachineList = new ArrayList<>();
        Random r = new Random(3);
        int max = r.nextInt() + 5;
        for (int i = 0; i < 10; i++) {
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
        Random r = new Random(3);
        int max = r.nextInt() + 5;
        for (int i = 0; i < 10; i++) {
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
        Random r = new Random(3);
        int max = r.nextInt() + 5;
        for (int i = 0; i < 10; i++) {
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
        Random r = new Random(3);
        int max = r.nextInt() + 5;
        for (int i = 0; i < 10; i++) {
            TSM tsm = TSM.builder()
                    .amountOfFuel(faker.number().numberBetween(0,100))
                    .fuelingDate(faker.date().birthday())
                    .startedAmountOfFuel(faker.number().numberBetween(0,100))
                    .finalAmountOfFuel(faker.number().numberBetween(0,20))
                    .fuelType(faker.beer().name())
                    //.machine(machines.get(new Random().nextInt(machines.size())))
                    .build();
            tsm.setId(i);
            randomTsmList.add(tsm);
        }

        return randomTsmList;
    }

 public static List<Result> randomResultList() {
        List<Result> randomTsmList = new ArrayList<>();
        Random r = new Random(3);
        int max = r.nextInt() + 5;
        for (int i = 0; i < 10; i++) {
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
        Random r = new Random(3);
        int max = r.nextInt() + 5;
        for (int i = 0; i < 10; i++) {
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
        Random r = new Random(3);
        int max = r.nextInt() + 5;
        for (int i = 0; i < 10; i++) {
            Waybill waybill = Waybill.builder()
                    .number(faker.number().digits(5))
                    .date(faker.date().birthday())
                    .driver(drivers.get(new Random().nextInt(drivers.size())))
                    .machine(machines.get(new Random().nextInt(machines.size())))
                    .tsm(tsm.get(new Random().nextInt(tsm.size())))
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
