package javacalculator.calculator;

public class InputParser {
    private final InputValidator inputValidator;
    private final String seperator = " ";

    public InputParser() {
        this.inputValidator = new InputValidator();
    }

    public String[] parse(String inputFormula) {
        if (inputFormula == null) throw new IllegalArgumentException();
        String[] splittedInputFormula = inputFormula.split(seperator);

        if (!inputValidator.valid(splittedInputFormula)) throw new IllegalArgumentException();

        return PostfixConvertor.convert(splittedInputFormula);
    }
}
