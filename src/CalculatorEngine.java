public class CalculatorEngine {

    private double result = 0;

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

    // Function to replace the last occurrence of a substring in another string
    public String replaceLast(String string, String substring, String replacementString) {

        // Gets the index of the last occurrence of the substring
        int index = string.lastIndexOf(substring);
        // If the substring is not found (lastIndexOf returns -1), the original string is simply returned
        if (index == -1) {
            return string;
        }
        // Pieces together the different parts of the string and returns it
        return string.substring(0, index) + replacementString + string.substring(index + substring.length());
    }

    public String updateExpression() {
        return "";
    }

    // Function to separate the expression by the operators
    public String[] evaluateExpression (String expression) {

        // Splits the expression into an array of strings based on the regex operators
        return expression.split("[*/+-]");
      }
}
