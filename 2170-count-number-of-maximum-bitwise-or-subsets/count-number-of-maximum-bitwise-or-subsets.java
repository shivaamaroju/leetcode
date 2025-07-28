import java.util.*;

class Solution {
    int maxOr = 0;
    int[][] memo;

    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;

        // Calculate max OR
        for (int num : nums) {
            maxOr |= num;
        }

        // Initialize memo table: n x (maxOr + 1)
        memo = new int[n][1 << 17];  // nums[i] <= 1e5 < 2^17
        for (int[] row : memo)
            Arrays.fill(row, -1);

        return dp(0, 0, nums);
    }

    private int dp(int i, int currOr, int[] nums) {
        if (i == nums.length) {
            return currOr == maxOr ? 1 : 0;
        }

        if (memo[i][currOr] != -1) return memo[i][currOr];

        // Two choices: include nums[i] or not
        int include = dp(i + 1, currOr | nums[i], nums);
        int exclude = dp(i + 1, currOr, nums);

        return memo[i][currOr] = include + exclude;
    }
}
