class Solution {
    public boolean divideArray(int[] a) {
        int b[]=new int [1000];
        for(int i=0;i<a.length;i++){
            b[a[i]]++;
        }
        for(var s:b){
            if(s%2!=0)return false;
        }
        return true;
    }
}