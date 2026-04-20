import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class UnitConverterPanel extends JPanel {

    private JPanel panel;
    private JTextField oneField, twoField;
    private JSpinner oneSpinner, twoSpinner;
    private SpinnerListModel oneModel, twoModel;
    private JButton convButton;

    // Constructor for UnitConverterView
    public UnitConverterPanel() {
        buildPanel();
    }

    public void buildPanel() {

        // Use a JPanel with GridBagLayout
        panel = new JPanel(new GridBagLayout());
        String[] units = {"Centimeters", "Meters", "Kilometers", "Inches", "Feet", "Miles"};
        GridBagConstraints gbc = new GridBagConstraints();

        // Default constraints for all components
        gbc.insets = new Insets(10, 10, 10, 10); // Spacing
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // --- ROW 0 ---
        gbc.gridx = 0; gbc.gridy = 0;
        oneField = new JTextField(10);
        gbc.gridwidth = 1;
        panel.add(oneField, gbc);

        gbc.gridx = 1;
        oneModel = new SpinnerListModel(units);
        oneSpinner = new JSpinner(oneModel);
        ((JSpinner.DefaultEditor) oneSpinner.getEditor()).getTextField().setEditable(false);
        panel.add(oneSpinner, gbc);

        // --- ROW 1: Convert Button (Spans 2 Columns) ---
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 2; // Span across the whole row
        convButton = new JButton("Convert");
        panel.add(convButton, gbc);

        // --- ROW 2: ---
        gbc.gridx = 0; gbc.gridy = 2;
        twoField = new JTextField(10);
        twoField.setHorizontalAlignment(SwingConstants.LEFT);
        twoField.setEditable(false);
        gbc.gridwidth = 1;
        panel.add(twoField, gbc);

        gbc.gridx = 1;
        twoModel = new SpinnerListModel(units);
        twoSpinner = new JSpinner(twoModel);
        ((JSpinner.DefaultEditor) twoSpinner.getEditor()).getTextField().setEditable(false);
        panel.add(twoSpinner, gbc);

        add(panel);

        // Logic for the Unit Converter
        convButton.addActionListener(e -> {
            try {
                String oneText = oneField.getText();
                double dOne = Double.parseDouble(oneText);
                double ans = 0;
                System.out.println("converted to doubles");
                String twoS = (String) twoSpinner.getValue();
                String oneS = (String) oneSpinner.getValue();

// Centimeters
                if (Objects.equals(oneS, "Centimeters")){
                    if (Objects.equals(twoS, "Centimeters")){
                        twoField.setText(String.valueOf(1 * dOne));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Meters")){
                        ans = 0.01 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Kilometers")){
                        ans = 0.00001 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Inches")){
                        ans = 0.393701 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Feet")){
                        ans = 0.03280841666667 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Miles")){
                        ans = 0.00000621 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                }

// Meters
                if (Objects.equals(oneS, "Meters")){
                    if (Objects.equals(twoS, "Centimeters")){
                        ans = 100 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Meters")){
                        twoField.setText(String.valueOf(1 * dOne));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Kilometers")){
                        ans = 0.001 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Inches")){
                        ans = 39.3701 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Feet")){
                        ans = 3.28084 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Miles")){
                        ans = 0.0000062137152777784086452 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                }

// Kilometers
                if (Objects.equals(oneS, "Kilometers")){
                    if (Objects.equals(twoS, "Centimeters")){
                        ans = 100000 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Meters")){
                        ans = 1000 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Kilometers")){
                        twoField.setText(String.valueOf(1 * dOne));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Inches")){
                        ans = 39370.1 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Feet")){
                        ans = 3280.84 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Miles")){
                        ans = 0.621371 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                }
// Inches
                if (Objects.equals(oneS, "Inches")){
                    if (Objects.equals(twoS, "Centimeters")){
                        ans = 2.54 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Meters")){
                        ans = 0.0254 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Kilometers")){
                        ans = 0.00000254 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Inches")){
                        twoField.setText(String.valueOf(1 * dOne));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Feet")){
                        ans = 0.0833333 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Miles")){
                        ans = 0.62137 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                }
// Feet
                if (Objects.equals(oneS, "Feet")){
                    if (Objects.equals(twoS, "Centimeters")){
                        ans = 30.48 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Meters")){
                        ans = 0.3048 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Kilometers")){
                        ans = 0.0003048 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Inches")){
                        ans = 12 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Feet")){
                        twoField.setText(String.valueOf(1 * dOne));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Miles")){
                        ans = 5280 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                }
// Miles
                if (Objects.equals(oneS, "Miles")){
                    if (Objects.equals(twoS, "Centimeters")){
                        ans = 160934 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Meters")){
                        ans = 1609.34 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Kilometers")){
                        ans = 1.60934 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Inches")){
                        ans = 63360 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Feet")){
                        ans = 5280 * dOne;
                        twoField.setText(String.format("%.8f", ans));
                        twoField.setCaretPosition(0);
                    }
                    if (Objects.equals(twoS, "Miles")){
                        twoField.setText(String.valueOf(1 * dOne));
                        twoField.setCaretPosition(0);
                    }
                }
            // Catches any exception like letters and gives an error message
            } catch (Exception ex) {
                oneField.setText("");
                twoField.setText("");
                JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
            }
        });
    }

}
