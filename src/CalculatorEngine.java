import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class CalculatorEngine {

    private double result = 0;
    public String updateExpression() {
        return "";
    }

    // Function to solve the expression
    public String[] evaluateExpression(String expression) {
        String str = expression;
        String stringResult = "";
        String error = "Error";
        String mult = "*";
        String div = "/";
        String rem = "%";
        String add = "+";
        String sub = "-";
        int index = 0;

        // Splits the expression by the operators
        String[] separated = str.split("(?<=[+\\-*/%])|(?=[+\\-*/%])");
        System.out.println(separated);
        List<String> list = new ArrayList<>(Arrays.asList(separated));
        System.out.println(list);
        System.out.println("printing out integers into doubles...");
        // Turns all the integers into doubles
        for (String x : list) {
            index++;
            if (!(x.equals(mult) | x.equals(div) | x.equals(add) | x.equals(sub) | x.equals(rem) | x.equals("Undefined") | x.equals(error) | x.equals("Infinity") | x.equals("That button doesn't work"))) {
                double newX = Double.parseDouble(x);
                System.out.println(newX);
                list.set(index - 1, String.valueOf(newX));
            }
        }

        // Loops through the expression and does multiplication and subtraction
        try {
            if (!(list.contains("Undefined") | list.contains(error) | list.contains("That button doesn't work") | list.contains("Infinity"))) {
                index = 0;
                while (list.size() > 1) {
                    System.out.println(list);

                    // For multiplication
                    if (list.contains(mult)) {
                        System.out.println("found * in list");
                        index = 0;
                        for (String item : list) {
                            System.out.println(item);
                            if (!item.equals(mult)) {
                                index++;
                            } else {
                                System.out.println("^ here it is");
                                break;
                            }
                        }
                        System.out.println("multiplying...");
                        int aPlace = index - 1;
                        int bPlace = index + 1;
                        String a = list.get(aPlace);
                        String b = list.get(bPlace);
                        // Turns integers into doubles
                        double doubleA = Double.parseDouble(a);
                        double doubleB = Double.parseDouble(b);
                        // Does the operation
                        double doubleResult = doubleA * doubleB;
                        stringResult = Double.toString(doubleResult);
                        list.set(aPlace, stringResult);
                        // Removes one place and continues the loop
                        list.remove(bPlace);
                        list.remove(index);
                        System.out.println("the result is " + stringResult);
                        System.out.println(list);
                        continue;

                    // For Division
                    } else if (list.contains(div)) {
                        System.out.println("found / in list");
                        index = 0;
                        for (String item : list) {
                            System.out.println(item);
                            if (!item.equals(div)) {
                                index++;
                            } else {
                                System.out.println("^ here it is");
                                break;
                            }
                        }
                        System.out.println("dividing...");
                        int aPlace = index - 1;
                        int bPlace = index + 1;
                        String a = list.get(aPlace);
                        String b = list.get(bPlace);
                        double doubleA = Double.parseDouble(a);
                        double doubleB = Double.parseDouble(b);
                        double doubleResult = doubleA / doubleB;
                        stringResult = Double.toString(doubleResult);
                        list.set(aPlace, stringResult);
                        list.remove(bPlace);
                        list.remove(index);
                        System.out.println("the result is " + stringResult);
                        System.out.println(list);
                        continue;

                    // For division with remainder
                    } else if (list.contains(rem)) {
                        System.out.println("found % in list");
                        index = 0;
                        for (String item : list) {
                            System.out.println(item);
                            if (!item.equals(rem)) {
                                index++;
                            } else {
                                System.out.println("^ here it is");
                                break;
                            }
                        }
                        System.out.println("dividing...");
                        int aPlace = index - 1;
                        int bPlace = index + 1;
                        String a = list.get(aPlace);
                        String b = list.get(bPlace);
                        double doubleA = Double.parseDouble(a);
                        double doubleB = Double.parseDouble(b);
                        double doubleResult = doubleA % doubleB;
                        stringResult = Double.toString(doubleResult);
                        list.set(aPlace, stringResult);
                        list.remove(bPlace);
                        list.remove(index);
                        System.out.println("the result is " + stringResult);
                        System.out.println(list);
                        continue;


                    }

                    // Match-case for the addition and subtraction
                    index = 0;
                    for (int i = 0; i < list.size(); i++) {
                        String testItem = list.get(i);
                        index++;
                        switch (testItem) {
                            case "+":
                                System.out.println("found + in  list");
                                System.out.println("adding...");
                                int aPlace = index - 2;
                                int bPlace = index;
                                String a = list.get(aPlace);
                                String b = list.get(bPlace);
                                double doubleA = Double.parseDouble(a);
                                double doubleB = Double.parseDouble(b);
                                double doubleResult = doubleA + doubleB;
                                stringResult = Double.toString(doubleResult);
                                list.set(aPlace, stringResult);
                                list.remove(bPlace);
                                list.remove(index - 1);
                                System.out.println("the result is " + stringResult);
                                System.out.println(list);
                                continue;

                            case "-":
                                System.out.println("found - in list");
                                System.out.println("subtracting...");
                                aPlace = index - 2;
                                bPlace = index;
                                a = list.get(aPlace);
                                b = list.get(bPlace);
                                doubleA = Double.parseDouble(a);
                                doubleB = Double.parseDouble(b);
                                doubleResult = doubleA - doubleB;
                                stringResult = Double.toString(doubleResult);
                                list.set(aPlace, stringResult);
                                list.remove(bPlace);
                                list.remove(index - 1);
                                System.out.println("the result is " + stringResult);
                                System.out.println(list);
                                continue;
                        }
                    }
                }
            }

        // Catches any exception and turns it into an "Error" message
        } catch (Exception e) {
            list.clear();
            list.add("Undefined");
            stringResult = error;
        }

        // Catches if any message is already in the expression
        if (list.contains("Undefined") | list.contains("Error") | list.contains("That button doesn't work") | list.contains("Infinity")) {
            list.clear();
            list.add("Undefined");
            stringResult = error;
        }

        // Turns any double into a integer if it can
        if (!Objects.equals(stringResult, error)) {
            double doubleResult = Double.parseDouble(stringResult);
            if (doubleResult % 1 == 0) {
                // used long because it has more range of values
                long newResult = (long) doubleResult;
                stringResult = Long.toString(newResult);
            }

            // Switches NaN message to an "Undefined" message
            if (Objects.equals(stringResult, "NaN")) {
                stringResult = "Undefined";
            }
        }
        // Returns result of expression
        return new String[]{stringResult};
    }
}
