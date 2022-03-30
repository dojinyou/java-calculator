package javacalculator.calculator;

public enum Operator {
    PLUS("+", 0) {
        @Override
        public double apply(double operand1, double operand2) {
            return operand1 + operand2;
        }
    },
    MINUS("-", 0) {
        @Override
        public double apply(double operand1, double operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLY("*", 1) {
        @Override
        public double apply(double operand1, double operand2) {
            return operand1 * operand2;
        }
    },
    DIVIED("/", 1) {
        @Override
        public double apply(double operand1, double operand2) {
            if (operand2 == 0.0) {
                throw new IllegalArgumentException();
            }
            return operand1 / operand2;
        }
    };

    private final String textOperator;
    private final int priority;

    Operator(String textOperator, int priority) {
        this.textOperator = textOperator;
        this.priority = priority;
    }


    public static int getPriority(String operator) {
        if (PLUS.getTextOperator().equals(operator)) return PLUS.priority;
        if (MINUS.getTextOperator().equals(operator)) return MINUS.priority;
        if (MULTIPLY.getTextOperator().equals(operator)) return MULTIPLY.priority;
        if (DIVIED.getTextOperator().equals(operator)) return DIVIED.priority;
        return -1;
    }

    public static boolean isTextOperator(String operator) {
        for (Operator op : Operator.values()) {
            if (op.getTextOperator().equals(operator)) return true;
        }
        return false;
    }

    public static Operator getOperator(String textOperator) {
        Operator operator = null;
        if (PLUS.getTextOperator().equals(textOperator)) operator = Operator.PLUS;
        if (MINUS.getTextOperator().equals(textOperator)) operator = Operator.MINUS;
        if (MULTIPLY.getTextOperator().equals(textOperator)) operator = Operator.MULTIPLY;
        if (DIVIED.getTextOperator().equals(textOperator)) operator = Operator.DIVIED;

        if (operator == null) throw new IllegalArgumentException("올 바르지 않은 연산자입니다.");
        return operator;
    }

    public abstract double apply(double operand1, double operand2);
    public String getTextOperator() {
        return this.textOperator;
    }
}
