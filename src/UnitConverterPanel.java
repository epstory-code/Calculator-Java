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
        String[] units = {"Centimeters", "Meters", "Kilometers", "Inches", "Feet", "Miles"};
        GridBagConstraints gbc = new GridBagConstraints();

        // Default constraints for all components
        gbc.insets = new Insets(10, 10, 10, 10); // Spacing
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // --- ROW 0 ---
        gbc.gridx = 0; gbc.gridy = 0;
        JTextField oneField = new JTextField(10);
        gbc.gridwidth = 1;
        panel.add(oneField, gbc);

        gbc.gridx = 1;
        SpinnerListModel oneModel = new SpinnerListModel(units);
        JSpinner oneSpinner = new JSpinner(oneModel);
        ((JSpinner.DefaultEditor) oneSpinner.getEditor()).getTextField().setEditable(false);
        panel.add(oneSpinner, gbc);

        // --- ROW 1: Convert Button (Spans 2 Columns) ---
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 2; // Span across the whole row
        JButton convButton = new JButton("Convert");
        panel.add(convButton, gbc);

        // --- ROW 2: ---
        gbc.gridx = 0; gbc.gridy = 2;
        JTextField twoField = new JTextField(10);
        twoField.setEditable(false);
        gbc.gridwidth = 1;
        panel.add(twoField, gbc);

        gbc.gridx = 1;
        SpinnerListModel twoModel = new SpinnerListModel(units);
        JSpinner twoSpinner = new JSpinner(twoModel);
        ((JSpinner.DefaultEditor) twoSpinner.getEditor()).getTextField().setEditable(false);
        panel.add(twoSpinner, gbc);

        add(panel);
    }

}
