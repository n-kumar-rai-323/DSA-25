import java.util.Scanner;

public class setOfIntegers {
    public static void main(String[] args) {
        System.out.println(
                "Write a program that reads a set of integers and the prints the sum of the even and odd integers");
        Scanner sc = new Scanner(System.in);
        int evenSum = 0;
        int oddsum = 0;
        System.out.println("Enter integers (Enter 0 to finish):");
        int number;
        while (true) {
            System.out.print("Enter an integer:");
            if (sc.hasNextInt()) {
                number = sc.nextInt();

                if (number == 0) {
                    break;
                }
                if(number %2==0){
                    evenSum = evenSum + number;
                }else{
                    oddsum = oddsum + number;
                }
            }else{
                System.out.println("Invalid input. Please enter valid number");
                sc.next();
            }
        }
        System.out.println("Sum of even integers: " + evenSum);
        System.out.println("Sum of odd integers:" + oddsum);
        sc.close();
    }
}
