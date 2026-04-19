import javax.swing.*;
import java.awt.*;

public class HistoryPanel extends JPanel {

    private JPanel panel;
    private JTextPane displayPane;
    private JScrollPane displayScrollPane;
    private JButton clearButton;

    //Function to update the displayPane with the string passed in as a parameter
    public void updateHistory (String text) {
        String newText = displayPane.getText() + text;
        displayPane.setText(newText);
    }

    public HistoryPanel() {
        buildPanel();
    }

    private void buildPanel() {
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //Sets grid bag constraints for the displayPane
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.weighty = 4;
        gbc.fill = GridBagConstraints.BOTH;

        //Initializes the displayPane and sets specifications
        displayPane = new JTextPane();
        displayPane.setFont(new Font("Arial", Font.PLAIN, 25));
        displayPane.setEditable(false);
        displayPane.setOpaque(false);
        displayPane.setBackground(Color.BLACK);
        displayPane.setText("");

        //Initializes the displayScrollPane
        displayScrollPane = new JScrollPane(displayPane);
        //Adds the scroll pane and display pane to the panel
        panel.add(displayScrollPane, gbc);

        gbc.gridy = 1;
        gbc.weighty = 1;

        //Initializes the clearButton
        clearButton = new JButton("Clear");
        //Adds an action listener to the clear button
        clearButton.addActionListener(e -> {
            displayPane.setText("");
        });
        //Adds the clearButton to the panel
        panel.add(clearButton, gbc);

        //Sets the layout of HistoryPanel to a border layout and adds panel to HistoryPanel
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
    }



}
