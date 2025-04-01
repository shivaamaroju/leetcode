class Solution {
    public long mostPoints(int[][] a) {
        long[] b = new long[a.length];
        long max = 0;

        // Try starting from each index and find the maximum points
        for (int i = 0; i < a.length; i++) {
            long ans = calculatePoints(a, i, b);  // Calculate max points from index i
            max = Math.max(max, ans);             // Update max if the current path gives more points
        }
        
        return max;
    }

    // Recursively calculate maximum points from a given index
    private long calculatePoints(int[][] a, int index, long[] b) {
        if (index >= a.length) {
            return 0;  // Base case: Out of bounds
        }

        // Check if the result for this index is already calculated
        if (b[index] != 0) return b[index];

        // Take the current element and jump
        long take = a[index][0] + calculatePoints(a, index + a[index][1] + 1, b);

        // Skip the current element and move to the next
        long skip = calculatePoints(a, index + 1, b);

        // Store the result in the memoization array and return it
        b[index] = Math.max(take, skip);
        return b[index];
    }
}
