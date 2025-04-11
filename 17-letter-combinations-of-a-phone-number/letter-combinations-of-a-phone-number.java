class Solution {
    public List<String> letterCombinations(String s) {
        HashMap<Integer, String> mp = new HashMap<>();
        mp.put(2, "abc");
        mp.put(3, "def");
        mp.put(4, "ghi");
        mp.put(5, "jkl");
        mp.put(6, "mno");
        mp.put(7, "pqrs");
        mp.put(8, "tuv");
        mp.put(9, "wxyz");

        if (s == null || s.length() == 0) return new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        String ss = mp.get(s.charAt(0) - '0');
        for (int i = 0; i < ss.length(); i++) {
            char ch = ss.charAt(i);
            q.add(ch + "");
        }

        for (int i = 1; i < s.length(); i++) {
            int size = q.size();
            String k = mp.get(s.charAt(i) - '0');
            for (int j = 0; j < size; j++) {
                String sss = q.remove();
                for (int m = 0; m < k.length(); m++) {
                    char chh = k.charAt(m);
                    String n = sss + chh;
                    q.add(n);
                }
            }
        }

        return new ArrayList<>(q);
    }
}
