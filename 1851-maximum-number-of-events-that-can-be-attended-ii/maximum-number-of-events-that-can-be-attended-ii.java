class Solution {
    public int maxValue(int[][] e, int k) {
       Arrays.sort(e,(a,b)->a[0]-b[0]);
       int n=e.length;
       int dp[][]=new int[n][k+1];
       for(int i=0;i<n;i++){
        Arrays.fill(dp[i],-1);
       }
       int max=helper(e,k,n,dp,0);
       return max;

    }
    public int helper(int a[][],int k,int n,int dp[][],int idx){
if(idx>=n||k==0)return 0;
if(dp[idx][k]!=-1)return dp[idx][k];
int next=bin(a,a[idx][1]);
int t=a[idx][2]+helper(a,k-1,n,dp,next);
int nt=helper(a,k,n,dp,idx+1);
return dp[idx][k]= Math.max(t,nt);
    }
public int bin(int[][] a, int t) {
    int l = 0, h = a.length - 1;
    while (l <= h) {
        int mid = (l + h) / 2;
        if (a[mid][0] <= t) {
            l = mid + 1;
        } else {
            h = mid - 1;
        }
    }
    return l;
}

}