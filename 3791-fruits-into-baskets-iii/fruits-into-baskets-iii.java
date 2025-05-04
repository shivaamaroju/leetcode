class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        NumsTree tree = new NumsTree(baskets);
        int unplaced = 0;

        for (int fruit : fruits) {
            int pos = tree.place(fruit);
            if (pos == -1) unplaced++;
        }
        return unplaced;
    }
}

class NumsTree {
    int[] seg;
    int n;

    public NumsTree(int[] baskets) {
        n = baskets.length;
        seg = new int[4 * n];
        build(0, 0, n - 1, baskets);
    }

    private void build(int idx, int l, int r, int[] baskets) {
        if (l == r) {
            seg[idx] = baskets[l];
            return;
        }
        int mid = (l + r) / 2;
        build(2 * idx + 1, l, mid, baskets);
        build(2 * idx + 2, mid + 1, r, baskets);
        seg[idx] = Math.max(seg[2 * idx + 1], seg[2 * idx + 2]); // Use max!
    }

    public int place(int val) {
        int pos = query(0, 0, n - 1, val);
        if (pos != -1) {
            update(0, 0, n - 1, pos, 0); 
        }
        return pos;
    }

    private int query(int idx, int l, int r, int val) {
        if (seg[idx] < val) return -1; 

        if (l == r) return l;

        int mid = (l + r) / 2;
        int left = query(2 * idx + 1, l, mid, val);
        if (left != -1) return left;
        return query(2 * idx + 2, mid + 1, r, val);
    }

    private void update(int idx, int l, int r, int pos, int val) {
        if (l == r) {
            seg[idx] = val;
            return;
        }

        int mid = (l + r) / 2;
        if (pos <= mid) update(2 * idx + 1, l, mid, pos, val);
        else update(2 * idx + 2, mid + 1, r, pos, val);

        seg[idx] = Math.max(seg[2 * idx + 1], seg[2 * idx + 2]);
    }
}
