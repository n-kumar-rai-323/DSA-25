import java.util.Scanner;

public class prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if (num <= 1) {
            System.out.println("Not prime");
            return;
        }
        if (num == 2) {
            System.out.println("It is prime");
            return;
        }

        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break; // Exit the loop early if a divisor is found
            }
        }

        if (isPrime) {
            System.out.println("It is prime");
        } else {
            System.out.println("Composite");
        }
        sc.close(); // It's good practice to close the Scanner
    }
}