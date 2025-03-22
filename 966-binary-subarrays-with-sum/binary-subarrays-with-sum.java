class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
     int x=fun(nums,goal);
       int y = (goal > 0) ? fun(nums, goal - 1) : 0; // Fix: Corrected condition
        return x - y;
  
    }
    public int fun(int nums[],int goal){
           int c=0,sum=0;
        int l=0,r=0;
        while(r<nums.length){
            sum+=nums[r];
            while(l<=r&&sum>goal){
                sum-=nums[l];
                l++;
            }
            c+=(r-l+1);
          //  System.out.println(c);
            r++;
        }
        return c;
    }
}