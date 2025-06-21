class Solution {
    public int minDistance(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return helper(s, t, s.length() - 1, t.length() - 1, dp);
    }

    public int helper(String s, String t, int i, int j, int[][] dp) {
        if (i < 0) return j + 1; // insert all remaining of t
        if (j < 0) return i + 1; // delete all remaining of s
        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = helper(s, t, i - 1, j - 1, dp);
        } else {
            int insert = helper(s, t, i, j - 1, dp) + 1;
            int delete = helper(s, t, i - 1, j, dp) + 1;
            int replace = helper(s, t, i - 1, j - 1, dp) + 1;
            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }
}
