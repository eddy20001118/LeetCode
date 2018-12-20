import java.util.Arrays;

public class LeetCode1 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        LeetCode1 leetCode1 = new LeetCode1();
        System.out.println(Arrays.toString(leetCode1.twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            //j = i + 1防止同一项被加两次
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        throw new IllegalStateException("No solution");
    }
}
