import javax.swing.*;
import javax.swing.text.Document;
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
            String message = "";
            switch (actionSource) {
                case "DEL":
                    message = "DEL";
                    myView.displayPane.setText(message);
                    break;

                case "AC":
                    message = "AC";
                    myView.displayPane.setText(message);
                    break;

                case "+/-":
                    message = "+/-";
                    myView.displayPane.setText(message);
                    break;

                case "%":
                    message = "%";
                    myView.displayPane.setText(message);
                    break;

                case "X":
                    message = "X";
                    myView.displayPane.setText(message);
                    break;

                case "-":
                    message = "-";
                    myView.displayPane.setText(message);
                    break;

                case "+":
                    message = "+";
                    myView.displayPane.setText(message);
                    break;

                case "/":
                    message = "/";
                    myView.displayPane.setText(message);
                    break;

                case "1":
                    message = "1";
                    myView.displayPane.setText(message);
                    break;

                case "2":
                    message = "2";
                    myView.displayPane.setText(message);
                    break;

                case "3":
                    message = "3";
                    myView.displayPane.setText(message);
                    break;

                case "4":
                    message = "4";
                    myView.displayPane.setText(message);
                    break;

                case "5":
                    message = "5";
                    myView.displayPane.setText(message);
                    break;

                case "6":
                    message = "6";
                    myView.displayPane.setText(message);
                    break;

                case "7":
                    message = "7";
                    myView.displayPane.setText(message);
                    break;

                case "8":
                    message = "8";
                    myView.displayPane.setText(message);
                    break;

                case "9":
                    message = "9";
                    myView.displayPane.setText(message);
                    break;

                case "0":
                    message = "0";
                    myView.displayPane.setText(message);
                    break;

                case "=":
                    message = "=";
                    myView.displayPane.setText(message);
                    break;

                case  ".":
                    message = ".";
                    myView.displayPane.setText(message);
                    break;

            }
        }
    }
}

