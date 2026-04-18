# Calculator

## Project Description
Calculator-Java is a calculator programmed using Java Swing. The calculator includes a simple calculator with addition, substraction, multiplication and division, a tip calculator, a unit converter and the calculator history.

## File Structure
The overall file structure involves using `CalculatorView.java` to display the JFrame, `CaculatorEngine.java` to control the logic, and `CalculatorController` to connect the view to the engine.

## CalculatorController.java
First, the constructor for `CalculatorController` initializes instances of the classes `CalculatorEngine`, `CalculatorView`, and `CustomListener`.
Second, the constructor for `CalculatorController` calls the function `setButtonListener` from `CalculatorView` and passes in the instance of `CustomListener`.

Also, `CalculatorController` contains the action listener assigned to all the buttons in the arithmetic calculator panel.

## CalculatorEngine.java

## CalculatorPanel.java
CalculatorPanel is basically a class, which extends JPanel, and creates a JPanel to be used in a card layout.

The function `buildPanel()` initializes the panel, creates a new `GridBagConstraints` and added all the elements to the JPanel.

The display consists of the following:

- A display pane to display the results of calculations
- 
- A button panel with the following buttons:

| (Delete) | (All Clear) | (Change Sign) | (Modulus) |
|----------|-------------|---------------|-----------|
| DEL      | AC          | +/-           | %         |
| 1        | 2           | 3             | *         |
| 4        | 5           | 6             | /         |
| 7        | 8           | 9             | +         |
| .        | 0           | =             | -         |

The function `setButton Listener` assigns the variable `btnLstnr` the action listener passed in as a parameter.

The function `getDisplayText` returns the text in `displayPane`.

The function `setDisplayText` sets the text in `displayPane` to the string passed in as a parameter.