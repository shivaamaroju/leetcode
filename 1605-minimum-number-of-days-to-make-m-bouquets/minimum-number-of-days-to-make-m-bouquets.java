class Solution {
    public int minDays(int[] a, int m, int k) {
        if (m * k > a.length) return -1; 
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            min = Math.min(a[i], min);
            max = Math.max(a[i], max);
        }

        int l = min, h = max, result = -1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (canMakeBouquets(a, mid, m, k)) {
                result = mid;  
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }

    private boolean canMakeBouquets(int[] a, int days, int m, int k) {
        int count = 0, bouquets = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= days) {
                count++; 
                if (count == k) { 
                    bouquets++; 
                    count = 0; 
                }
            } else {
                count = 0; 
            }
               if (bouquets >= m) return true; 
        }
        return false;
    }
}
