class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int st=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
long sum=0; 
int max=0;      
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
       
                while(st<i&&mp.get(nums[i])>=2){
int x=mp.get(nums[st]);
sum-=nums[st];
if(x==1)mp.remove(nums[st]);
else mp.put(nums[st],x-1);
st++;
                }
                max=Math.max((int)sum,max);
            
        }
        return max;
    }
}