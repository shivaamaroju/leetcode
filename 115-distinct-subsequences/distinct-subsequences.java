class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        // Initialize dp with -1 meaning uncomputed
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return countWays(s, t, 0, 0, dp);
    }

    private int countWays(String s, String t, int i, int j, int[][] dp) {
        if (j == t.length()) return 1;         // matched all of t
        if (i == s.length()) return 0;         // s is exhausted

        if (dp[i][j] != -1) return dp[i][j];   // return memoized result

        if (s.charAt(i) == t.charAt(j)) {
            // match OR skip
            dp[i][j] = countWays(s, t, i + 1, j + 1, dp) + countWays(s, t, i + 1, j, dp);
        } else {
            // skip only
            dp[i][j] = countWays(s, t, i + 1, j, dp);
        }

        return dp[i][j];
    }
}
