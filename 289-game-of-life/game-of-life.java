class Solution {
    public void gameOfLife(int[][] b) {
        int r = b.length;
        int c = b[0].length;
        int[][] a = new int[r][c];
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int count = countLiveNeighbors(i, j, b);
                
                if (b[i][j] == 0 && count == 3) {
                    a[i][j] = 1;
                } else {
                    if (b[i][j] == 1 && count < 2) {
                        a[i][j] = 0;
                    } else if (b[i][j] == 1 && (count == 2 || count == 3)) {
                        a[i][j] = 1;
                    } else if (b[i][j] == 1 && count > 3) {
                        a[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                b[i][j] = a[i][j];
            }
        }
    }

   
    private int countLiveNeighbors(int x, int y, int[][] b) {
        int count = 0;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        for (int i = 0; i < 8; i++) {
            int ni = x + dx[i];
            int nj = y + dy[i];
            if (ni >= 0 && ni < b.length && nj >= 0 && nj < b[0].length && b[ni][nj] == 1) {
                count++;
            }
        }
        return count;
    }
}
