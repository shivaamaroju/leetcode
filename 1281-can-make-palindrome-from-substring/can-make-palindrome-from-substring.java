class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] q) {
        HashMap<Character, Integer> mp = new HashMap<>();
        List<HashMap<Character, Integer>> l = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
            l.add(new HashMap<>(mp));
        }

        List<Boolean> ll = new ArrayList<>();
        for (int i = 0; i < q.length; i++) {
            int le = q[i][0];
            int r = q[i][1];
            int o = q[i][2];

            HashMap<Character, Integer> mp3 = le > 0 ? l.get(le - 1) : new HashMap<>();
            HashMap<Character, Integer> mp4 = l.get(r);

            HashMap<Character, Integer> ans = new HashMap<>();
            for (var ss : mp4.entrySet()) {
                char key = ss.getKey();
                int freq = ss.getValue() - mp3.getOrDefault(key, 0);
                if (freq > 0) ans.put(key, freq);
            }

            int c = 0;
            for (var ss : ans.entrySet()) {
                if (ss.getValue() % 2 != 0) c++;
            }

            if (c / 2 <= o) ll.add(true);
            else ll.add(false);
        }

        return ll;
    }
}
