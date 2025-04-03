class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        long maxTripletValue = 0;

        int[] nextGreater = new int[n];
        nextGreater[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            nextGreater[i] = Math.max(nums[i], nextGreater[i + 1]);
        }

    
        int max1 = nums[0];
        for (int j = 1; j < n - 1; j++) {
            max1 = Math.max(max1, nums[j - 1]);
            if (max1 > nums[j]) {
                long value = (long) (max1 - nums[j]) * nextGreater[j +1];
                maxTripletValue = Math.max(maxTripletValue, value);
            }
        }

        return maxTripletValue;
    }
}
