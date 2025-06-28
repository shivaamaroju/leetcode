class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
     int b[][]=new int[nums.length][2];
     for(int i=0;i<nums.length;i++){
        b[i][0]=nums[i];
        b[i][1]=i;
     }  
     Arrays.sort(b,(c,d)->d[0]-c[0]);
     Arrays.sort(b,0,k,(c,d)->c[1]-d[1]);
     int ans[]=new int[k];
     for(int i=0;i<k;i++){
        ans[i]=b[i][0];
     }
     return ans; 
    }
}