class Solution {
    public String smallestSubsequence(String s) {
         int a[]=new int[26];
    for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        a[(int)ch-'a']++;
    }
    Stack<Integer> st=new Stack<>();
     for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        int x=(int)ch-'a';
        while(!st.isEmpty()&&st.peek()>x&&a[st.peek()]>0&&!st.contains(x)){
            st.pop();
        }
        if(!st.contains(x))
        st.push(x);
        a[x]--;
    }
  String xx="";
    while(!st.isEmpty()){
        int x=st.pop();
        char ch=(char)(x+'a');
       xx=ch+xx;
    }
    return xx;
    }
}