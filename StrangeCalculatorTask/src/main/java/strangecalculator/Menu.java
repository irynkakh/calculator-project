package strangecalculator;

import strangecalculator.calculator.*;
import strangecalculator.reader.ConsoleReader;
import strangecalculator.reader.ReaderInterface;
import strangecalculator.utils.Terminal;

import java.io.IOException;

public class Menu {
    public CalculatorInterface getCalculatorType() throws IOException, InterruptedException {
        CalculatorInterface calculatorType = null;
        Terminal.print("Select an option that you want and press ENTER:\n1) Local calculator\n2) Google Calculator\n3) Web Calculator\n4) Calculator Pi\n5) Exit ");

        String menu = Terminal.readString();

        switch (menu) {
            case "1":
                calculatorType = new LocalCalculator();
                break;
            case "2":
                calculatorType = new GoogleCalculator();
                break;
            case "3":
                calculatorType = new WebCalculator();
                break;
            case "4":
                calculatorType = new CalculatorPi();
                break;
            case "5":
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

