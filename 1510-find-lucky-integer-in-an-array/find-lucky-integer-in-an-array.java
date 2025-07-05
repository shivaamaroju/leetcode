class Solution {
    public int findLucky(int[] b) {
        int a[]=new int [1000];
        int c=Integer.MIN_VALUE;
        for(int i=0;i<b.length;i++){
a[b[i]]++;

        }
                for(int i=0;i<b.length;i++){
//a[b[i]]++;
if(a[b[i]]==b[i]){
    if(c<b[i]){
        c=b[i];
    }
}
        }
        if(c==Integer.MIN_VALUE)
        return -1;
        return c;
    }
}