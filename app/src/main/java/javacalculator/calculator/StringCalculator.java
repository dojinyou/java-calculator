package javacalculator.calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringCalculator {
    InputParser parser;
    Deque<Double> stack;

    public StringCalculator() {
        parser = new InputParser();
        stack = new ArrayDeque<>();
    }

    public double calculate(String stringFormula) throws Exception {
        String[] postfixFormula = parser.parse(stringFormula);
        for (String element : postfixFormula) {
            if (Operator.isTextOperator(element)) {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                stack.push(operation(operand1,operand2,element));
                continue;
            }
            stack.push(Double.parseDouble(element));
        }
        return stack.pop();
    }

    private double operation(double operand1, double operand2, String textOperator) {
        if (!Operator.isTextOperator(textOperator)) throw new IllegalArgumentException(textOperator+ "는 올바르지 않은 연산자 입니다.");
        Operator operator = Operator.getOperator(textOperator);
        return operator.apply(operand1,operand2);
    }
}
