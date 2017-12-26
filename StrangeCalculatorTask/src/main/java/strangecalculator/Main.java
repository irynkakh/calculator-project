package strangecalculator;

import strangecalculator.calculator.Calculator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Menu menu = new Menu();
        Calculator calculator = new Calculator(menu.getCalculatorType());
        do {
            Formula formula = menu.getFormula().readNext();
            calculator.calculate(formula);
            menu.showResult(formula);
        }
        while (menu.getFormula().hasNext());
        calculator.close();

    }
}
