import javax.swing.*;
import java.awt.*;

public class UnitConverterPanel extends JPanel {

    // Constructor for UnitConverterView
    public UnitConverterPanel() {
        buildPanel();
    }

    public void buildPanel() {

        // Use a JPanel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        String[] units = {"Inches", "Feet", "Miles", "Kilometers", "Centimeters", "Meters"};
        GridBagConstraints gbc = new GridBagConstraints();

        // Default constraints for all components
        gbc.insets = new Insets(10, 10, 10, 10); // Spacing
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // --- ROW 0: Bill Amount ---
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel(""), gbc);


        // --- ROW 1 ---
        gbc.gridx = 0; gbc.gridy = 1;
        JTextField oneField = new JTextField(10);
        panel.add(oneField, gbc);

        gbc.gridx = 1;
        // JSpinner or Slider is often used for tip %
        SpinnerListModel oneModel = new SpinnerListModel(units);
        JSpinner oneSpinner = new JSpinner(oneModel);
        ((JSpinner.DefaultEditor) oneSpinner.getEditor()).getTextField().setEditable(false);
        panel.add(oneSpinner, gbc);

        // --- ROW 2: Number of People ---
        gbc.gridx = 0; gbc.gridy = 1;
        JTextField twoField = new JTextField(10);
        panel.add(twoField, gbc);

        gbc.gridx = 1;
        // JSpinner or Slider is often used for tip %
        SpinnerListModel twoModel = new SpinnerListModel(units);
        JSpinner twoSpinner = new JSpinner(twoModel);
        ((JSpinner.DefaultEditor) twoSpinner.getEditor()).getTextField().setEditable(false);
        panel.add(twoSpinner, gbc);

        // --- ROW 3: Calculate Button (Spans 2 Columns) ---
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2; // Span across the whole row
        JButton calcButton = new JButton("Calculate Tip");
        panel.add(calcButton, gbc);

        // --- ROW 4: Tip Result (Non-editable) ---
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Tip Amount:"), gbc);

        gbc.gridx = 1;
        JTextField tipResult = new JTextField(10);
        tipResult.setEditable(false);
        panel.add(tipResult, gbc);

        // --- ROW 5: Total Result (Non-editable) ---
        gbc.gridx = 0; gbc.gridy = 5;
        panel.add(new JLabel("Total Amount:"), gbc);

        gbc.gridx = 1;
        JTextField totalResult = new JTextField(10);
        totalResult.setEditable(false);
        panel.add(totalResult, gbc);

        add(panel);// Size the window to fit components
    }

}
