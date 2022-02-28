package by.epam.jwd.sidorenko.util;

import by.epam.jwd.sidorenko.util.constant.Constant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunctionValidation {
    public static String getFunc(String function) {
        if (!isValid(function)) {
            throw new IllegalArgumentException(Constant.INVALID_LINE);
        }
        return function;
    }

    public static boolean isValid(String function) {
        Pattern pattern = Pattern.compile(Constant.PATTERN_FOR_LINE);
        Matcher matcher = pattern.matcher(function);
        return matcher.matches();
    }
}
