class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> mp = new HashMap<>();
        int st = 0;
        for (int i = 0; i <= s.length() - 10; i++) {
            String t = s.substring(st, st + 10);
            mp.put(t, mp.getOrDefault(t, 0) + 1);
            st++;
        }

        List<String> l = new ArrayList<>();
        for (var ws : mp.entrySet()) {
            if (ws.getValue() > 1) {
                l.add(ws.getKey());
            }
        }

        return l;
    }
}
