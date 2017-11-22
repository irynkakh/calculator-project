import java.io.IOException;

public class ConsoleReader implements ReaderInterface {

    public Boolean hasNext() throws IOException {
        Boolean flag = null;

        Terminal.print("Would you like to calculate again? yes / no");
        String str = Terminal.readString();
        if (str.equals("yes")) {
            flag = true;
        } else {
            Terminal.print("Thanks for using it :-)");
            flag = false;
        }

        return flag;
    }

    public Formula readNext() throws IOException {
        Formula formula = new Formula();
        formula.setX(Terminal.readDouble());
        formula.setSign(Terminal.readChar());
        formula.setY(Terminal.readDouble());

        return formula;
    }
}
