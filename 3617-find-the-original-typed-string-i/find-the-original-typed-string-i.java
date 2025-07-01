class Solution {
    public int possibleStringCount(String s) {
        int c=1;
        for(int i=0;i<s.length()-1;i++){
            char ch=s.charAt(i);
             char ch1=s.charAt(i+1);
            if(ch==ch1)c++;
        }
        return c;
    }
}