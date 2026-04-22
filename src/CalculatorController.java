import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CalculatorController {

    private CalculatorEngine myEngine;
    private CalculatorView myView;
    private CustomListener myListener;

    // Constructor for CalculatorController
    public CalculatorController() {

        // Initializes instances of the classes CalculatorEngine, CalculatorView, and CustomListener
        myEngine = new CalculatorEngine();
        myView = new CalculatorView();
        myListener = new CustomListener();

        // Registers the listener with a component
        myView.setButtonListener(myListener);
    }

    private class CustomListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //Stores the action command from the parameter e in the string actionSource
            String actionSource = e.getActionCommand();

            switch (actionSource) {

                //Calls function updateDisplay from CalculatorView.java to add the number or symbol to the display
                case "1","2","3","4","5","6","7","8","9","0","-","+","/","*","%",".":
                    if (myView.getDisplayText().equals("0")) {
                        if (!(Objects.equals(actionSource, "."))) {
                            myView.allClearDisplay();
                        }
                        if (Objects.equals(actionSource, ".")) {
                            myView.allClearDisplay();
                            myView.updateDisplay("0");
                        }
                    }
                    myView.updateDisplay(actionSource);
                    break;

                case "AC":

                    // Calls function allClearDisplay from CalculatorView.java to set the display to an empty string
                    myView.allClearDisplay();
                    myView.setDisplayText("0");
                    break;

                case "DEL":

                    // Calls function delChar from CalculatorView.java and removes the last character of the string being displayed and updates the display
                    if (List.of("Undefined", "Infinity", "Error").contains(myView.getDisplayText())) {
                        myView.allClearDisplay();
                        myView.setDisplayText("0");
                    }
                    if (!Objects.equals(myView.getDisplayText(), "0")) {
                        myView.delChar();
                        if (Objects.equals(myView.getDisplayText(), "")) {
                            myView.setDisplayText("0");
                        }
                    }

                    break;

                case "+/-":

                    // Sets the last number in the expression to the opposite of itself e.g. 1 to -1
                    String[] separated = myEngine.splitExpression(myView.getDisplayText());
                    List<String> list = new ArrayList<>(Arrays.asList(separated));
                    System.out.println(list);

                    // Try/Catch block surrounds it in case of error
                    try {

                        // If there's a - there already
                        if (Objects.equals(list.size(), 2) && Objects.equals(list.get(0), "-")) {
                            list.remove(list.getFirst());
                            myView.setDisplayText(list.getFirst());

                        // If there's only one number in the expression
                        } else if (Objects.equals(list.size(), 1)) {
                            if (list.get(0) == "0") {
                                myView.allClearDisplay();
                                myView.setDisplayText("Error");
                            }
                            double idk = Double.parseDouble(list.get(0));
                            idk = idk * -1;
                            list.set(0, String.valueOf(idk));
                            if (idk % 1 == 0) {
                                long newIdk = (long) idk;
                                list.set(0, String.valueOf(newIdk));
                            }
                            myView.allClearDisplay();
                            for (String q : list) {
                                myView.updateDisplay(q);
                            }

                        // If there's a - already and its after a operator
                        } else if (!(Objects.equals(list.size(), 1)) && Objects.equals(list.get(list.size() - 2), "-") && List.of("*", "/", "+", "-", "%").contains(list.get(list.size() - 3))) {
                            list.remove(list.size() - 2);
                            System.out.println(list);
                            myView.allClearDisplay();
                            for (String q : list) {
                                myView.updateDisplay(q);
                            }

                        } else {
                            double idk = Double.parseDouble(list.getLast());
                            idk = idk * -1;
                            list.set(list.size() - 1, String.valueOf(idk));
                            if (idk % 1 == 0) {
                                long newIdk = (long) idk;
                                list.set(list.size() - 1, String.valueOf(newIdk));
                            }
                            myView.allClearDisplay();
                            for (String q : list) {
                                myView.updateDisplay(q);
                            }
                        }
                    } catch (Exception idk) {
                        myView.allClearDisplay();
                        myView.setDisplayText("Error");
                    }
                    break;

                case "=":
                    // Evaluates expression
                    String displayText = myView.getDisplayText();
                    myEngine.evaluateExpression(displayText);
                    String resultString = null;
                    if (!Objects.equals(displayText, "0")) {
                        String[] result = myEngine.evaluateExpression(displayText);
                        resultString = result[0];
                        myView.setDisplayText(resultString);
                    }
                    myView.updateHistory(displayText + " = " + resultString + "\n");
                    break;
            }
        }
    }
}