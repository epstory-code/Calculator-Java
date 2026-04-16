import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class CalculatorView extends JFrame {

    //Constants to later be stored in the array comboBoxItems
    private static final String CALCULATOR_PANEl = "Calculator";
    private static final String TIP_CALCULATOR_PANEL = "Tip Calculator";
    private static final String CONVERTER = "Unit Converter";
    private static final String HISTORY = "History";


    public static CalculatorPanel calculatorPanel = new CalculatorPanel(); // Creates an instance of the class CalculatorPanel.java
    public static TipCalculatorPanel tipCalculatorPanel = new TipCalculatorPanel();
    public static UnitConverterPanel unitConverterPanel = new UnitConverterPanel();
    private ActionListener btnLstnr; // An action listener to later be used for the card layout
    private JPanel comboBoxPane;
    private JComboBox<String> cb;
    private String[] comboBoxItems = {CALCULATOR_PANEl, TIP_CALCULATOR_PANEL, CONVERTER, HISTORY};
    private JPanel cards;

    // Constructor for CalculatorView
    public CalculatorView() {

        // Calls function to add the card layout to the pane
        SwingUtilities.invokeLater(this::addCardLayoutToPanel);

        // Initialize and display the calculator GUI JFrame
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 550);
        setVisible(true);
    }

    // Currently calls corresponding function in CalculatorPanel.java
    public void setButtonListener(ActionListener lstnr) {
        calculatorPanel.setButtonListener(lstnr);
    }

    public void addCardLayoutToPanel() {

        // Initializes a panel for the combo box
        comboBoxPane = new JPanel();
        // Initializes the combo box with the options in the list ComboBoxItems
        cb =  new JComboBox<>(comboBoxItems);
        // Adds specifications to the combo box
        cb.setEditable(false);
        cb.addActionListener(btnLstnr);
        // Adds the combo box to the combo box pane
        comboBoxPane.add(cb);
        //Creates a card layout to use later
        CardLayout cardLayout = new CardLayout();
        // Initializes a JPanel with a card layout
        cards = new JPanel (cardLayout);

        //Adds the panels to the JPanel cards
        cards.add(calculatorPanel, CALCULATOR_PANEl);
        cards.add(tipCalculatorPanel, TIP_CALCULATOR_PANEL);
        cards.add(unitConverterPanel, CONVERTER);

        //Adds an item listener to the combo box
        cb.addItemListener(e -> {
            if  (e.getStateChange() == ItemEvent.SELECTED) {
                cardLayout.show(cards, (String) e.getItem());
            }
        });

        //Adds the comboBoxPane and the JPanel cards to the JFrame
        add(comboBoxPane, BorderLayout.PAGE_START);
        add(cards, BorderLayout.CENTER);
    }

    public String getDisplayText() {
        return calculatorPanel.getDisplayText();
    }

    public void setDisplayText(String text) {
        calculatorPanel.setDisplayText(text);
    }

    // Does not set the display. It adds to the display.
    public void updateDisplay(String text) {
        // Assigns the string previousText the text in displayPane
        String previousText = getDisplayText();
        // Assigns displayText previousText and the text passed in as a parameter
        String displayText = previousText + text;

        // Updates the display
        setDisplayText(displayText);
    }

    // Sets text to "" to make it blank
    public void allClearDisplay() {
        setDisplayText("");
    }

    // Deletes the last character being displayed
    public void delChar() {
        String delString = getDisplayText();
        if (!delString.isEmpty()) {
            delString = delString.substring(0, delString.length() - 1);
            setDisplayText(delString);
        }
    }

    /* Main method to run and view boilerplate code */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           CalculatorView myCalculatorView = new CalculatorView();
        });
    }
}
