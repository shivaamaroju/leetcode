class Solution {
    int c = 0;

    public int uniquePathsWithObstacles(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        c = way(0, 0, m - 1, n - 1, a, dp); // ✅ Store the result
        return c;
    }

    public int way(int sr, int sc, int er, int ec, int[][] a, int[][] dp) {
        if (sr > er || sc > ec || a[sr][sc] == 1) return 0;
        if (sr == er && sc == ec) return 1;
        if (dp[sr][sc] != -1) return dp[sr][sc];

        int x = way(sr + 1, sc, er, ec, a, dp);
        int y = way(sr, sc + 1, er, ec, a, dp);

        return dp[sr][sc] = x + y;  // ✅ Store in dp
    }
}
