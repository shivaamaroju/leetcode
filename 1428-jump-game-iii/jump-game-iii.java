class Solution {
    public boolean canReach(int[] arr, int start) {
        return helper(arr, start, new boolean[arr.length]);
    }

    public boolean helper(int[] a, int idx, boolean[] visited) {
        if (idx < 0 || idx >= a.length || visited[idx]) return false;
        if (a[idx] == 0) return true;

        visited[idx] = true;

        boolean forward = helper(a, idx + a[idx], visited);
        boolean backward = helper(a, idx - a[idx], visited);

        return forward || backward;
    }
}
