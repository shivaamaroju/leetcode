class Solution {
    public char kthCharacter(long k, int[] o) {
        boolean shifted =false;
       long cal[]=new long[o.length+1];
       cal[0]=1;
       for(int i=1;i<=o.length;i++){
        cal[i]=Math.min(cal[i-1]*2,k);
       }
       k--;
       int c=0;
       for(int i=o.length-1;i>=0;i--){
        long half=cal[i];
        if(o[i]==0){
            if(half<=k){
k-=half;
            }
        }
        else{
            if(half<=k){
k-=half;
c++;
            }
             
        }
       }
       
       c=c%26;
        return (char)('a'+c);
    }
}