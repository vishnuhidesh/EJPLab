import Arithmetic.CalculatorPOA;

public class CalculatorImpl extends CalculatorPOA {
    public float add(float operand1, float operand2) {
        return operand1 + operand2;
    }

    public float subtract(float operand1, float operand2) {
        return operand1 - operand2;
    }

    public float multiply(float operand1, float operand2) {
        return operand1 * operand2;
    }

    public float divide(float operand1, float operand2) {
        if (operand2 != 0) {
            return operand1 / operand2;
        } else {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }
}
