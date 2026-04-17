import javax.swing.*;
import java.awt.*;

public class HistoryPanel extends JPanel {

    private JPanel panel;
    private JTextPane displayPane;
    private JScrollPane displayScrollPane;
    private JButton clearButton;

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


        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.weighty = 4;
        gbc.fill = GridBagConstraints.BOTH;

        displayPane = new JTextPane();
        displayPane.setFont(new Font("Arial", Font.PLAIN, 25));
        displayPane.setEditable(false);
        displayPane.setOpaque(false);
        displayPane.setBackground(Color.BLACK);
        displayPane.setText("");


        displayScrollPane = new JScrollPane(displayPane);
        panel.add(displayScrollPane, gbc);

        gbc.gridy = 1;
        gbc.weighty = 1;
        clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> {
            displayPane.setText("");
        });
        panel.add(clearButton, gbc);


        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
    }



}
