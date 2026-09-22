import javax.swing.JOptionPane;

class Calculator {
    public static void main(String[] args) {
        String strNum1, strNum2;
        double num1, num2;

        try {
            strNum1 = JOptionPane.showInputDialog(null,
                    "Please input the first number: ", "Input the first number",
                    JOptionPane.INFORMATION_MESSAGE);
            if (strNum1 == null) System.exit(0);
            num1 = Double.parseDouble(strNum1);

            strNum2 = JOptionPane.showInputDialog(null,
                    "Please input the second number: ", "Input the second number",
                    JOptionPane.INFORMATION_MESSAGE);
            if (strNum2 == null) System.exit(0);
            num2 = Double.parseDouble(strNum2);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
            return;
        }

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;

        String quotient;
        if (num2 == 0) {
            quotient = "Cannot divide by zero!";
        } else {
            quotient = String.valueOf(num1 / num2);
        }

        String result = "Sum: " + num1 + " + " + num2 + " = " + sum
                + "\nDifference: " + num1 + " - " + num2 + " = " + difference
                + "\nProduct: " + num1 + " * " + num2 + " = " + product
                + "\nQuotient: " + num1 + " / " + num2 + " = " + quotient;

        JOptionPane.showMessageDialog(null, result, "Calculation results",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
