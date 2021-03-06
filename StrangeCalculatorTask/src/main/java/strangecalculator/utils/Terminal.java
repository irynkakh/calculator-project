package strangecalculator.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Terminal {
    public static void print(String text) {
        System.out.println(text);
    }

    public static String readString() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        return str;
    }

    public static Double readDouble() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Double number = null;
        try {
            number = Double.parseDouble(bufferedReader.readLine());
        } catch (NumberFormatException nfe) {
            print("Is not a number");
        }
        return number;
    }

    public static Character readChar() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Character chr = bufferedReader.readLine().charAt(0);
        return chr;
    }
}
