class Solution {
    public int sumBase(int n, int k) {
        int sum=0;
        while(n>=k){
            sum+=n%k;
           // System.out.println(sum);
            n/=k;
        }

        sum+=n;
        return sum;
    }
}