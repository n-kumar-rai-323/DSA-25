package leetCode;

public class Sumoftwonum {
    public static int[] sumTowNum(int nums[], int sum){
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j ++){
                if(nums[i] + nums[j] == sum){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalAccessError("No two sum solution found");
    }
    public static void main(String[] args) {
          int nums[] = {2, 3, 4, 5, 6, 7, 8, 9};
        int target = 10;

        try {
            int[] result = sumTowNum(nums, target);
            System.out.println("Indices are: [" + result[0] + ", " + result[1] + "]");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
