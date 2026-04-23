import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CalculatorEngine {

    public String[] splitExpression(String expression) {
        String str = expression;
        String[] separated = str.split("(?<=[+\\-*/%])|(?=[+\\-*/%])");
        return separated;
    }

    // Function to solve the expression
    public String[] evaluateExpression(String expression) {
        // All variables
        String str = expression;
        String stringResult = "";
        String error = "Error";
        String multi = "*";
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

        // Surrounded by Try/Catch block to check for exceptions
        try {

            // Turns all the integers into doubles
            for (String x : list) {
                index++;
                if (!List.of(multi, div, add, sub, rem,"Undefined", error, "Infinity").contains(x)) {
                    double newX = Double.parseDouble(x);
                    System.out.println(newX);
                    list.set(index - 1, String.valueOf(newX));
                }
            }

            // Loops through the expression and does multiplication and subtraction
            if (!(list.contains("Undefined") | list.contains(error) | list.contains("Infinity"))) {
                index = 0;
                while (list.size() > 1) {
                    System.out.println(list);

                    // Finds and defines negatives, instead of mixing them up with subtraction signs
                    if (list.contains(sub)) {
                        System.out.println("Found negative");
                        index = 0;
                        for (int e = 0; e < list.size(); e++) {
                            String item = list.get(e);
                            if (!(item.equals(sub))) {
                                index++;
                            } else if (item.equals(sub) && !Objects.equals(index + 1, "-")) {

                                // If negative is at the beginning of the expression
                                if (Objects.equals(index, 0) ) {
                                    double newNeg = Double.parseDouble(list.get(1));
                                    list.set(1, Double.toString(newNeg * -1));
                                    list.remove(0);
                                    index++;

                                // If negative comes after an operator
                                } else if (index > 0 && List.of("*","-","+","/","%").contains(list.get(index - 1))) {
                                    double newNeg = Double.parseDouble(list.get(index + 1));
                                    list.set(index + 1, Double.toString(newNeg * -1));
                                    list.remove(index);
                                    index++;

                                // If two - signs occur
                                } else if (Objects.equals(list.get(index), "-") && Objects.equals(list.get(index - 1), "-")) {
                                    list.set(index, "+");
                                    list.remove(index - 1);
                                    index++;

                                } else {
                                    index++;
                                }
                            }
                        }
                        System.out.println(list);
                    }

                    // For multiplication
                    if (list.contains(multi)) {
                        System.out.println("found * in list");
                        index = 0;
                        for (String item : list) {
                            System.out.println(item);
                            if (!item.equals(multi)) {
                                index++;
                            } else {
                                System.out.println("^ here it is");
                                break;
                            }
                        }
                        System.out.println("multiplying...");
                        // Integers before and after the operator
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
                        // Continues the loop
                        continue;

                    // For Division
                    } else if (list.contains(div)) {
                        System.out.println("found / in list");
                        index = 0;
                        for (String item : list) {
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
                                index = 0;
                                continue;

                            case "-":
                                System.out.println(index);
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
                                index = 0;
                                continue;
                        }
                    }
                }
            }

        // Catches any exception and turns it into an "Error" message
        } catch (Exception ex) {
            list.clear();
            list.add("Undefined");
            System.out.println("Exception error");
            stringResult = error;
        }

        // Catches if any message is already in the expression
        if (list.contains("Undefined") | list.contains(error) | list.contains("Infinity")) {
            list.clear();
            list.add(error);
            stringResult = error;
        }

        // Turns any double into an integer if it can
        if (!Objects.equals(stringResult, error)) {
            // Another try catch to catch the NumberFormatException
            try {
                double doubleResult = Double.parseDouble(stringResult);
                if (doubleResult % 1 == 0) {
                    // Long because it has more range of values
                    long newResult = (long) doubleResult;
                    stringResult = Long.toString(newResult);
                }
            } catch (Exception NumberFormatException) {
                list.clear();
                list.add("Undefined");
                System.out.println("Exception error");
                stringResult = error;
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
