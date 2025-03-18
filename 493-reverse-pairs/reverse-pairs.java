class Solution {
    int c=0;
    public int reversePairs(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return c;
    }
    public void mergesort(int nums[],int i,int j){
        if(i<j){
            int mid=(i+j)/2;
            mergesort(nums,i,mid);
            mergesort(nums,mid+1,j);
            count(nums,i,mid,mid+1,j);
            merge(nums,i,mid,j);
        }
    }
    public void merge(int a[],int l,int mid,int h){
        int temp[]=new int[h-l+1];
        int i=l,j=mid+1,k=0;
        while(i<=mid&&j<=h){
            if(a[i]<a[j]){
temp[k++]=a[i++];
            }
            else{
temp[k++]=a[j++];
            }
        }
        while(i<=mid){
            temp[k++]=a[i++];
        }
        while(j<=h){
            temp[k++]=a[j++];
        }
         k=0;
         for(int ii=l;ii<=h;ii++){
a[ii]=temp[k++];
         }
    }
    public void count(int a[],int l,int mid,int k,int h){
        int r=k;
        for(int i=l;i<=mid;i++){
            while(r<=h&& (long) a[i] > 2L * a[r])r++;
            c+=(r-(k));
        }
    }
}