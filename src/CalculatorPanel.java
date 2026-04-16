import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorPanel extends JPanel {

    private ActionListener btnLstnr;
    private JPanel panel, btnPanel; // main panel and button panel
    private JTextPane displayPane;
    private JScrollPane scrollPane;
    private String[] btnTextArray = {"DEL","AC","+/-","%","1","2","3","*",
            "4","5","6","/","7","8","9","+",".","0","=", "-"};

    // Constructor for SimpleCalculatorPanel
    public CalculatorPanel() {
        //Calls function to add components to the calculator panel
        buildPanel();
    }

    public void setButtonListener(ActionListener lstnr){
        btnLstnr = lstnr;

        // Quick Fix for action listener being null before buttons being added to the Panel
        btnPanel.removeAll();
        for (String text : btnTextArray) {
            JButton button = new JButton(text);
            button.addActionListener(btnLstnr);
            btnPanel.add(button);
        }
    }

    public void buildPanel() {
        // Creates main panel to contain display & buttons
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        /* === ROW 0: TEXT FIELD FOR CALCULATOR === */
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridheight = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        // Creates a text pane to act as a display for the calculator
        displayPane = new JTextPane();
        displayPane.setFont(new Font("Arial", Font.PLAIN, 25));
        displayPane.setEditable(false);
        displayPane.setOpaque(false);
        displayPane.setBackground(Color.BLACK);
        displayPane.setText("0");

        // Creates a scroll pane inside the text pane to act as a display for the calculator
        scrollPane = new JScrollPane(displayPane);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // Adds the scroll pane (and text pane) to panel
        panel.add(scrollPane, gbc);

        // Creates an empty label for spacing purposes
        JLabel lblNewLabel = new JLabel();
        panel.add(lblNewLabel, gbc);

        /* === ROW 2: Button Pad === */
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridheight = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.05;

        // Creates button grid and adds buttons
        btnPanel = new JPanel(new GridLayout(5,5,0,0));
        for (String text : btnTextArray) {
            JButton button = new JButton(text);
            button.addActionListener(btnLstnr);
            btnPanel.add(button);
        }
        // Adds button panel to the main panel
        panel.add(btnPanel, gbc);

        // Adds the main panel to calculator panel
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
    }

    public String getDisplayText() {
        return displayPane.getText();
    }

    public void setDisplayText(String text) {
        displayPane.setText(text);
    }

    // Does not set the display. It adds to the display.
    public void updateDisplay(String text) {
        // Assigns the string previousText the text in displayPane
        String previousText = displayPane.getText();
        // Assigns displayText previousText and the text passed in as a parameter
        String displayText = previousText + text;
        // Updates the display
        displayPane.setText(displayText);
    }

    // Sets text to "" to make it blank
    public void allClearDisplay() {
        displayPane.setText("");
    }


    // Deletes the last character being displayed
    public void delChar() {
        String delString = getDisplayText();
        if (!delString.isEmpty()) {
            delString = delString.substring(0, delString.length() - 1);
            displayPane.setText(delString);
        }
    }

    /* Main method to run and view boilerplate code */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorPanel myCalculatorPanel = new CalculatorPanel();
        });
    }
}
