import java.util.Scanner;

public class oddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TotalEvenNumber = 0;
        int TotalOddNumber = 0;
        int number;
        while (true) {
            System.out.println("Enter a number:");
            number = sc.nextInt();
            if (number == 0){
                 break;
            }else if(number % 2 ==0){
                TotalEvenNumber++;
            }else{
                TotalOddNumber++;
            }
               
        }
        System.out.println("\n -----Result-----");
        System.out.println("Total Even Numbers: " + TotalEvenNumber);
        System.out.println("Total Odd Number:" + TotalOddNumber);
        sc.close();
    }
}
