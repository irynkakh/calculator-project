package strangecalculator;

import strangecalculator.calculator.Calculator;
import strangecalculator.calculator.LocalCalculator;
import strangecalculator.reader.ConsoleReader;
import strangecalculator.reader.ReaderInterface;
import strangecalculator.utils.Terminal;

public class Main {
    public static void main(String[] args) {
        ReaderInterface consoleReader = new ConsoleReader();
        do {
            Calculator calculator = new Calculator(new LocalCalculator());

            Terminal.print("Result is => " + String.valueOf(calculator.calculate(consoleReader.readNext())));
        }
        while (consoleReader.hasNext());
    }

}
