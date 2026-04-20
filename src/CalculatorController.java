import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
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
        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */

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
                    if (Objects.equals(myView.getDisplayText(), "Undefined") || Objects.equals(myView.getDisplayText(), "Infinity") || Objects.equals(myView.getDisplayText(), "That button doesn't work") || Objects.equals(myView.getDisplayText(), "Error")) {
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
                    myView.setDisplayText("That button doesn't work");
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