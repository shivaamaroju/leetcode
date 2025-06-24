class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(var s: nums){
            mp.put(s,1+mp.getOrDefault(s,0));
        }
         PriorityQueue<Integer> q = new PriorityQueue<>((num1, num2) -> mp.get(num2) - mp.get(num1));
        for(var s:mp.entrySet()){
            q.add(s.getKey());
        } 
         System.out.println(q);
        int b[]=new int [k];
        for(int i=0;i<k;i++){
            b[i]=q.remove();
        }
        return b;
    }
}