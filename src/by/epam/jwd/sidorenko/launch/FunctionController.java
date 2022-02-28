package by.epam.jwd.sidorenko.launch;

import by.epam.jwd.sidorenko.function.Function;
import by.epam.jwd.sidorenko.util.FunctionValidation;
import by.epam.jwd.sidorenko.util.Printer;

public class FunctionController {
    public static void run(String function) {
        Function func = new Function(FunctionValidation.getFunc(function));
        Printer.show(func.plusOrMinus());
    }
}