import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ReaderInterface consoleReader = new ConsoleReader();
        do {
            Calculator calculator = new Calculator(new LocalCalculator());

            Terminal.print("Result is => " + String.valueOf(calculator.calculate(consoleReader.readNext())));
        }
        while (consoleReader.hasNext());
    }


}
