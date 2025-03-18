class Solution {
    public void nextPermutation(int[] nums) {
        int idx=-1,n=nums.length-1;
        for(int i=n-1;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx=i;
                break;
            }
        }
        if(idx==-1){
            reverse(nums,0,n);
        }
        else{
                for(int i=n;i>=0;i--){
            if(nums[idx]<nums[i]){
               int t=nums[idx];
               nums[idx]=nums[i];
               nums[i]=t;
               break;
            }
        }
        reverse(nums,idx+1,n);
        }
    }
    public void reverse(int nums[],int i,int j){
        while(i<=j){
            int t=nums[i];
            nums[i]=nums[j];
            nums[j]=t;
            i++;j--;
        }
    }
}