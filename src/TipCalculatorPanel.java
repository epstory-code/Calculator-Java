import javax.swing.*;
import java.awt.*;

public class TipCalculatorPanel extends JPanel {

    private JPanel panel, pricePanel, tipPanel, numberPanel;
    private JLabel priceLabel, tipLabel, numberLabel, totalLabel, totalValueLabel, personalTotalLabel, personalTotalValueLabel, personalTipLabel, personalTipValueLabel;
    private JTextField priceField, tipField, numberField;
    private JButton calculateButton, clearButton;

    // Constructor for TipCalculatorView
    public TipCalculatorPanel() {
        buildPanel();
    }

    private JLabel createLabel(JLabel labelName, String labelText) {
        labelName = new JLabel(labelText);
        return labelName;
    }

    private JTextField createField(JTextField fieldName, int size) {
        fieldName = new JTextField(size);
        return fieldName;
    }

    private void addLabel(JPanel panel, JLabel labelName, int column, int row, GridBagConstraints gbc) {
        gbc.gridx = column;
        gbc.gridy = row;
        panel.add(labelName, gbc);
    }

    private void addField (JPanel panel, JTextField fieldName, int column, int row, GridBagConstraints gbc) {
        gbc.gridx = column;
        gbc.gridy = row;
        panel.add(fieldName, gbc);
    }

    private static void setFieldGBC (GridBagConstraints gbc) {
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
    }

    private static void setLeftLabelGBC(GridBagConstraints gbc) {
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
    }
    private static void setRightLabelGBC(GridBagConstraints gbc) {
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
    }

    private void buildPanel() {
        // Sets the layout and grid bag constraints
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);

        priceLabel = createLabel(priceLabel, "Price");
        priceField = createField(priceField, 10);
        setLeftLabelGBC(gbc);
        addLabel (panel, priceLabel, 0, 0, gbc);
        setFieldGBC(gbc);
        gbc.weightx = 1.0;
        addField(panel, priceField, 1, 0, gbc);

        tipLabel = createLabel(tipLabel, "Tip %");
        tipField = createField(tipField, 10);
        setLeftLabelGBC(gbc);
        addLabel (panel, tipLabel, 0, 1, gbc);
        setFieldGBC(gbc);
        gbc.weightx = 1.0;
        addField(panel, tipField, 1, 1, gbc);

        numberLabel = createLabel(numberLabel, "Number of People");
        numberField = createField(numberField, 10);
        setLeftLabelGBC(gbc);
        addLabel (panel, numberLabel, 0, 2, gbc);
        setFieldGBC(gbc);
        gbc.weightx = 1.0;
        addField(panel, numberField, 1, 2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        calculateButton = new JButton("Calculate");
        panel.add(calculateButton, gbc);

        gbc.gridwidth = 1;
        setLeftLabelGBC(gbc);
        totalLabel = createLabel(totalLabel, "Total");
        addLabel(panel, totalLabel, 0, 4, gbc);
        setRightLabelGBC(gbc);
        totalValueLabel = createLabel(totalValueLabel, "$0.00");
        addLabel(panel, totalValueLabel, 1, 4, gbc);

        setLeftLabelGBC(gbc);
        personalTotalLabel = createLabel(personalTotalLabel, "Total Per Person");
        addLabel(panel, personalTotalLabel, 0, 5, gbc);
        setRightLabelGBC(gbc);
        personalTotalValueLabel = createLabel(personalTotalValueLabel, "$0.00");
        addLabel(panel, personalTotalValueLabel, 1, 5, gbc);

        setLeftLabelGBC(gbc);
        personalTipLabel = createLabel(personalTipLabel, "Tip Per Person");
        addLabel(panel, personalTipLabel, 0, 6, gbc);
        setRightLabelGBC(gbc);
        personalTipValueLabel = createLabel(personalTipValueLabel, "$0.00");
        addLabel(panel, personalTipValueLabel, 1, 6, gbc);

        // Adds the main panel to tip calculator panel
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);

        setLeftLabelGBC(gbc);

        calculateButton.addActionListener(e -> {
            try{
                double priceValue = Double.parseDouble(priceField.getText());
                double tipPercent = Double.parseDouble(tipField.getText());
                int numOfPeople = Integer.parseInt(numberField.getText());

                if (numOfPeople <= 0) {
                    JOptionPane.showMessageDialog(this, "Number of people must be greater than 0");
                } else {
                    double totalTipAmount = priceValue * (tipPercent / 100);
                    double totalAmount = priceValue + totalTipAmount;
                    double totalPerPerson = totalAmount / numOfPeople;
                    double totalTipPerPerson = totalTipAmount / numOfPeople;

                    totalValueLabel.setText(String.format("$%.2f", totalAmount));
                    personalTotalValueLabel.setText(String.format("$%.2f", totalPerPerson));
                    personalTipValueLabel.setText(String.format("$%.2f", totalTipPerPerson));
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
            }
        });

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        clearButton = new JButton("Clear");
        panel.add(clearButton, gbc);

        clearButton.addActionListener( e -> {
            priceField.setText("");
            tipField.setText("");
            numberField.setText("");
            totalValueLabel.setText("$0.00");
            personalTotalValueLabel.setText("$0.00");
            personalTipValueLabel.setText("$0.00");
        });
    }
}