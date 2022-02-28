package by.epam.jwd.sidorenko.function;

import by.epam.jwd.sidorenko.util.constant.Constant;

public class Function {
    private String[] tokens;
    private int position;

    public Function(String function) {
        this.tokens = function.split(Constant.SEPARATOR);
        this.position = 0;
    }

    public double calcValueInBrackets() {
        String token = tokens[position];
        double result;
        if (token.equals(Constant.OPEN_BRACKET)) {
            position++;
            result = plusOrMinus();
            String closingBracket;
            if (position < tokens.length) {
                closingBracket = tokens[position];
            } else {
                throw new IllegalArgumentException(Constant.END_OF_EXPRESSION);
            }
            if (closingBracket.equals(Constant.CLOSING_BRACKET)) {
                position++;
                return result;
            }
            throw new IllegalArgumentException(Constant.CLOSING_BRACKET_NOT_FOUND);
        }
        position++;
        if (Double.parseDouble(token) < 0) {
            throw new IllegalArgumentException(Constant.CHECK_NATURAL_NUMBERS);
        }
        return Double.parseDouble(token);
    }

    public double multiplyOrDivide() {
        double first = calcValueInBrackets();
        while (position < tokens.length) {
            String operator = tokens[position];
            if ((!operator.equals(Constant.MULTIPLY)) && (!operator.equals(Constant.DIVIDE))) {
                break;
            } else {
                position++;
            }
            double second = calcValueInBrackets();
            if (operator.equals(Constant.MULTIPLY)) {
                first *= second;
            } else {
                first /= second;
            }
        }
        return first;
    }

    public double plusOrMinus() {
        double first = multiplyOrDivide();
        while (position < tokens.length) {
            String operator = tokens[position];
            if ((!operator.equals(Constant.PLUS)) && (!operator.equals(Constant.MINUS))) {
                break;
            } else {
                position++;
            }
            double second = multiplyOrDivide();
            if (operator.equals(Constant.PLUS)) {
                first += second;
            } else {
                first -= second;
            }
        }
        return first;
    }
}
