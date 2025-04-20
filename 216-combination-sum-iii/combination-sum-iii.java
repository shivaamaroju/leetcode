class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> l=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        helper(1,k,n,n,l,ll);
        return l;
    }
    public void helper(int st,int k,int n,int t, List<List<Integer>> l,List<Integer> ll){
        if(n<0)return;
        if(n==0){
            if(ll.size()==k){
                List<Integer> kk=new ArrayList<>(ll);
                l.add(kk);
            }
            return;
        }
        for(int i=st;i<=9;i++){
            ll.add(i);
            helper(i+1,k,n-i,t,l,ll);
            ll.remove(ll.size()-1);

        }
    }
}