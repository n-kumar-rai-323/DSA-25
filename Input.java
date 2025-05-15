import java.util.*;

import javax.print.DocFlavor.STRING;

public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(input);
        Scanner scFull = new Scanner(System.in);
        String fullName = scFull.nextLine();
        System.out.println(fullName);

    }
}
