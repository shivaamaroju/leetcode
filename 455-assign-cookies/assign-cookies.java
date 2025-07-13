class Solution {
    public int findContentChildren(int[] p, int[] t) {
         Arrays.sort(p);
      Arrays.sort(t);
      int n=Math.min(p.length,t.length);
      int i=0,j=0,c=0;
      for(i=0;i<n;i++){
        while(j<t.length&&t[j]<p[i]){
            j++;
        }
        if(j<t.length&&t[j]>=p[i]){
            j++;c++;}
      }  
      return c;
    }
}