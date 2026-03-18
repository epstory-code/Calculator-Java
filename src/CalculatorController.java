import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorView myView;
    private CalculatorEngine myEngine;

    public CalculatorController() {
        myEngine = new CalculatorEngine();
        SwingUtilities.invokeLater(() -> {
            myView = new CalculatorView();
        });
    }

    static class CalculatorButtonListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
        }
    }
}
