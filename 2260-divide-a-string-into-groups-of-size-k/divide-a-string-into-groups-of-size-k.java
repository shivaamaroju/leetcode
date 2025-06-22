class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n=s.length();
           System.out.println(n);
        while(n%k!=0){
            s+=fill;
            n++;
        }
        String a[]=new String[n/k];
       int kk=0;
       for(int i=0;i<s.length();i+=k){
        int j=i;
        String m="";
        int kl=0;
        while(kl<k&&j<s.length()){
            m+=s.charAt(j);
            j++;
            kl++;
        }
        a[kk++]=m;
       }
        return a;
    }
}