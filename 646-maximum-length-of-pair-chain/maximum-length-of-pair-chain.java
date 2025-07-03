class Solution {
    public int findLongestChain(int[][] p) {
    Arrays.sort(p,(a,b)-> a[1]-b[1]);
    int end=-10001,max=0;
    for(var s:p){
if(s[0]>end){
    max++;

    end=s[1];
}
    }
    return max;
    }
}