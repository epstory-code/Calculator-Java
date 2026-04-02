import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Arrays;

public class CalculatorController {

    // Declarations
    private CalculatorEngine myEngine;
    private CalculatorView myView;
    private CustomListener myListener;

    // constructor for CalculatorController
    public CalculatorController() {

        // Creates instances of the classes Calculator Engine, Calculator View, and Custom Listener
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
            String actionSource = e.getActionCommand();
            switch (actionSource) {
                case "1","2","3","4","5","6","7","8","9","0","-","+","/","*", ".":
                    if (myView.getDisplayText().equals("0")) {
                        myView.allClearDisplay();
                    }
                    myView.updateDisplay(actionSource);
                    break;

                case "AC":
                    // Calls function allClearDisplay from CalculatorView.java
                    myView.allClearDisplay();
                    myView.setDisplayText("0");
                    break;

                case "DEL":
                    // Removes the last character of the string being displayed and updates the display
                    myView.delChar();
                    break;

                case "+/-":
                    // Gets the array of numbers from the display
                    String[] arrayOfNum = myEngine.evaluateExpression(myView.getDisplayText());
                    //Gets the last number from the array of numbers as a string
                    String lastNum = arrayOfNum[arrayOfNum.length-1];
                    // Convert the number as a string to a double
                    double lastDouble = Double.parseDouble(lastNum);
                    // Multiplies the double by -1
                    lastDouble = lastDouble * (-1);
                    // Converts the double back to a string and removes any trailing zeros
                    DecimalFormat df = new DecimalFormat("#.##########");
                    lastNum = String.valueOf(df.format(lastDouble));
                    //Replaces the original number with the number with a changed sign
                    String textWithSignChanged = myEngine.replaceLast(myView.getDisplayText(), arrayOfNum[arrayOfNum.length-1], lastNum);
                    //Clears and updates the display with the sign changed
                    myView.setDisplayText(textWithSignChanged);


                    break;

                case "=":
                    // Evaluates expression
                    if (!(myView.getDisplayText() == "0")) {
                        String[] result = myEngine.evaluateExpression(myView.getDisplayText());
                        String stringResult = result[0];
                        myView.setDisplayText(stringResult);
                        break;
                    }
            }
        }
    }
}

