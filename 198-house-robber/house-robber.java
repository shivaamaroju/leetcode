class Solution {
    public int rob(int[] nums) {
        int b[]=new int [nums.length];
        int max=0;
        Arrays.fill(b,-1);
        for(int i=0;i<nums.length;i++){
            int ans=ff(nums,i,b);
            max=Math.max(max,ans);
        }
        return max;

    }
    public int ff(int nums[],int i,int b[]){
        if(i>=b.length)return 0;
        if(b[i]!=-1)return b[i];
        int take=nums[i]+ff(nums,i+2,b);
        int no=ff(nums,i+1,b);
        b[i]= Math.max(take,no);
        return b[i];
    }
}