package strangecalculator;

import strangecalculator.calculator.CalculatorInterface;
import strangecalculator.calculator.GoogleCalculator;
import strangecalculator.calculator.LocalCalculator;
import strangecalculator.reader.ConsoleReader;
import strangecalculator.reader.ReaderInterface;
import strangecalculator.utils.Terminal;

import java.io.IOException;

public class Menu {
    public CalculatorInterface getCalculatorType() throws IOException, InterruptedException {
        CalculatorInterface calculatorType = null;
        Terminal.print("Select an option that you want and press ENTER:\n1) Local calculator\n2) Google Calculator \n3) Exit ");
        String menu = Terminal.readString();

        switch (menu) {
            case "1":
                calculatorType = new LocalCalculator();
                break;
            case "2":
                calculatorType = new GoogleCalculator();
                break;
            case "3":
                exitApp();
                break;
            default: {
                System.out.println("Menu doesn't include this option. Please try again");
                exitApp();
            }
        }
        return calculatorType;
    }

    public ReaderInterface getFormula() {
        ReaderInterface consoleReader = new ConsoleReader();;
        return consoleReader;
    }

    public void showResult(Formula formula) {
        Terminal.print("Result is => " + formula.getResult());
    }

    private void exitApp() {
        System.out.println("Exit...");
        System.exit(0);
    }
}

