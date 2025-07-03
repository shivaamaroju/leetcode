class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        int[] pref = new int[n];
        pref[n - 1] = shifts[n - 1] % 26;

        for (int i = n - 2; i >= 0; i--) {
            pref[i] = (pref[i + 1] + shifts[i]) % 26;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int shifted = ((ch - 'a') + pref[i]) % 26;
            sb.append((char) ('a' + shifted));
        }

        return sb.toString();
    }
}
