class Solution {
    public long minimumDifference(int[] nums) {
      int n=nums.length/3;
      long leftsum=0;
      long left[]=new long[nums.length];
      PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
return b-a;
      });
    for(int i=0;i<nums.length;i++){
        pq.add(nums[i]);
        leftsum+=nums[i];
        if(pq.size()>n){
leftsum-=pq.remove();
        }
        if(pq.size()==n)left[i]=leftsum;
    }  
     long right[]=new long[nums.length];
     long rightsum=0;
      PriorityQueue<Integer> pq1=new PriorityQueue<>();
    for(int i=0;i<nums.length;i++){
        pq1.add(nums[nums.length-i-1]);
        rightsum+=nums[nums.length-i-1];
        if(pq1.size()>n){
rightsum-=pq1.remove();
        }
        if(pq1.size()==n)right[nums.length-i-1]=rightsum;

    } 
    long min=Long.MAX_VALUE;
    for(int i=n-1;i<nums.length-n;i++){
        min=Math.min(min,left[i]-right[i+1]);
    }
    return min;

    }
}