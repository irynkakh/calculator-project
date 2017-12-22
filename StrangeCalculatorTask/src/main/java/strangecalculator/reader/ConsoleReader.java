package strangecalculator.reader;

import strangecalculator.Formula;
import strangecalculator.utils.Terminal;

import java.io.IOException;

public class ConsoleReader implements ReaderInterface {
    public Boolean hasNext()  {
        Boolean flag = null;
        Terminal.print("Would you like to calculate again? yes / no");
        try {
            String str = Terminal.readString();
            if (str.equals("yes")) {
                flag = true;
            } else {
                Terminal.print("Thanks for using it :-)");
                flag = false;
            }
        }
        catch (IOException ex){
            System.out.println(ex.toString());
        }
        return flag;
    }

    public Formula readNext()  {
        Formula formula = new Formula();
        try {
            Terminal.print("Enter 1st number");
            formula.setX(Terminal.readDouble());
            Terminal.print("Enter operation");
            formula.setSign(Terminal.readChar());
            Terminal.print("Enter 2nd number");
            formula.setY(Terminal.readDouble());
        }
        catch(IOException ex){
            System.out.println(ex.toString());
        }
        return formula;
    }
}
