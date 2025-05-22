import java.util.Scanner;

public class mult {
    public static void main(String[] args) {
        System.out.println("Write a program to print multiplication table of number N, entered by the user.");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number N");
        int index = sc.nextInt();
  System.out.println("Multiplication Table for " + index + ":");
        for(int i=1; i<=10; i++){
            System.out.println(index + " X " + i + " = " + (index * i));
        }
        sc.close();

    }
}
