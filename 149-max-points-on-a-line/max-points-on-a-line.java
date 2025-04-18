class Solution {
    public int maxPoints(int[][] points) {
        if (points.length < 3) return points.length;
        int max = 2;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int count = 2;
                for (int k = 0; k < points.length; k++) {
                    if (k != i && k != j && isCollinear(points[i], points[j], points[k])) {
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    private boolean isCollinear(int[] a, int[] b, int[] c) {
        // Using area of triangle = 0 condition
        return (a[0]*(b[1] - c[1]) + b[0]*(c[1] - a[1]) + c[0]*(a[1] - b[1])) == 0;
    }
}
