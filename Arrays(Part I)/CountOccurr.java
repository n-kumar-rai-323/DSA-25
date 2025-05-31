public class CountOccurr {

    public static int countOccurrences(int[] numbers, int target) {
        int count =0;
        for(int i=0; i<numbers.length; i++){
            if(target == numbers[i]){
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] data = {1, 5, 2, 5, 3, 5, 4};
        int target1 = 5;
        int count1 = countOccurrences(data, target1);
        System.out.println("The number " + target1 + " appears " + count1 + " times."); // Expected output: 3

        int target2 = 10;
        int count2 = countOccurrences(data, target2);
        System.out.println("The number " + target2 + " appears " + count2 + " times."); // Expected output: 0
    }
}