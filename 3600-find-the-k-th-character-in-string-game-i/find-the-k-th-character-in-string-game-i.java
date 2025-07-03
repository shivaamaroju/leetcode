class Solution {
    public char kthCharacter(int k) {
        String s="";
        while(s.length()<k){
            if(s.length()==0)s+='a';
            String kl="";
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                kl+=((++ch));
            }
            s+=kl;
        }
        return s.charAt(k-1);
    }
}