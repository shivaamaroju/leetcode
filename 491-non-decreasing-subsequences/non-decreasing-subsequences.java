class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
     List<List<Integer>> ans=new ArrayList<>();
     List<Integer> l=new ArrayList<>();
        helper(nums,ans,l,0);
        return ans;
    }
    public void helper(int nums[], List<List<Integer>> ans,List<Integer> l,int st){
        if(l.size()>=2){
            ans.add(new ArrayList<>(l));
        }
         HashSet<Integer> used = new HashSet<>();  
        for(int i=st;i<nums.length;i++){
            if(used.contains(nums[i]))continue;
                used.add(nums[i]);
            if(l.size()==0||l.get(l.size()-1)<=nums[i]){
                l.add(nums[i]);
                 helper(nums,ans,l,i+1);
            l.remove(l.size()-1);
            }
           
        }
    }
}