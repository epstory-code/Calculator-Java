# Calculator

## Project Description
Calculator-Java is a calculator programmed using Java Swing. The calculator includes a simple calculator with addition, substraction, multiplication and division, a tip calculator, a unit converter and the calculator history.

## File Structure
The overall file structure involves using `CalculatorView.java` to display the JFrame, `CaculatorEngine.java` to control the logic, and `CalculatorController` to connect the view to the engine.

## CalculatorController.java
First, the constructor for `CalculatorController` initializes instances of the classes `CalculatorEngine`, `CalculatorView`, and `CustomListener`.
Second, the constructor for `CalculatorController` calls the function `setButtonListener` from `CalculatorView` and passes in the instance of `CustomListener`.

Also, `CalculatorController` contains the action listener assigned to all the buttons in the arithmetic calculator panel.

### 