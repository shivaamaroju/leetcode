class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
    HashMap<String,Integer>hs=new HashMap<>();
    //HashSet<String> hs=new HashSet<>();
    int c=0;
        for(var a:dominoes){
            int l=a[0];
            int f=a[1];
            String s=l+" "+f;
            String d=f+" "+l;
            if(hs.containsKey(s)||hs.containsKey(d)){
                int add=0;
                if(hs.containsKey(s)){
                    add=hs.get(s);
                    hs.put(s,add+1);
                }
                else{
  add=hs.get(d);
                    hs.put(d,add+1);
                }
                c+=add;
            
            }
            else{
                hs.put(s,1);
            }

        }
        // for(var s:hs.entrySet()){
        //     System.out.println(s);
        // }
        return c;
    }
}
