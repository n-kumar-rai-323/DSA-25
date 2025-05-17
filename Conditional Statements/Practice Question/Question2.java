import java.util.Scanner;

public class Question2 {

  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your body temperature in Fahrenheit: ");
        double temperature = scanner.nextDouble();

        if (temperature > 100) {
            System.out.println("You have a fever.");
        } else {
            System.out.println("You don't have a fever.");
        }

        scanner.close();
    }
}