import java.util.Arrays;

class TwoSum {

    public int[] unsortedTwoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int index1 = i;
            for(int x = 0; x < nums.length; x++) {
                int index2 = x;
                if(nums[index1] + nums[index2] == target && index1 != index2) {
                    result[0] = index1;
                    result[1] = index2;
                    return result;
                }
            }
        }
        result[0] = -1;
        result[1] = -1;
        return result;
    }

    public static void main(String args[]) {
        int[] testArr = {1,6,2,3,4,0};
        int target = 12;
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.unsortedTwoSum(testArr, target)));
    }
}
