import java.util.Scanner;

public class oddEven {
    public static void main(String[] args) {
        System.out.println("Print if a number is Odd or Even");

        Scanner sc = new Scanner(System.in);
        double input = sc.nextInt();

        if(input % 2==0){
            System.out.println("EVEN");
        }else{
            System.out.println("ODD");
        }
    }
}
