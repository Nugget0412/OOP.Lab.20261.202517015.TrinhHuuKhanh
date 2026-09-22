import java.util.Scanner;

class StarTriangle {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int n;
        while (true) {
            System.out.print("Enter the height of the triangle (n > 0): ");
            if (keyboard.hasNextInt()) {
                n = keyboard.nextInt();
                if (n > 0) break;
            } else {
                keyboard.next();
            }
            System.out.println("Invalid input! Please enter a positive integer.");
        }

        // Row i has (n - i) leading spaces and (2i - 1) stars
        for (int i = 1; i <= n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n - i; j++) {
                row.append(' ');
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                row.append('*');
            }
            System.out.println(row);
        }

        keyboard.close();
    }
}
