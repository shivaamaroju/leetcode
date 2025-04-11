import java.util.HashSet;

class Solution {
    public int missingInteger(int[] a) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : a) set.add(num);

        // Step 1: Find the sum of the longest prefix of consecutive increasing elements
        int sum = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1] + 1) {
                sum += a[i];
            } else {
                break;
            }
        }

        // Step 2: Find the smallest number >= sum that is not in the array
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}
