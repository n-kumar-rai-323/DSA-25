import java.util.Scanner;

public class tax {
    public static void main(String[] args) {
        System.out.println("Income Tax Calculator");
        Scanner sc = new Scanner(System.in);
        float income = sc.nextFloat();
        int tax;
        if(income <500000){
           tax =0;
        }else if(income >= 500000 && income < 1000000){
            tax = (int) (income * 0.2);
        }else{
            tax = (int )(income*0.3);
        }
        System.out.println("your tax is:" + tax);
    }
}
