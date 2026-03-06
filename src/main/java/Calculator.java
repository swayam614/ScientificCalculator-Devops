import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

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
        FileWriter logWriter = null;

        try {
            logWriter = new FileWriter("calculator.log", true);
            logWriter.write("Calculator Started\n");
            logWriter.flush();
        } catch (IOException e) {
            System.out.println("Log file error.");
        }
        // this is just for testing
        // this is just for new testing

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
                        double sqrtResult = squareRoot(num);
                        System.out.println("Result: " + sqrtResult);

                        if (logWriter != null) {
                            logWriter.write("Square root of " + num + " = " + sqrtResult + "\n");
                            logWriter.flush();
                        }
                        break;

                    case 2:
                        System.out.print("Enter integer: ");
                        int factNum = scanner.nextInt();
                        long factResult = factorial(factNum);
                        System.out.println("Result: " + factResult);

                        if (logWriter != null) {
                            logWriter.write("Factorial of " + factNum + " = " + factResult + "\n");
                            logWriter.flush();
                        }
                        break;

                    case 3:
                        System.out.print("Enter number: ");
                        double logNum = scanner.nextDouble();
                        double logResult = naturalLog(logNum);
                        System.out.println("Result: " + logResult);

                        if (logWriter != null) {
                            logWriter.write("Natural log of " + logNum + " = " + logResult + "\n");
                            logWriter.flush();
                        }
                        break;

                    case 4:
                        System.out.print("Enter base: ");
                        double base = scanner.nextDouble();
                        System.out.print("Enter exponent: ");
                        double exponent = scanner.nextDouble();
                        double powerResult = power(base, exponent);
                        System.out.println("Result: " + powerResult);

                        if (logWriter != null) {
                            logWriter.write("Power: " + base + "^" + exponent + " = " + powerResult + "\n");
                            logWriter.flush();
                        }
                        break;

                    case 5:
                        System.out.println("Exiting Calculator...");

                        if (logWriter != null) {
                            logWriter.write("Calculator Exited\n");
                            logWriter.close();
                        }

                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());

                try {
                    if (logWriter != null) {
                        logWriter.write("Error occurred: " + e.getMessage() + "\n");
                        logWriter.flush();
                    }
                } catch (IOException ignored) {}
            }
        }
    }
}