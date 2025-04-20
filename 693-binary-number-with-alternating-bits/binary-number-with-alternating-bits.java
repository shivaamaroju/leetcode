class Solution {
    public boolean hasAlternatingBits(int n) {
        int x=n&1;
        System.out.println(x);
        while(n>0){
            if(x!=(n&1))return false;
            n=n>>1;
            if(x==1)x=0;
            else x=1;

        }
        return true;
    }
}