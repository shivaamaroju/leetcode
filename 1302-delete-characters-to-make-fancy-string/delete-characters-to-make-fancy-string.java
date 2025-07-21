class Solution {
    public String makeFancyString(String s) {
        StringBuilder k = new StringBuilder();  // Use StringBuilder for efficient string concatenation
        
        for (int i = 0; i < s.length(); i++) {
            // If the last two characters are the same as the current character, skip adding it
            if (k.length() >= 2 && s.charAt(i) == k.charAt(k.length() - 1) && s.charAt(i) == k.charAt(k.length() - 2)) {
                continue;
            }
            // Otherwise, add the current character
            k.append(s.charAt(i));
        }
        
        return k.toString();  // Convert StringBuilder to string before returning
    }
}
