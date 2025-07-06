import java.util.*;

class FindSumPairs {
    private final int[] a, b;
    private final Map<Integer, Integer> freqA = new HashMap<>();
    private final Map<Integer, Integer> freqB = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.a = nums1;
        this.b = nums2;

        for (int num : nums1) {
            freqA.put(num, freqA.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            freqB.put(num, freqB.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = b[index];
        int newVal = oldVal + val;

        // Update frequency map
        freqB.put(oldVal, freqB.get(oldVal) - 1);
        if (freqB.get(oldVal) == 0) freqB.remove(oldVal);

        b[index] = newVal;
        freqB.put(newVal, freqB.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : freqA.entrySet()) {
            int valA = entry.getKey();
            int needed = tot - valA;

            if (freqB.containsKey(needed)) {
                count += entry.getValue() * freqB.get(needed);
            }
        }

        return count;
    }
}
