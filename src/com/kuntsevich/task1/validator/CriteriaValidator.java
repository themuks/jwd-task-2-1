package com.kuntsevich.task1.validator;

import com.kuntsevich.task1.entity.Criteria;

import java.util.regex.Pattern;

public class CriteriaValidator {
    private static final String VALIDATION_REGEX = "[A-Z][a-zA-Z]*";

    public boolean isCriteriaValid(Criteria criteria) {
        if (criteria == null) {
            return false;
        }
        String groupSearchName = criteria.getGroupSearchName();
        return Pattern.matches(VALIDATION_REGEX, groupSearchName);
    }
}
