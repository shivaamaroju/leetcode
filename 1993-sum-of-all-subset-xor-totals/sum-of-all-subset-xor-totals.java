import java.util.*;

class Solution {
    public int subsetXORSum(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int lop = (int)Math.pow(2, n); // Total number of subsets

        for (int i = 0; i < lop; i++) {
            List<Integer> subsetIndices = fun(i);
            int x = 0;
            for (int s : subsetIndices) {
                x ^= nums[s]; // XOR instead of addition
            }
            sum += x; // Add each subset XOR to the sum
        }

        return sum;
    }

    // Convert a number into the list of indices for which bits are set
    public List<Integer> fun(int n) {
        List<Integer> res = new ArrayList<>();
        int index = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                res.add(index);
            }
            index++;
            n >>= 1;
        }
        return res;
    }
}
