import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;
        
        
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
              if ( countMap.get(num)>(n / 3)&&!result.contains(num)) {
               
                result.add(num);
            }

        }

     
        return result;
    }
}
