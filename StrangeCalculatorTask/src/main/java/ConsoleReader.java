import java.io.IOException;

public class ConsoleReader implements ReaderInterface {

    Formula formula = new Formula();

    public Boolean hasNext() throws IOException {
        Boolean flag = null;

        Singleton.Print("Would you like to calculate again? yes / no");
        String str = Singleton.readString();
        if (str.equals("yes")) {

            flag = true;
        } else {
            System.out.println("Thanks for using it :-)");
            flag = false;
        }

        return flag;
    }

    public Formula readNext() throws IOException {
        formula.setX(Singleton.readDouble());
        formula.setSign(Singleton.readChar());
        formula.setY(Singleton.readDouble());

        return formula;
    }
}
