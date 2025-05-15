import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        // Enter cost 3 items from the user (using float data type)- a pencil, a pen and a eraser. You have
        // to output the total cast of the items back to the user as their bill. 
       Scanner input = new Scanner(System.in);

        System.out.print("Enter the cost of the pencil: ");
        float pencilCost = input.nextFloat();

        System.out.print("Enter the cost of the pen: ");
        float penCost = input.nextFloat();

        System.out.print("Enter the cost of the eraser: ");
        float eraserCost = input.nextFloat();

        float totalCostBeforeTax = pencilCost + penCost + eraserCost;
        float gstRate = 0.18f; // 18% GST
        float gstAmount = totalCostBeforeTax * gstRate;
        float totalCostAfterTax = totalCostBeforeTax + gstAmount;

        System.out.println("\nYour Bill:");
        System.out.println("Cost of Pencil: " + pencilCost);
        System.out.println("Cost of Pen: " + penCost);
        System.out.println("Cost of Eraser: " + eraserCost);
        System.out.println("--------------------");
        System.out.println("Subtotal: " + totalCostBeforeTax);
        System.out.println("GST (18%): " + gstAmount);
        System.out.println("--------------------");
        System.out.println("Total Cost (including GST): " + totalCostAfterTax);

        input.close();
    }
}
