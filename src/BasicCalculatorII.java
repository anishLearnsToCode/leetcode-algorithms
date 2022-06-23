// https://leetcode.com/problems/basic-calculator-ii
// extremely innovative approach, using a grammar to evaluate expressions
// T: O(N)
// S: O(1)

import java.util.Set;

public class BasicCalculatorII {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char SPACE = ' ';
    
    private static final Set<Character> ADDITIVE_OPERATORS = Set.of(ADDITION, SUBTRACTION);
    private static final Set<Character> MULTIPLICATIVE_OPERATORS = Set.of(MULTIPLICATION, DIVISION);
    
    private String expression;
    private int index;

    public int calculate(String s) {
        this.expression = s;
        this.index = 0;
        return addition();
    }

    private int addition() {
        int sum = multiplication();
        while (index < expression.length() && isAdditiveOperator(expression.charAt(index))) {
            char operator = expression.charAt(index++);
            sum = applyOperator(sum, multiplication(), operator);
        }
        return sum;
    }

    private int multiplication() {
        int result = toNumber();
        while (index < expression.length() && isMultiplicativeOperator(expression.charAt(index))) {
            char operator = expression.charAt(index++);
            result = applyOperator(result, toNumber(), operator);
        }
        return result;
    }
    
    private int toNumber() {
        int number = 0;
        while (index < expression.length() && isDigitOrSpace(expression.charAt(index))) {
            if (isSpace(expression.charAt(index))) {
                index++;
                continue;
            }
            number *= 10;
            number += toDigit(expression.charAt(index));
            index++;
        }
        return number;
    }
    
    private int toDigit(char digit) {
        return digit - '0';
    }

    private boolean isDigitOrSpace(char c) {
        return Character.isDigit(c) || isSpace(c);
    }

    private boolean isSpace(char c) {
        return c == SPACE;
    }

    private int applyOperator(int a, int b, char operator) {
        return switch (operator) {
            case ADDITION -> a + b;
            case SUBTRACTION -> a - b;
            case MULTIPLICATION -> a * b;
            case DIVISION -> a / b;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }
    
    private boolean isAdditiveOperator(char operator) {
        return ADDITIVE_OPERATORS.contains(operator);
    }
    
    private boolean isMultiplicativeOperator(char operator) {
        return MULTIPLICATIVE_OPERATORS.contains(operator);
    }
}
