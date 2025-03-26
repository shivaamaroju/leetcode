import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        
        // Flatten grid into a list
        for (int[] row : grid) {
            for (int num : row) {
                list.add(num);
            }
        }

        // Sort the list to find the median
        Collections.sort(list);
        int median = list.get(list.size() / 2);

        int operations = 0;

        // Calculate the number of operations
        for (int num : list) {
            int diff = Math.abs(num - median);
            if (diff % x != 0) return -1; // If not possible, return -1
            operations += diff / x;
        }

        return operations;
    }
}
