public class Calculator {

    LocalCalculator localCalculator = new LocalCalculator();
    Double res = null;

    public Double calculate(Formula formula) {
        if (formula.getSign() == '+')
            res = localCalculator.combine(formula.getX(), formula.getY());

        switch (formula.getSign()) {
            case '+':
                res = localCalculator.combine(formula.getX(), formula.getY());
                break;
            case '-':
                res = localCalculator.deduct(formula.getX(), formula.getY());
                break;
            case '*':
                res = localCalculator.multiply(formula.getX(), formula.getY());
                break;
            case '/':
                res = localCalculator.divide(formula.getX(), formula.getY());
                break;
            default:
                System.out.println("Such operation is not implemented");
        }
        formula.setResult(res);
        return formula.getResult();
    }
}
