package by.epam.jwd.sidorenko.util;

import by.epam.jwd.sidorenko.util.constant.Constant;

public class Printer {
    public static void show(double result) {
        System.out.printf(Constant.EQUAL + Constant.DOUBLE_SPECIFIER, result);
    }
}
