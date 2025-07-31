import java.util.*;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> result = new HashSet<>();
        HashSet<String> visited = new HashSet<>(); // acts as DP memoization

        for (int i = 0; i < arr.length; i++) {
            helper(arr, i, 0, result, visited);
        }

        return result.size();
    }

    public void helper(int[] a, int idx, int orValue, HashSet<Integer> result, HashSet<String> visited) {
        if (idx >= a.length) return;

        orValue |= a[idx];
        result.add(orValue);

        String key = idx + "," + orValue;
        if (visited.contains(key)) return;

        visited.add(key);
        helper(a, idx + 1, orValue, result, visited);
    }
}
