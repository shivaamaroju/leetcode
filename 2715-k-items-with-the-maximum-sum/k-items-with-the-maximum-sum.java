class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int sum=0;
        if(k<=numOnes)return k;
        if(k>numOnes)sum+=numOnes;
        k-=numOnes;
        if(k<=numZeros&&k>=0)return sum;
        if(k>numZeros)sum+=0;
        k-=numZeros;
        if(k<=numNegOnes&&k>=0)return sum-=k;
        k-=numNegOnes;
        return sum-k;



    }
}