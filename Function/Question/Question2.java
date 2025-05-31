package Function.Question;

import java.util.Scanner;

public class Question2 {
    public static boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        //
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (isEven(n)) {
            System.out.println("Number is Even");
        } else {
            System.out.println("Number is odd");
        }
    }
}
