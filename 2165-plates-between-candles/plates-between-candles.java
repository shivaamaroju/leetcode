class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] prefixPlates = new int[n];
        int[] nearestLeftCandle = new int[n];
        int[] nearestRightCandle = new int[n];
        int plateCount = 0;

        // Prefix sum of plates
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') plateCount++;
            prefixPlates[i] = plateCount;
        }

        // Nearest left candle
        int lastCandle = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') lastCandle = i;
            nearestLeftCandle[i] = lastCandle;
        }

        // Nearest right candle
        lastCandle = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') lastCandle = i;
            nearestRightCandle[i] = lastCandle;
        }

        // Answer queries
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int l = nearestRightCandle[left];
            int r = nearestLeftCandle[right];
            if (l != -1 && r != -1 && l < r)
                res[i] = prefixPlates[r] - prefixPlates[l];
        }
        return res;
    }
}
