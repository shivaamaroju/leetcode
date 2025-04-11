class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int c=0;
        for(int i=low;i<=high;i++){
if(fun(i))c++;
        }
        return c;
    }
    public boolean fun(int n){
        String s="";
        s+=n;
        int i=0,j=s.length()/2;
        if(s.length()%2!=0)return false;
        int sum1=0,sum2=0;
        for(;i<j;i++){
            int  nn=(int)s.charAt(i)-'0';
            sum1+=nn;
        }
           for(;j<s.length();j++){
            int  nn=(int)s.charAt(j)-'0';
            sum2+=nn;
        }
        return sum1==sum2;
    }
    
}