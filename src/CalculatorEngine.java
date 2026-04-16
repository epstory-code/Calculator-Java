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

    // Function to separate the expression by the operators
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

        String[] separated = str.split("(?<=[+\\-*/%])|(?=[+\\-*/%])");
        System.out.println(separated);
        List<String> list = new ArrayList<>(Arrays.asList(separated));
        System.out.println(list);
        System.out.println("printing out integers into doubles...");
        for (String x : list) {
            index++;
            if (!(x.equals(mult) | x.equals(div) | x.equals(add) | x.equals(sub) | x.equals(rem) | x.equals("Undefined"))) {
                double newX = Double.parseDouble(x);
                System.out.println(newX);
                list.set(index - 1, String.valueOf(newX));
            }
            if (x.equals("Undefined")){
                list.clear();
                list.add(error);
                break;
            }
        }

        index = 0;
        while (list.size() > 1) {
            System.out.println(list);
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
                double newA = Double.parseDouble(a);
                double doubleA = newA;
                double newB = Double.parseDouble(b);
                double doubleB = newB;
                double doubleResult = doubleA * doubleB;
                stringResult = Double.toString(doubleResult);
                list.set(aPlace, stringResult);
                list.remove(bPlace);
                list.remove(index);
                System.out.println("the result is " + stringResult);
                System.out.println(list);
                continue;


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
                double newA = Double.parseDouble(a);
                double doubleA = newA;
                double newB = Double.parseDouble(b);
                double doubleB = newB;
                double doubleResult = doubleA / doubleB;
                stringResult = Double.toString(doubleResult);
                list.set(aPlace, stringResult);
                list.remove(bPlace);
                list.remove(index);
                System.out.println("the result is " + stringResult);
                System.out.println(list);
                continue;


            }  else if (list.contains(rem)) {
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
                double newA = Double.parseDouble(a);
                double doubleA = newA;
                double newB = Double.parseDouble(b);
                double doubleB = newB;
                double doubleResult = doubleA % doubleB;
                stringResult = Double.toString(doubleResult);
                list.set(aPlace, stringResult);
                list.remove(bPlace);
                list.remove(index);
                System.out.println("the result is " + stringResult);
                System.out.println(list);
                continue;


            }

            index = 0;
            for (int i = 0; i < list.size(); i++) {
                String testItem = list.get(i);
                index++;
                switch (testItem) {
                    case "+":
                        System.out.println("found + in  list");
                        System.out.println("adding...");
                        int aPlace = index - 2;
                        int bPlace = index + 0;
                        String a = list.get(aPlace);
                        String b = list.get(bPlace);
                        double newA = Double.parseDouble(a);
                        double doubleA = newA;
                        double newB = Double.parseDouble(b);
                        double doubleB = newB;
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
                        bPlace = index + 0;
                        a = list.get(aPlace);
                        b = list.get(bPlace);
                        newA = Double.parseDouble(a);
                        doubleA = newA;
                        newB = Double.parseDouble(b);
                        doubleB = newB;
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
        if (!Objects.equals(stringResult, error)) {
            double doubleResult = Double.parseDouble(stringResult);
            if (doubleResult % 1 == 0) {
                int newResult = (int) doubleResult;
                stringResult = Integer.toString(newResult);
            }
            if (Objects.equals(stringResult, "NaN")) {
                stringResult = "Undefined";
            }
        }
        return new String[]{stringResult};
    }
}
