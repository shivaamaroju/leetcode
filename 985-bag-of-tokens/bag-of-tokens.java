class Solution {
    public int bagOfTokensScore(int[] t, int power) {
        Arrays.sort(t);
        int i=0,j=t.length-1;
        int c=0;
        while(i<=j){
            if(t[i]<=power){
                c++;
                power-=t[i];
                i++;
            }
            else if(c>0&&i!=j){
              c--;
            
                power+=t[j];
                j--;
            }
            else j--;

        }
        return c<0?0:c;

    }
}