package strangecalculator;

import strangecalculator.calculator.Calculator;
import strangecalculator.calculator.GoogleCalculator;
import strangecalculator.calculator.LocalCalculator;
import strangecalculator.reader.ConsoleReader;
import strangecalculator.reader.ReaderInterface;
import strangecalculator.utils.Terminal;

import java.io.IOException;

public class Menu {
    public void showMenu() throws IOException, InterruptedException, IOException {
        Terminal.print("Select an option that you want and press ENTER: 1) - Local calculator 2) - Google Calculator 3) Exit ");
        String menu = Terminal.readString();

        switch (menu) {
            case "1":
                runLocalCalculator();
                break;
            case "2":
                runGoogleCalculator();
                break;
            case "3":
                exitApp();
                break;
            default: {
                System.out.println("Menu doesn't include this option. Please try again");
                Thread.sleep(1000);
                System.exit(1);
            }
        }
    }

    public void exitApp() {
        System.out.println("Exit...");
        System.exit(0);
    }

    public void runLocalCalculator() {
        ReaderInterface consoleReader = new ConsoleReader();

        do {
            Calculator calculator = new Calculator(new LocalCalculator());
            Terminal.print("Result is => " + String.valueOf(calculator.calculate(consoleReader.readNext())));
        }
        while (consoleReader.hasNext());
    }

    public void runGoogleCalculator() {
        GoogleCalculator googleCalculator = new GoogleCalculator();
        System.out.println(googleCalculator.combine(6.5, 1.1));
        System.out.println(googleCalculator.deduct(1.01, -1.01));
        System.out.println(googleCalculator.multiply(-1.0, 2.0));
        System.out.println(googleCalculator.divide(10.00, 0.25));
    }
}

