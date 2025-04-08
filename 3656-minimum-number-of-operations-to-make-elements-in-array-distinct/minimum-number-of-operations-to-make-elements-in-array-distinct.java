class Solution {
    public int minimumOperations(int[] nums) {
        int c=0;
        int i=0;
        while(!dist(nums,i)){
            c++;
            i+=3;}
        return c;
    }
    public boolean dist(int nums[],int i){
        HashSet<Integer> hs=new HashSet<>();
        for(int j=i;j<nums.length;j++){
            if(!hs.contains(nums[j]))hs.add(nums[j]);
            else return false;            
        }
        return true;
    }
}