class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        int n=nums.length;
        int b[]=new int[n-k+1];
        int st=0;
        for(int i=0;i<n;i++){
            while(!dq.isEmpty()&&(i-dq.peekFirst())>=k){
dq.removeFirst();
            }
            while(!dq.isEmpty()&&nums[dq.peekLast()]<nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i>=k-1&&!dq.isEmpty())b[st++]=nums[dq.peekFirst()];

        }
        return b;
    }
}