class Solution {
    public String[] findWords(String[] words) {
        Map<Integer, String> mp = new HashMap<>();
        mp.put(1, "qwertyuiop");
        mp.put(2, "asdfghjkl");
        mp.put(3, "zxcvbnm");
        ArrayList<String> l = new ArrayList<>();

        for (var s : words) {
            char ch = Character.toLowerCase(s.charAt(0));
            String s1 = mp.get(1);
            String s2 = mp.get(2);
            String s3 = mp.get(3);
            if (s1.indexOf(ch) != -1) {
                if (valid(s1, s)) l.add(s);
            } else if (s2.indexOf(ch) != -1) {
                if (valid(s2, s)) l.add(s);
            } else {
                if (valid(s3, s)) l.add(s);
            }
        }
        return l.toArray(new String[0]);
    }

    public boolean valid(String row, String word) {
        for (char ch : word.toLowerCase().toCharArray()) {
            if (row.indexOf(ch) == -1) return false;
        }
        return true;
    }
}
