import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ConsoleReader consoleReader = new ConsoleReader();
        Formula formula = new Formula();
        do {
            Calculator calculator = new Calculator();
            System.out.println(calculator.calculate(consoleReader.readNext()));
        }
        while (consoleReader.hasNext() == true);
    }
}
