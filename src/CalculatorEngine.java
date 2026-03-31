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

    //Function to replace the last occurrence of one string in another string
    public String replaceLast(String string, String substring, String replacementString) {
        ;
        int index = string.lastIndexOf(substring);

        if (index == -1) {
            return string;
        }

        return string.substring(0, index) + replacementString + string.substring(index + substring.length());
    }

    public String updateExpression() {
        return "";
    }

    // Function to separate the expression by the operators
    public String[] evaluateExpression (String expression) {

        // String to store the regular expression
        //String regex = "*/+-";
        // Splits the expression into an array of strings based on the operators in regex
        String [] arrayOfNum = expression.split("[*/+-]");

        return arrayOfNum;
      }
}
