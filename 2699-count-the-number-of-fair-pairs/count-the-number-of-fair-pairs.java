import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long countBelowLower = countPairsLessThanOrEqual(nums, lower - 1);
        long countBelowUpper = countPairsLessThanOrEqual(nums, upper);
        return countBelowUpper - countBelowLower;
    }

    private long countPairsLessThanOrEqual(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        long count = 0;

        while (left < right) {
            if (nums[left] + nums[right] <= target) {
                // All pairs (left, left+1)...(left, right) are valid
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
