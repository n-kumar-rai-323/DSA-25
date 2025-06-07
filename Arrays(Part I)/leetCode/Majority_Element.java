package leetCode;

public class Majority_Element {
    public static int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (count == 0) {
                
                candidate = num;
               
              
                count = 1;
            } else if (num == candidate) {
                System.out.println("hell" + num);
                count++;
                
            } else {
                count--;
                
            }
        }
        return candidate;
    }
    public static void main(String[] args) {
        int nums[] = {3,2,3};
       majorityElement(nums);
    }
}
