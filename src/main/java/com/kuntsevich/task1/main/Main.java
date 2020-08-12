package com.kuntsevich.task1.main;

import com.kuntsevich.task1.controller.Controller;
import com.kuntsevich.task1.controller.entity.Request;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        System.out.println("response = " + controller.executeTask(new Request("FIND_ALL_OVENS", new HashMap<>())));
        System.out.println("response = " + controller.executeTask(new Request("FIND_ALL_LAPTOPS", new HashMap<>())));
        System.out.println("response = " + controller.executeTask(new Request("FIND_ALL_REFRIGERATORS", new HashMap<>())));
        System.out.println("response = " + controller.executeTask(new Request("FIND_ALL_VACUUM_CLEANERS", new HashMap<>())));
        System.out.println("response = " + controller.executeTask(new Request("FIND_ALL_TABLET_PCS", new HashMap<>())));
        System.out.println("response = " + controller.executeTask(new Request("FIND_ALL_SPEAKERS", new HashMap<>())));
    }
}