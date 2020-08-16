package com.kuntsevich.task1.parser;

import com.kuntsevich.task1.entity.FloatRange;

public class FloatRangeParser {
    public static final char HYPHEN = '-';

    public static FloatRange parseFloatRange(String str) {
        FloatRange floatRange;
        int hyphenPos = str.indexOf(HYPHEN);
        String fromStr = str.substring(0, hyphenPos);
        float from = Float.parseFloat(fromStr);
        String toStr = str.substring(hyphenPos + 1);
        float to = Float.parseFloat(toStr);
        floatRange = new FloatRange(from, to);
        return floatRange;
    }
}
