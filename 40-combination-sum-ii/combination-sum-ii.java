class Solution {
    public List<List<Integer>> combinationSum2(int[] a, int t) {
        Arrays.sort(a);
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        helper(a, 0, t, l, ll);
        return l;
    }

    public void helper(int[] a, int i, int t, List<List<Integer>> l, List<Integer> ll) {
        if (t == 0) {
            l.add(new ArrayList<>(ll));
            return;
        }
        if (t < 0 || i >= a.length) return;

        for (int idx = i; idx < a.length; idx++) {
            if (idx > i && a[idx] == a[idx - 1]) continue; // skip duplicates
            ll.add(a[idx]);
            helper(a, idx + 1, t - a[idx], l, ll);
            ll.remove(ll.size() - 1);
        }
    }
}
