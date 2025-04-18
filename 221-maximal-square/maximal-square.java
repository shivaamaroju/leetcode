class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] a = new int[rows][cols];
        
        // Convert to integer matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = matrix[i][j] == '1' ? 1 : 0;
            }
        }

        // Calculate column heights (like histogram)
        for (int j = 0; j < cols; j++) {
            for (int i = 1; i < rows; i++) {
                if (a[i][j] == 1) {
                    a[i][j] += a[i - 1][j];
                }
            }
        }

        int max = 0;

        // Iterate through each row to find max square
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a[i][j] == 0) continue;

                int height = a[i][j];
                int left = j, right = j;

                // Expand left
                while (left - 1 >= 0 && a[i][left - 1] >= height) {
                    left--;
                }

                // Expand right
                while (right + 1 < cols && a[i][right + 1] >= height) {
                    right++;
                }

                int width = right - left + 1;
                int side = Math.min(width, height); // Must form a square

                max = Math.max(max, side * side);
            }
        }

        return max;
    }
}
