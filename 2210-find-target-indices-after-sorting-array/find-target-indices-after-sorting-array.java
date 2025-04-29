class Solution {
    public List<Integer> targetIndices(int[] nums, int t) {
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        int a[]=new int [2];
        a[0]=-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(nums[mid]==t){
                a[0]=mid;
                j=mid-1;
            }
            else if(nums[mid]<t)i=mid+1;
            else j=mid-1;

        }
        List<Integer> l=new ArrayList<>();
        if(a[0]==-1)return l;
        l.add(a[0]);
        for(int k=a[0]+1;k<nums.length&&nums[k]==t;k++){
            l.add(k);
        }
        return l;
    }
}