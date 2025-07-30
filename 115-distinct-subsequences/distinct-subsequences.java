class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return countWays(s, t, 0, 0, dp);
    }

    private int countWays(String s, String t, int i, int j, int[][] dp) {
        if (j == t.length()) return 1;        
        if (i == s.length()) return 0;         

        if (dp[i][j] != -1) return dp[i][j];   

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = countWays(s, t, i + 1, j + 1, dp) + countWays(s, t, i + 1, j, dp);
        } else {
            dp[i][j] = countWays(s, t, i + 1, j, dp);
        }

        return dp[i][j];
    }
}
