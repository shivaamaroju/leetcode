class Solution {
    public int[] rearrangeArray(int[] nums) {
        int b[]=new int[nums.length];
        int p=0,n=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                b[2*n+1]=nums[i];
                n++;
            }
            else {
                b[2*p]=nums[i];
                p++;}
        }
        return b;
    }
}