class Solution {
    public String convert(String s, int n) {
        if (n == 1) return s;

        char[][] a = new char[n][s.length()];
        int i = 0, k = 0;

        for (int j = 0; j < s.length() && i < s.length(); j++) {
            if (k != 0 && k != n - 1 && i < s.length()) {
                a[k][j] = s.charAt(i);
                k--;
                i++;
            } else {
                while (k < n && i < s.length()) {
                    a[k][j] = s.charAt(i);
                    k++;
                    i++;
                    if (k == n) {
                        k = n - 2;
                        j++; // move to next column when switching direction
                        break;
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char[] ss : a) {
            for (char sss : ss) {
                if ((sss >= 'a' && sss <= 'z') || (sss >= 'A' && sss <= 'Z') || sss == ',' || sss == '.') {
                    ans.append(sss);
                }
            }
        }

        return ans.toString();
    }
}
