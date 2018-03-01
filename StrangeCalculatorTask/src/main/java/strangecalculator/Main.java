package strangecalculator;

import strangecalculator.calculator.GoogleCalculatorWithPureJS;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        /*Menu menu = new Menu();
        Calculator calculator = new Calculator(menu.getCalculatorType());
        do {
            Formula formula = menu.getFormula().readNext();
            calculator.calculate(formula);
            menu.showResult(formula);
        }
        while (menu.getFormula().hasNext());
        calculator.close();*/

        GoogleCalculatorWithPureJS calc = new GoogleCalculatorWithPureJS();
        calc.combine(2.0,2.0);
    }
}
