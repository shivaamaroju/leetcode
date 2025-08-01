class Solution {
    public List<List<Integer>> generate(int n) {
        int a[][]=new int[n][];
        int c=0;
        List<List<Integer>> ll=new ArrayList<>();
for(int i=0;i<n;i++){
  
    a[i]=new int[++c];
}  
for(int i=0;i<n;i++){
    for(int j=0;j<a[i].length;j++){
        if(j==0||j==a[i].length-1)a[i][j]=1;
        else{
            if(i-1>=0&&j-1>=0){
            a[i][j]=a[i-1][j]+a[i-1][j-1];}
        }
    }
} 
for(int i=0;i<a.length;i++){
    List<Integer> l=new ArrayList<>();
    for(int j=0;j<a[i].length;j++){
        l.add(a[i][j]);
    }
    ll.add(l);
}     
return ll;


        
    }
}