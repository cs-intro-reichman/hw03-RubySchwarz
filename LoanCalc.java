/*
 * Computes the periodical payment necessary to re-pay a given loan.
 */
public class LoanCalc {

    static double epsilon = 0.001; // The computation tolerance (estimation error)
    static int iterationCounter; // Monitors the efficiency of the calculation

    public static void main(String[] args) {
        // Gets the loan data
        double loan = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);
        System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);

        // Computes the periodical payment using brute force search
        System.out.print("Periodical payment, using brute force: ");
        System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
        System.out.println();
        System.out.println("number of iterations: " + iterationCounter);

        // Computes the periodical payment using bisection search
        System.out.print("Periodical payment, using bi-section search: ");
        System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
        System.out.println();
        System.out.println("number of iterations: " + iterationCounter);
    }

    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
        iterationCounter = 0;
        double currentLoan = loan;
        double periodPay = loan / n;

        while (currentLoan >= epsilon) {
            currentLoan = endBalance(loan, rate, n, periodPay);
            if (currentLoan <= epsilon) {
                break;
            } else {
                periodPay = periodPay + epsilon;
                currentLoan = loan;
            }
            iterationCounter++;
        }
        return periodPay;
    }

    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
        iterationCounter = 0;
        double L = 0;
        double H = loan;
        double periodPay = (L + H) / 2;

        while ((H - L) > epsilon) {
            if (endBalance(loan, rate, n, periodPay) * endBalance(loan, rate, n, L) > 0) {
                L = periodPay;
            } else {
                H = periodPay;
            }
            periodPay = (L + H) / 2;
            iterationCounter++;
        }
        return periodPay;
    }

    private static double endBalance(double loan, double rate, int n, double payment) {
        double currentLoan = loan;
        for (int i = 1; i <= n; i++) {
            currentLoan = (currentLoan - payment) * (1 + rate / 100);
        }
        return currentLoan;
    }
}
