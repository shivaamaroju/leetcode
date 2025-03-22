class Solution {
    public int numberOfSubstrings(String s) {
        int c = 0;
        int a[] = {-1, -1, -1}; // Stores the last index of 'a', 'b', 'c'

        for (int r = 0; r < s.length(); r++) {
            a[s.charAt(r) - 'a'] = r; // Update the latest index of current char
            
            if (a[0] != -1 && a[1] != -1 && a[2] != -1) { // Check if all characters are present
                c += (1 + Math.min(a[0], Math.min(a[1], a[2]))); // Count valid substrings
            }
        }
        return c;
    }
}
