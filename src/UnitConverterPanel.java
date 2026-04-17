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

        convButton.addActionListener(e -> {
            String oneText = oneField.getText();
            double dOne = Double.parseDouble(oneText);
            System.out.println("converted to doubles");
            String twoS = (String) twoSpinner.getValue();
            String oneS = (String) oneSpinner.getValue();

// done
            if (Objects.equals(oneS, "Centimeters")){
                if (Objects.equals(twoS, "Centimeters")){
                    twoField.setText(oneText);
                }
                if (Objects.equals(twoS, "Meters")){
                    twoField.setText(String.valueOf(0.01 * dOne));
                }
                if (Objects.equals(twoS, "Kilometers")){
                    twoField.setText(String.valueOf(0.00001 * dOne));
                }
                if (Objects.equals(twoS, "Inches")){
                    twoField.setText(String.valueOf(0.393 * dOne));
                }
                if (Objects.equals(twoS, "Feet")){
                    twoField.setText(String.valueOf(0.032 * dOne));
                }
                if (Objects.equals(twoS, "Miles")){
                    twoField.setText(String.valueOf(0.000621 * dOne));
                }
            }

//
            if (Objects.equals(oneS, "Meters")){
                if (Objects.equals(twoS, "Centimeters")){
                    twoField.setText(String.valueOf(100 * dOne));
                }
                if (Objects.equals(twoS, "Meters")){
                    twoField.setText(oneText);
                }
                if (Objects.equals(twoS, "Kilometers")){
                    twoField.setText(String.valueOf(0.001 * dOne));
                }
                if (Objects.equals(twoS, "Inches")){
                    twoField.setText(String.valueOf(39.3701 * dOne));
                }
                if (Objects.equals(twoS, "Feet")){
                    twoField.setText(String.valueOf(3.28084 * dOne));
                }
                if (Objects.equals(twoS, "Miles")){
                    twoField.setText(String.valueOf(0.0000062 * dOne));
                }
            }

//
            if (Objects.equals(oneSpinner, "Kilometers")){

            }
//
            if (Objects.equals(oneSpinner, "Inches")){

            }
//
            if (Objects.equals(oneSpinner, "Feet")){

            }
//
            if (Objects.equals(oneSpinner, "Miles")){

            }
        });
    }

}
