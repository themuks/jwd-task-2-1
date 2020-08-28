package com.kuntsevich.task1.main;

import com.kuntsevich.task1.controller.Controller;
import com.kuntsevich.task1.controller.entity.Request;
import com.kuntsevich.task1.entity.*;

import java.util.HashMap;
import java.util.Map;

public class Main extends PrintResponseInfo {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Map<String, Object> params = new HashMap<>();
        String command = "FIND_APPLIANCE";
        Map<String, Object> criteriaParams = new HashMap<>();

        params.put("applianceName", Oven.class.getSimpleName());
        criteriaParams.put(SearchCriteria.Oven.CAPACITY.toString(), 33);
        params.put("criteriaParams", criteriaParams);
        printResponseInfo(controller.executeTask(new Request(command, params)));
        criteriaParams.clear();

        params.put("applianceName", Laptop.class.getSimpleName());
        criteriaParams.put(SearchCriteria.Laptop.SYSTEM_MEMORY.toString(), 1000);
        params.put("criteriaParams", criteriaParams);
        printResponseInfo(controller.executeTask(new Request(command, params)));
        criteriaParams.clear();

        params.put("applianceName", Refrigerator.class.getSimpleName());
        criteriaParams.put(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString(), 300);
        params.put("criteriaParams", criteriaParams);
        printResponseInfo(controller.executeTask(new Request(command, params)));
        criteriaParams.clear();

        params.put("applianceName", Speakers.class.getSimpleName());
        criteriaParams.put(SearchCriteria.Speakers.FREQUENCY_RANGE.toString(), new FloatRange(3, 4));
        params.put("criteriaParams", criteriaParams);
        printResponseInfo(controller.executeTask(new Request(command, params)));
        criteriaParams.clear();

        params.put("applianceName", TabletPC.class.getSimpleName());
        criteriaParams.put(SearchCriteria.TabletPC.MEMORY_ROM.toString(), 8000);
        params.put("criteriaParams", criteriaParams);
        printResponseInfo(controller.executeTask(new Request(command, params)));
        criteriaParams.clear();

        params.put("applianceName", VacuumCleaner.class.getSimpleName());
        criteriaParams.put(SearchCriteria.VacuumCleaner.WAND_TYPE.toString(), "all-in-one");
        params.put("criteriaParams", criteriaParams);
        printResponseInfo(controller.executeTask(new Request(command, params)));
    }
}