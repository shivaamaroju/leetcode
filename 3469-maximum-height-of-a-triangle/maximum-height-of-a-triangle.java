class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        if (red == blue) {
            int rc = 1;
            boolean x = false;
            while (true) {
                if (!x && blue - rc >= 0) {
                    blue -= rc;
                } else if (x && red - rc >= 0) {
                    red -= rc;
                } else {
                    break;
                }
                rc++;
                x = !x;
            }
            return rc - 1;
        }

        int ans = helper(red, blue, 1, 1);   // Start with red
        int ans2 = helper(red, blue, 0, 1);  // Start with blue
        return Math.max(ans, ans2);
    }

    public int helper(int red, int blue, int ans, int rc) {
        if (red < 0 || blue < 0) return rc - 1;

        if (ans == 0 && red - rc >= 0) {
            return helper(red - rc, blue, 1, rc + 1);
        } else if (ans == 1 && blue - rc >= 0) {
            return helper(red, blue - rc, 0, rc + 1);
        }
        return rc - 1;
    }
}
