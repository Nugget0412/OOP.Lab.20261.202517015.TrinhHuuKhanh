import java.util.Arrays;
import java.util.Scanner;

class SortArray {

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

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int n;
        while (true) {
            System.out.print("Enter the number of elements: ");
            String input = keyboard.nextLine().trim();

            if (input.matches("\\d{1,9}") && Integer.parseInt(input) > 0) {
                n = Integer.parseInt(input);
                break;
            }
            System.out.println("Invalid size! Please enter a positive integer.");
        }

        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readNumber(keyboard, "Element " + (i + 1) + ": ");
        }

        Arrays.sort(arr);

        double sum = 0;
        for (double x : arr) sum += x;
        double average = sum / n;

        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);

        keyboard.close();
    }
}
