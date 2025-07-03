class Solution {
    public boolean increasingTriplet(int[] nums) {
int f=Integer.MAX_VALUE;
int s=Integer.MAX_VALUE;
for(int i=0;i<nums.length;i++){
if(nums[i]<=f){
    f=nums[i];
}
else if(nums[i]<=s){
    s=nums[i];
}
else return true;
}
return false;




    }
}
    //    Stack<Integer> st=new Stack<>();
    //    for(int i=0;i<nums.length;i++){
    //     while(!st.isEmpty()&&nums[i]<st.peek()){
    //         st.pop();
    //     }
    //     if(st.size()==3)return true;
    //     st.push(nums[i]);
    //     if(st.size()==3)return true;
    //    }
    //     if(st.size()==3)return true;
    //    return false; 
//     int n=nums.length;
//     int c=0;
//     merge(nums,0,n-1,c);
//     return c>=3;
//     }
//     public void merge(int nums[],int l,int h,int c){
//         if(l<h){
//             int mid=(l+h)/2;
//             merge(nums,l,mid,c);
//             merge(nums,mid+1,h,c);
//             sort(nums,l,mid,h,c);
//         }
//     }
//     public void sort(int nums[],int l,int mid,int h,int c){
//         int i=l,j=mid+1;
//         List<Integer> ll=new ArrayList<>();
//         while(i<=mid&&j<=h){
//             if(nums[i]<nums[j]){
//                 ll.add(nums[i]);i++;
//             }
//             else{
//                 c++;
//                 ll.add(nums[j]);j++;
//             }
//         }
//         while(i<=mid){
//              ll.add(nums[i]);i++;
//         }
//         while(j<=h){
//             ll.add(nums[j]);j++;
//         }
//         int k=0;
//         for( i=l;i<=h;i++){
// nums[i]=ll.get(k++);
//         }