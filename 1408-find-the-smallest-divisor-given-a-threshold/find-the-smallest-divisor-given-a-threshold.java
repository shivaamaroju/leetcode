class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            min=Math.min(nums[i],min);
 max=Math.max(nums[i],max);
        }
       // System.out.println(max+" "+min);
        int l=1,h=max,ans=0;
        while(l<=h){
            int mid=(l+h)/2;
            if(fun(nums,mid,threshold)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    public boolean  fun(int a[],int mid,int t){
        int s=0;
        for(int i=0;i<a.length;i++){
            s+=Math.ceil((double)a[i]/mid);
            if(s>t)return false;
        }
        return true;
    }
}