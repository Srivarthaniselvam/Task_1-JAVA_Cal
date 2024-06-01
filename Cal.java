import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        System.out.println("Welcome to My Simple Calculator");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Get user input for the two numbers
            double num1 = getUserInput(scanner, "Enter first number: ");
            double num2 = getUserInput(scanner, "Enter second number: ");
            // Get the operation choice from the user
            String operator = selectOperation(scanner);

            double result;
            try {
                // Perform the chosen operation
                result = performOperation(num1, num2, operator);
                // Display the result
                System.out.printf("\nResult: %.2f %s %.2f = %.2f\n", num1, getOperatorSymbol(operator), num2, result);
            } catch (ArithmeticException e) {
                // Handle division by zero
                System.out.println("Error: " + e.getMessage());
            }

            // Ask the user if they want to perform another operation
            System.out.print("Do you want to perform another operation? (y/n): ");
            if (!scanner.next().equalsIgnoreCase("y")) {
                System.out.println("Thank you for using My Calculator!");
                break;
            }
        }

        scanner.close();
    }

    // Method to get valid user input for a number
    private static double getUserInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next(); // discard the invalid input
            }
        }
    }

    // Method to get the operation choice from the user
    private static String selectOperation(Scanner scanner) {
        System.out.println("\nSelect operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");

        while (true) {
            System.out.print("Enter choice (1/2/3/4): ");
            String choice = scanner.next();
            if (choice.matches("[1-4]")) {
                return choice;
            } else {
                System.out.println("Invalid input. Please enter a valid choice (1/2/3/4).");
            }
        }
    }

    // Method to perform the selected operation
    private static double performOperation(double x, double y, String operator) {
        switch (operator) {
            case "1":
                return add(x, y);
            case "2":
                return subtract(x, y);
            case "3":
                return multiply(x, y);
            case "4":
                return divide(x, y);
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    // Method for addition
    private static double add(double x, double y) {
        return x + y;
    }

    // Method for subtraction
    private static double subtract(double x, double y) {
        return x - y;
    }

    // Method for multiplication
    private static double multiply(double x, double y) {
        return x * y;
    }

    // Method for division with error handling for division by zero
    private static double divide(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return x / y;
    }

    // Method to get the symbol of the selected operator
    private static String getOperatorSymbol(String operator) {
        switch (operator) {
            case "1":
                return "+";
            case "2":
                return "-";
            case "3":
                return "*";
            case "4":
                return "/";
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
