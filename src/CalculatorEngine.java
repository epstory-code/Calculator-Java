import java.util.regex.Pattern;

/**
 * CLass to implement functionality of calculator.
 *
 * */
public class CalculatorEngine {

    private double result = 0;

    // Constructor for Calculator Engine

    /*Methods to implement math operations*/

    public double add(double a, double b) {
        result = a + b;
        return result;
    }

    public double subtract(double a, double b) {
        result = a - b;
        return result;
    }

    public double multiply(double a, double b) {
        result = a * b;
        return result;
    }

    public double divide(double a, double b) {
        result = a / b;
        return 0.0;
    }

    public double modulus (double a, double b) {
        result = a * b;
        return result;
    }

    public double switchSign(double a) {
        result = a * -1;
        return result;
    }

    public String updateExpression() {
        return "";
    }

    // Function to separate the expression by the operators
    public void evaluateExpression (String expression) {

        // String to store the regular expression
        //String regex = "*/+-";
        // Splits the expression into an array of strings based on the operators in regex
        String [] array = expression.split("[*/+-]");
        for (String s: array) {
            System.out.println(s);
      }
    }
}
