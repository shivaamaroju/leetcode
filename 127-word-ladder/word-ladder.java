class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        visited.add(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process all words in current level
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        chars[j] = c;
                        String nextWord = new String(chars);
                        if (nextWord.equals(endWord)) return level + 1;
                        if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                            queue.offer(nextWord);
                            visited.add(nextWord);
                        }
                    }
                    chars[j] = original; // backtrack
                }
            }

            level++;
        }

        return 0;
    }
}
