import java.util.Scanner;

public class switchStat {
   public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Basic Calculator!");
        System.out.println("----------------------------------");

        System.out.print("Enter the first number: ");
        int number1 = input.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = input.nextInt();

        System.out.print("Enter the operation (+, -, *, /): ");
        char operator = input.next().charAt(0);

        double result; // Use double to store potential decimal results

        switch (operator) {
            case '+':
                result = number1 + number2;
                System.out.println("Result: " + number1 + " + " + number2 + " = " + result);
                break;
            case '-':
                result = number1 - number2;
                System.out.println("Result: " + number1 + " - " + number2 + " = " + result);
                break;
            case '*':
                result = number1 * number2;
                System.out.println("Result: " + number1 + " * " + number2 + " = " + result);
                break;
            case '/':
                if (number2 == 0) {
                    System.out.println("Error: Cannot divide by zero.");
                } else {
                    result = (double) number1 / number2; // Cast to double for accurate division
                    System.out.println("Result: " + number1 + " / " + number2 + " = " + result);
                }
                break;
            default:
                System.out.println("Error: Invalid operator entered.");
        }

        System.out.println("----------------------------------");
        System.out.println("Thank you for using the calculator!");

        input.close();
    }
}
