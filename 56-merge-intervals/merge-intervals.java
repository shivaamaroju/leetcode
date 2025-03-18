class Solution {
    public int[][] merge(int[][] a) {
  Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));
        List<List<Integer>>l=new ArrayList<>();
        for(int i=0;i<a.length;i++){

if(l.size()!=0&&l.get(l.size()-1).get(1)>=a[i][0]){
 ArrayList<Integer> ll=new ArrayList<>();
 ll.add(l.get(l.size()-1).get(0));
 int m1=l.get(l.size()-1).get(1);
 l.remove(l.size()-1);
int max=Math.max(a[i][1],m1);
 ll.add(max);
 l.add(ll);
}
else{
        ArrayList<Integer> ll=new ArrayList<>();
  ll.add(a[i][0]);
  ll.add(a[i][1]);
  l.add(ll);

}
        }
        int b[][]=new int[l.size()][2];
        for (int i = 0; i < l.size(); i++) {
            for (int j = 0; j < 2; j++) {
                b[i][j] = l.get(i).get(j);
            }
        }
        return b;
    }
}