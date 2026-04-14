import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Arrays;
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
                case "1","2","3","4","5","6","7","8","9","0","-","+","/","*", ".":
                    if (myView.getDisplayText().equals("0")) { myView.allClearDisplay(); }
                    myView.updateDisplay(actionSource);
                    break;

                case "AC":
                    // Calls function allClearDisplay from CalculatorView.java to set the display to an empty string
                    myView.allClearDisplay();
                    myView.setDisplayText("0");
                    break;

                case "DEL":
                    // Calls function delChar from CalculatorView.java and removes the last character of the string being displayed and updates the display
                    if (!Objects.equals(myView.getDisplayText(), "0")) {
                        myView.delChar();
                        if (Objects.equals(myView.getDisplayText(), "")) {
                            myView.setDisplayText("0");
                        }
                    }
                    break;

                case "+/-":
                    // Gets the array of numbers from the display
                    String[] arrayOfNum = myEngine.evaluateExpression( myView.getDisplayText() );
                    //Gets the last number from the array of numbers as a string
                    int lastNumIndex = arrayOfNum.length-1;
                    String lastNum = arrayOfNum[lastNumIndex];
                    // Convert the number as a string to a double
                    double lastDouble = Double.parseDouble(lastNum);
                    // Multiplies the double by -1
                    lastDouble = lastDouble * (-1);
                    // Converts the double back to a string and removes any trailing zeros
                    DecimalFormat df = new DecimalFormat("#.##########");
                    lastNum = String.valueOf(df.format(lastDouble));
                    //Replaces the original number with the number with a changed sign
                    String textWithSignChanged = myEngine.replaceLast(myView.getDisplayText(), arrayOfNum[arrayOfNum.length-1], lastNum);
                    //Sets the display to the text with the sign changed
                    myView.setDisplayText(textWithSignChanged);
                    break;

                case "=":
                    // Evaluates expression
                    myEngine.evaluateExpression(myView.getDisplayText());
                    if (!Objects.equals(myView.getDisplayText(), "0")) {
                        String[] result = myEngine.evaluateExpression(myView.getDisplayText());
                        String resultString = result[0];
                        myView.setDisplayText(resultString);
                    }
                    break;
            }
        }
    }
}