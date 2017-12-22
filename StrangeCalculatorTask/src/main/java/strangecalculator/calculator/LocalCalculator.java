package strangecalculator.calculator;

public class LocalCalculator implements CalculatorInterface {
    public Double combine(Double x, Double y) {
        return x + y;
    }

    public Double deduct(Double x, Double y) {
        return x - y;
    }

    public Double multiply(Double x, Double y) {
        return x * y;
    }

    public Double divide(Double x, Double y) {
        if (y == 0) {
            throw new IllegalArgumentException("You can not divide by 0");
        }
        return x / y;
    }

    @Override
    public void close() {
        System.out.println("Exit...");
        System.exit(0);
    }
}
