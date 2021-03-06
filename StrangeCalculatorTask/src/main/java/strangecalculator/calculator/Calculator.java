package strangecalculator.calculator;

import strangecalculator.Formula;
import strangecalculator.utils.Terminal;

public class Calculator {
    CalculatorInterface calculatorInterface;
    public Calculator(CalculatorInterface calculation) {
        calculatorInterface = calculation;
    }

    public Double calculate(Formula formula) {
        Double result = null;
        switch (formula.getSign()) {
            case '+':
                result = calculatorInterface.combine(formula.getX(), formula.getY());
                break;
            case '-':
                result = calculatorInterface.deduct(formula.getX(), formula.getY());
                break;
            case '*':
                result = calculatorInterface.multiply(formula.getX(), formula.getY());
                break;
            case '/':
                result = calculatorInterface.divide(formula.getX(), formula.getY());
                break;
            default:
                Terminal.print("Such operation is not implemented");
        }
        formula.setResult(result);
        return formula.getResult();
    }

    public void close() {
        calculatorInterface.close();
    }
}
