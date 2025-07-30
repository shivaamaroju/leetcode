class Solution {
    public boolean winnerOfGame(String colors) {
        int am=0,bm=0;
   for(int i=1;i<colors.length()-1;i++){
char ch=colors.charAt(i);
if(ch=='A'&&colors.charAt(i-1)=='A'&&colors.charAt(i+1)=='A')am++;
else if(ch=='B'&&colors.charAt(i-1)=='B'&&colors.charAt(i+1)=='B')bm++;


   }
   return am>bm;
    }
}