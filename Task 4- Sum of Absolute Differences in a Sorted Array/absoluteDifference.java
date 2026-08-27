import java.util.Arrays;
class absoluteDifference {
    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        long totalSum = 0;
        // Find total sum
        for (int num : nums) {
            totalSum += num;
        }
        long leftSum = 0;
        for (int i = 0; i < n; i++) {
            // Elements on the left
            long left = (long) nums[i] * i - leftSum;
            // Elements on the right
            long right = (totalSum - leftSum - nums[i])
                       - (long) nums[i] * (n - i - 1);
            result[i] = (int) (left + right);
            leftSum += nums[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        int[] result = getSumAbsoluteDifferences(nums);
        System.out.println(Arrays.toString(result));
    }
}
