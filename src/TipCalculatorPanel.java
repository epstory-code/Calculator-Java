import javax.swing.*;
import java.awt.*;

public class TipCalculatorPanel extends JPanel {

    private JPanel panel;
    private JTextPane displayPane;
    private JScrollPane scrollPane;

    // Constructor for TipCalculatorView
    public TipCalculatorPanel() {
        buildPanel();
    }

    public void buildPanel() {
        // Creates main panel to contain display & buttons & dropdown menus
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        /* === ROW 0: TEXT FIELD FOR TIP CALCULATOR === */
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridheight = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        // Creates a text pane to act as a display for the tip calculator
        displayPane = new JTextPane();
        displayPane.setFont(new Font("Arial", Font.PLAIN, 25));
        displayPane.setEditable(false);
        displayPane.setOpaque(false);
        displayPane.setBackground(Color.BLACK);
        displayPane.setText("Hello, World!");

        // Creates a scroll pane inside the text pane to act as a display for the calculator
        scrollPane = new JScrollPane(displayPane);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // Adds the scroll pane (and text pane) to panel
        panel.add(scrollPane, gbc);

        // Adds the main panel to tip calculator panel
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
    }

}