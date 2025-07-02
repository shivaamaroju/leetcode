class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] q) {
       int x[]=new int[s.length()+1];
       for(int i=0;i<s.length();i++){
        x[i+1]=x[i]^(1<<(s.charAt(i)-'a'));
       }
       List<Boolean>  l=new ArrayList<>();
       for(var ss:q){
        int wl=ss[0];
        int r=ss[1];
        int xx=x[r+1]^x[wl];
        int mask=Integer.bitCount(xx);
        if(mask/2>ss[2])l.add(false);
        else l.add(true);
       }
       return l;
    }
}