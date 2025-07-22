class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int st = 0, c = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);

            if (mp.get(nums[i]) == 1) k--; 

            while (k < 0) {
                mp.put(nums[st], mp.get(nums[st]) - 1);
                if (mp.get(nums[st]) == 0) {
                    mp.remove(nums[st]);
                    k++; 
                }
                st++;
            }

            c += (i - st + 1); // count subarrays ending at i
        }

        return c;
    }
}
