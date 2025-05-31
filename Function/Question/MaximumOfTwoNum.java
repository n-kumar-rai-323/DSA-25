public class MaximumOfTwoNum {
    public static int findMax(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        int num1 = 4;
        int num2 = 5;
        int maxResult = findMax(num1, num2);
        System.out.println("The maximum of " + num1 + " and " + num2 + " is: " + maxResult);
    }
}
