
public class largest {
    public static int findMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            System.out.println("Array cannot be null or empty");
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] data = { 10, 5, 20, 8, 15 };
        int max = findMax(data);
        System.out.println("The maximum element is: " + max); // Expected output: 20

        int[] data2 = { -5, -1, -10, -2 };
        int max2 = findMax(data2);
        System.out.println("The maximum element is: " + max2); // Expected output: -1
    }
}
