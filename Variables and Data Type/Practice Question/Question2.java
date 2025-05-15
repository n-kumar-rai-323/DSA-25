import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        // In a program, input the side of a square. You have to output the area of the square. 
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the side of the square: ");
        double side = input.nextDouble();

        double area = side * side;

        System.out.println("The area of the square is: " + area);

        input.close();
    }
}
