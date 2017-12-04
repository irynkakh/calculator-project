package strangecalculator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        /*ReaderInterface consoleReader = new ConsoleReader();

        do {
            Calculator calculator = new Calculator(new LocalCalculator());
            Terminal.print("Result is => " + String.valueOf(calculator.calculate(consoleReader.readNext())));
        }
        while (consoleReader.hasNext());
        */

      /*  GoogleCalculator googleCalculator = new GoogleCalculator();
        System.out.println(googleCalculator.combine(6.5, 1.1));
        System.out.println(googleCalculator.deduct(1.01, -1.01));
        System.out.println(googleCalculator.multiply(-1.0, 2.0));
        System.out.println(googleCalculator.divide(10.00, 0.25));*/

        Menu menu = new Menu();
        menu.showMenu();


    }

}
