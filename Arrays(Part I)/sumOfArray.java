

public class sumOfArray {
  
    public static int calculateSum(int[] numbers) {
       int sum =0;
       for(int i=0; i<numbers.length; i++){
        sum = sum + numbers[i];
       
       }
       return sum;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        int sum = calculateSum(data);
        System.out.println("The sum of elements is: " + sum); // Expected output: 15

        int[] data2 = {10, -5, 20};
        int sum2 = calculateSum(data2);
        System.out.println("The sum of elements is: " + sum2); // Expected output: 25
    }
}