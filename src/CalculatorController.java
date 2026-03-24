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
            myView.updateDisplay(actionSource);
        }
    }
}

