import java.util.Scanner;

class DaysOfMonth {

    static final String[][] MONTHS = {
        {"January",   "Jan.",  "Jan", "1"},
        {"February",  "Feb.",  "Feb", "2"},
        {"March",     "Mar.",  "Mar", "3"},
        {"April",     "Apr.",  "Apr", "4"},
        {"May",       "May",   "May", "5"},
        {"June",      "June",  "Jun", "6"},
        {"July",      "July",  "Jul", "7"},
        {"August",    "Aug.",  "Aug", "8"},
        {"September", "Sept.", "Sep", "9"},
        {"October",   "Oct.",  "Oct", "10"},
        {"November",  "Nov.",  "Nov", "11"},
        {"December",  "Dec.",  "Dec", "12"}
    };

    static final int[] DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    static int parseMonth(String input) {
        for (int i = 0; i < MONTHS.length; i++) {
            for (String name : MONTHS[i]) {
                if (name.equalsIgnoreCase(input)) return i + 1;
            }
        }
        return 0;
    }

    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int month;
        while (true) {
            System.out.print("Enter a month: ");
            month = parseMonth(keyboard.nextLine().trim());
            if (month != 0) break;
            System.out.println("Invalid month! Please enter again (e.g. January, Jan., Jan or 1).");
        }

        int year;
        while (true) {
            System.out.print("Enter a year: ");
            String input = keyboard.nextLine().trim();

            if (input.matches("\\d{1,9}")) {
                year = Integer.parseInt(input);
                break;
            }
            System.out.println("Invalid year! Please enter a non-negative number with all digits (e.g. 1999).");
        }

        int days = DAYS[month - 1];
        if (month == 2 && isLeapYear(year)) days = 29;

        System.out.println(MONTHS[month - 1][0] + " " + year + " has " + days + " days.");

        keyboard.close();
    }
}
