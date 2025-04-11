class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int sum = 0;
        List<Boolean> result = new ArrayList<>();
        for (int bit : nums) {
            sum = ((sum << 1) | bit) % 5;
            result.add(sum == 0);
        }
        return result;
    }
}
