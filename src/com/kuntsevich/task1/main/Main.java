package com.kuntsevich.task1.main;

import com.kuntsevich.task1.controller.Controller;
import com.kuntsevich.task1.controller.entity.Request;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("applianceName", "Oven");
        System.out.println("response = " + controller.executeTask(new Request("FIND_ALL_APPLIANCES", hashMap)));
        hashMap.clear();
        hashMap.put("applianceName", "Laptop");
        System.out.println("response = " + controller.executeTask(new Request("FIND_ALL_APPLIANCES", hashMap)));
        hashMap.clear();
        hashMap.put("applianceName", "Refrigerator");
        System.out.println("response = " + controller.executeTask(new Request("FIND_ALL_APPLIANCES", hashMap)));
        hashMap.clear();
        hashMap.put("applianceName", "Speakers");
        System.out.println("response = " + controller.executeTask(new Request("FIND_ALL_APPLIANCES", hashMap)));
        hashMap.clear();
        hashMap.put("applianceName", "TabletPC");
        System.out.println("response = " + controller.executeTask(new Request("FIND_ALL_APPLIANCES", hashMap)));
        hashMap.clear();
        hashMap.put("applianceName", "VacuumCleaner");
        System.out.println("response = " + controller.executeTask(new Request("FIND_ALL_APPLIANCES", hashMap)));
    }
}