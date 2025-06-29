import java.util.Arrays;

class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1_000_000_007;
        int n = nums.length;
        int res = 0;

        // Sort the array
        Arrays.sort(nums);

        // Precompute powers of 2 up to n
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % mod;
        }

        int l = 0, r = n - 1;
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                res = (res + pow2[r - l]) % mod;
                l++;
            } else {
                r--;
            }
        }

        return res;
    }
}
