public class subArray {
    public static void printSubArray(int num[]) {
         int currentSubarraySum = 0;
         int maxSum = Integer.MIN_VALUE;
       
        for (int i = 0; i < num.length; i++) {
            int start = i;
            for (int j = i ; j < num.length; j++) {
                int end = j;
                
                for (int k = start; k <= end; k++) {
                    System.out.print(num[k] + " ");
                    currentSubarraySum += num[k];
                }
               System.out.println(" (Sum: " + currentSubarraySum + ")");
                 +
                 
                
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int num[] = { 2, 4, 6, 8, 10 };
        printSubArray(num);
    }
}
