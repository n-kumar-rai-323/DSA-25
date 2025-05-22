package Loop;

import java.util.Scanner;

public class oneToN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int range = sc.nextInt();
int count = 1;
        while(count <=range){
            System.out.println(count);
            count++;

        }
    }
}
