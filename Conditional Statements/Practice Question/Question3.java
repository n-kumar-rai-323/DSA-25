import java.util.Scanner;

public class Question3 {
   public static void main(String[] args) {
        System.out.println("Write a Java program to input week number (1-7) and print day of week name using switch case.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter week number (1-7): ");
        int weekNumber = scanner.nextInt();

        String dayName;

        switch (weekNumber) {
            case 1:
                dayName = "Sunday";
                break;
            case 2:
                dayName = "Monday";
                break;
            case 3:
                dayName = "Tuesday";
                break;
            case 4:
                dayName = "Wednesday";
                break;
            case 5:
                dayName = "Thursday";
                break;
            case 6:
                dayName = "Friday";
                break;
            case 7:
                dayName = "Saturday";
                break;
            default:
                dayName = "Invalid number";
        }

        System.out.println("The day for week number " + weekNumber + " is: " + dayName);
        scanner.close();
    }
}
