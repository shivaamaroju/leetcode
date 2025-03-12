class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        
        // Finding first non-negative index
        int left = 0, right = n - 1, firstNonNeg = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= 0) {
                firstNonNeg = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        // Finding first positive index
        left = 0;
        right = n - 1;
        int firstPos = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > 0) {
                firstPos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        // Count of negative and positive numbers
        int negCount = firstNonNeg;
        int posCount = n - firstPos;
        
        return Math.max(negCount, posCount);
    }
}
