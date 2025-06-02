public class Reverse {
    public static void reverseNum(int nums[]) {
        int first = 0;
        int last = nums.length-1;

        while (first < last) {
            int temp = nums[last];
            nums[last] = nums[first];
            nums[first] = temp;
            first ++;
            last --;
        }
    }

    public static void main(String[] args) {
        int nums[] = { 10, 2, 6, 3, 1, 5 };
        reverseNum(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
