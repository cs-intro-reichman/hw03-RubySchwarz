/*
 * Prints the calendar of a given year.
 */
public class Calendar {
    static int dayOfMonth = 1;
    static int month = 1;
    static int year = 1900;
    static int dayOfWeek = 2; // 1.1.1900 was a Monday.

    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Usage: java Calendar <year>");
            return;
        }

        int targetYear = Integer.parseInt(args[0]);

        // Loop to advance to the start of the given year.
        while (year < targetYear) {
            advance();
        }

        // Loop that prints the calendar of the given year.
        while (year == targetYear) {
            printDate();
            advance();
        }
    }

    // Prints if it's a Sunday.
    private static void printDate() {
        if (dayOfWeek == 1) {
            System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday");
        } else {
            System.out.println(dayOfMonth + "/" + month + "/" + year);
        }
    }

    // Advances the date (day, month, year).
    private static void advance() {
        dayOfWeek = (dayOfWeek % 7) + 1;

        if (dayOfMonth == nDaysInMonth(month, year)) {
            dayOfMonth = 1;
            if (month == 12) {
                year++;
                month = 1;
            } else {
                month++;
            }
        } else {
            dayOfMonth++;
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int nDaysInMonth(int month, int year) {
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        } else {
            return 31;
        }
    }
}
