package com.kuntsevich.task1.controller.command.impl;

import com.kuntsevich.task1.controller.command.Command;
import com.kuntsevich.task1.controller.entity.Response;
import com.kuntsevich.task1.entity.Speakers;
import com.kuntsevich.task1.exception.ServiceException;
import com.kuntsevich.task1.model.service.impl.SpeakersApplianceServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindAllSpeakersCommand implements Command {
    @Override
    public Response<?> execute(Map<String, String> params) {
        Response<Speakers> response;
        SpeakersApplianceServiceImpl speakersApplianceService = new SpeakersApplianceServiceImpl();
        try {
            List<Speakers> speakers = speakersApplianceService.findAll();
            response = new Response<>(false, speakers);
        } catch (ServiceException e) {
            response = new Response<>(true, new ArrayList<>());
        }
        return response;
    }
}
