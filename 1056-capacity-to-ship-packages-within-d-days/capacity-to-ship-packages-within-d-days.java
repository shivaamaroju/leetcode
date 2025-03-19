class Solution {
    public int shipWithinDays(int[] a, int days) {
        int lc=0,sum=0,ans=0;
        for(int i=0;i<a.length;i++){
            lc=Math.max(a[i],lc);
            sum+=a[i];}
            int l=lc,h=sum;
            while(l<=h){
                int mid=(l+h)/2;
                if(fun(a,mid,days)){
                    ans=mid;
                    h=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            return ans;
    }
    public boolean fun(int a[],int c,int d){
        int sum=0;
        int days=1;
        for(int i=0;i<a.length;i++){
            if(sum+a[i]>c){
                days++;
                sum=0;
            }
            sum+=a[i];
            if(days>d)return false;
        }
        return true;
    }
}