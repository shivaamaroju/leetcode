class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        int max = 0;
        for (var s : events) {
            max = Math.max(max, s[1]);
        }
    TreeSet<Integer> st=new TreeSet<>();
        for(int i=1;i<=max;i++){
st.add(i);
        }

        int c = 0;
        for (var s : events) {
            int frst = s[0];
            int last = s[1];
Integer x=st.ceiling(frst);
if(x!=null&&x<=last){
    c++;
    st.remove(x);

}
            }
        
        return c;
    }
}
