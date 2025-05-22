import java.util.Scanner;

public class fact {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("write a program to find factorial of any number entered by the user");
        System.out.println("Enter a non-negative integer:");
        int num = sc.nextInt();

        int factorial = 1;
        // check for negative input
        if (num < 0) {
            System.out.println("Factorial is not defined for negative number");
        } else if (num == 0) {
            System.out.println("The factorial of 0 is 1");
        } else {
            for (int i = 1; i <= num; i++) {
                factorial = factorial * i;
                
            }
            System.out.println("The factorial of " + num + " is " + factorial);
        }
sc.close();
    }
}
