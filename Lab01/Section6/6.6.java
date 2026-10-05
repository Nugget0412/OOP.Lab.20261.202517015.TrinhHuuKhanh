import java.util.Scanner;

class AddMatrices {

    static int readPositiveInt(Scanner keyboard, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = keyboard.nextLine().trim();

            if (input.matches("\\d{1,9}") && Integer.parseInt(input) > 0) {
                return Integer.parseInt(input);
            }
            System.out.println("Invalid size! Please enter a positive integer.");
        }
    }

    static double readNumber(Scanner keyboard, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = keyboard.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Please enter again.");
            }
        }
    }

    static double[][] readMatrix(Scanner keyboard, String name, int rows, int cols) {
        System.out.println("Enter elements of matrix " + name + ":");
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = readNumber(keyboard, name + "[" + (i + 1) + "][" + (j + 1) + "]: ");
            }
        }
        return matrix;
    }

    static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double x : row) {
                System.out.print(x + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int rows = readPositiveInt(keyboard, "Enter the number of rows: ");
        int cols = readPositiveInt(keyboard, "Enter the number of columns: ");

        double[][] a = readMatrix(keyboard, "A", rows, cols);
        double[][] b = readMatrix(keyboard, "B", rows, cols);

        double[][] sum = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }

        System.out.println("Matrix A:");
        printMatrix(a);
        System.out.println("Matrix B:");
        printMatrix(b);
        System.out.println("A + B:");
        printMatrix(sum);

        keyboard.close();
    }
}
