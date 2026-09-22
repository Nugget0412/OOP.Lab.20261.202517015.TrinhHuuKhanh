import javax.swing.JOptionPane;

class EquationSolver {
    static double readNumber(String message, String title) {
        while (true) {
            String str = JOptionPane.showInputDialog(null, message, title,
                    JOptionPane.INFORMATION_MESSAGE);
            if (str == null) System.exit(0);
            try {
                return Double.parseDouble(str.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid number! Please try again.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // ax + b = 0
    static String solveLinear() {
        double a = readNumber("Please input a: ", "Linear equation ax + b = 0");
        double b = readNumber("Please input b: ", "Linear equation ax + b = 0");

        String equation = "Equation: " + a + "x + " + b + " = 0\n";
        if (a == 0) {
            if (b == 0) {
                return equation + "The equation has infinitely many solutions.";
            }
            return equation + "The equation has no solution.";
        }
        return equation + "The equation has a unique solution: x = " + (-b / a);
    }

    // a11*x1 + a12*x2 = b1
    // a21*x1 + a22*x2 = b2
    static String solveLinearSystem() {
        String title = "Linear system of two variables";
        double a11 = readNumber("First equation: a11*x1 + a12*x2 = b1\nPlease input a11: ", title);
        double a12 = readNumber("First equation: a11*x1 + a12*x2 = b1\nPlease input a12: ", title);
        double b1 = readNumber("First equation: a11*x1 + a12*x2 = b1\nPlease input b1: ", title);
        double a21 = readNumber("Second equation: a21*x1 + a22*x2 = b2\nPlease input a21: ", title);
        double a22 = readNumber("Second equation: a21*x1 + a22*x2 = b2\nPlease input a22: ", title);
        double b2 = readNumber("Second equation: a21*x1 + a22*x2 = b2\nPlease input b2: ", title);

        String system = "System:\n"
                + a11 + "x1 + " + a12 + "x2 = " + b1 + "\n"
                + a21 + "x1 + " + a22 + "x2 = " + b2 + "\n";

        double d = a11 * a22 - a21 * a12;
        double d1 = b1 * a22 - b2 * a12;
        double d2 = a11 * b2 - a21 * b1;

        if (d != 0) {
            return system + "The system has a unique solution:\n"
                    + "x1 = " + (d1 / d) + "\nx2 = " + (d2 / d);
        }
        if (d1 != 0 || d2 != 0) {
            return system + "The system has no solution.";
        }
        boolean eq1Empty = a11 == 0 && a12 == 0;
        boolean eq2Empty = a21 == 0 && a22 == 0;
        if ((eq1Empty && b1 != 0) || (eq2Empty && b2 != 0)) {
            return system + "The system has no solution.";
        }
        return system + "The system has infinitely many solutions.";
    }

    // ax^2 + bx + c = 0
    static String solveQuadratic() {
        String title = "Quadratic equation ax^2 + bx + c = 0";
        double a = readNumber("Please input a: ", title);
        double b = readNumber("Please input b: ", title);
        double c = readNumber("Please input c: ", title);

        String equation = "Equation: " + a + "x^2 + " + b + "x + " + c + " = 0\n";
        if (a == 0) {
            equation += "a = 0, so the equation becomes linear: " + b + "x + " + c + " = 0\n";
            if (b == 0) {
                if (c == 0) {
                    return equation + "The equation has infinitely many solutions.";
                }
                return equation + "The equation has no solution.";
            }
            return equation + "The equation has a unique solution: x = " + (-c / b);
        }

        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double sqrtDelta = Math.sqrt(delta);
            return equation + "Delta = " + delta + " > 0\nThe equation has two distinct real roots:\n"
                    + "x1 = " + ((-b + sqrtDelta) / (2 * a))
                    + "\nx2 = " + ((-b - sqrtDelta) / (2 * a));
        } else if (delta == 0) {
            return equation + "Delta = 0\nThe equation has a double root: x1 = x2 = " + (-b / (2 * a));
        } else {
            return equation + "Delta = " + delta + " < 0\nThe equation has no real root.";
        }
    }

    public static void main(String[] args) {
        String[] options = {
                "Linear equation (ax + b = 0)",
                "Linear system (2 variables)",
                "Quadratic equation (ax^2 + bx + c = 0)"
        };

        while (true) {
            int choice = JOptionPane.showOptionDialog(null,
                    "Choose the type of equation to solve:", "Equation Solver",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);

            String result;
            switch (choice) {
                case 0:
                    result = solveLinear();
                    break;
                case 1:
                    result = solveLinearSystem();
                    break;
                case 2:
                    result = solveQuadratic();
                    break;
                default:
                    System.exit(0);
                    return;
            }

            JOptionPane.showMessageDialog(null, result, "Result",
                    JOptionPane.INFORMATION_MESSAGE);

            int again = JOptionPane.showConfirmDialog(null, "Do you want to solve another equation?",
                    "Continue?", JOptionPane.YES_NO_OPTION);
            if (again != JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
}
