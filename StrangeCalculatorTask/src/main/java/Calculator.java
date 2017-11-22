public class Calculator {

    CalculatorInterface localCalculator = new LocalCalculator();

    Calculator(CalculatorInterface calc){

    }

    Calculator(){

    }

    public Double calculate(Formula formula) {
        Double res = null;

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
                Terminal.print("Such operation is not implemented");
        }
        formula.setResult(res);
        return formula.getResult();
    }
}
