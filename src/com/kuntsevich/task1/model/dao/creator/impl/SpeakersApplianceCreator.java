package com.kuntsevich.task1.model.dao.creator.impl;

import com.kuntsevich.task1.entity.Appliance;
import com.kuntsevich.task1.entity.FloatRange;
import com.kuntsevich.task1.entity.Speakers;
import com.kuntsevich.task1.exception.ApplianceCreatorException;
import com.kuntsevich.task1.model.dao.creator.ApplianceCreator;
import com.kuntsevich.task1.parser.FloatRangeParser;

import java.util.List;

public class SpeakersApplianceCreator implements ApplianceCreator {
    @Override
    public Appliance createAppliance(List<String> params) throws ApplianceCreatorException {
        try {
            int powerConsumption = Integer.parseInt(params.get(0));
            int numberOfSpeakers = Integer.parseInt(params.get(1));
            FloatRange frequencyLength = FloatRangeParser.parseFloatRange(params.get(2));
            int cordLength = Integer.parseInt(params.get(3));
            return new Speakers(powerConsumption, numberOfSpeakers, frequencyLength, cordLength);
        } catch (NumberFormatException e) {
            throw new ApplianceCreatorException("Can't create appliance because params are invalid");
        }
    }
}
