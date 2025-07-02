class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashMap<Integer, HashSet<Integer>> mp = new HashMap<>();

        for (int x : nums1) {
            mp.putIfAbsent(x, new HashSet<>());
            mp.get(x).add(1);
        }

        for (int x : nums2) {
            mp.putIfAbsent(x, new HashSet<>());
            mp.get(x).add(2);
        }

        for (int x : nums3) {
            mp.putIfAbsent(x, new HashSet<>());
            mp.get(x).add(3);
        }

        List<Integer> result = new ArrayList<>();
        for (var entry : mp.entrySet()) {
            if (entry.getValue().size() >= 2) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
