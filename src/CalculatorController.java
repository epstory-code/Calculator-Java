import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                case "AC":
                    // Calls clearing function
                    myView.allClearDisplay();
                    break;

                case "DEL":
                    // Here we can take the last character in the string and remove it, then update the display with the new string
                    myView.delChar();
                    break;

                case "+/-":
                    // Here we can take the last object in the list, parse it into an integer, multiply it by -1, then turn it back into a string
                    break;

                case "=":
                    // Evaluates expression
                    myEngine.evaluateExpression(myView.getDisplayText());
                    break;

                case "1","2","3","4","5","6","7","8","9","0","-","+","/","*":
                    myView.updateDisplay(actionSource);
            }
        }
    }
}

