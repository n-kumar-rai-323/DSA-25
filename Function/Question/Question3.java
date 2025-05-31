import java.util.Scanner;

public class Question3 {
public static boolean isPalindrome(int number){
    int revers = 0;
    int palindrome = number;
    while ( palindrome != 0) {
        int remainder = palindrome %10;
        revers= revers * 10 + remainder;
         palindrome= palindrome/10;

    }
    if(number == revers){
        return true;
    }
    return false;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if(isPalindrome(number)){
            System.out.println("Number: " + number + "is a Palindrome");
        }else{
            System.out.println("Number : " + number + " is not a palindrome");
        }

    }
}