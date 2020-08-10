package com.kuntsevich.task1.main;

import com.kuntsevich.task1.controller.Controller;
import com.kuntsevich.task1.controller.entity.Request;
import com.kuntsevich.task1.controller.entity.Response;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Request request = new Request("FIND_ALL_OVENS", new HashMap<>());
        Response<?> response = controller.executeTask(request);
        System.out.println("response = " + response);
    }
}