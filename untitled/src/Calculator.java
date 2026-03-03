import java.util.Scanner;

public class Calculator {

    public static double squareRoot(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number.");
        }
        return Math.sqrt(x);
    }

    public static long factorial(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Factorial of negative number not defined.");
        }
        long result = 1;
        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    public static double naturalLog(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Natural log undefined for zero or negative numbers.");
        }
        return Math.log(x);
    }

    public static double power(double x, double b) {
        return Math.pow(x, b);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nScientific Calculator");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Log (ln x)");
            System.out.println("4. Power (x^b)");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter number: ");
                        double num = scanner.nextDouble();
                        System.out.println("Result: " + squareRoot(num));
                        break;

                    case 2:
                        System.out.print("Enter integer: ");
                        int factNum = scanner.nextInt();
                        System.out.println("Result: " + factorial(factNum));
                        break;

                    case 3:
                        System.out.print("Enter number: ");
                        double logNum = scanner.nextDouble();
                        System.out.println("Result: " + naturalLog(logNum));
                        break;

                    case 4:
                        System.out.print("Enter base: ");
                        double base = scanner.nextDouble();
                        System.out.print("Enter exponent: ");
                        double exponent = scanner.nextDouble();
                        System.out.println("Result: " + power(base, exponent));
                        break;

                    case 5:
                        System.out.println("Exiting Calculator...");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}