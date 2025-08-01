class Solution {
    public int triangularSum(int[] nums) {
        int b[][]=new int[nums.length][];
        for(int i=nums.length-1;i>=0;i--){
            b[nums.length-i-1]=new int[i+1];
        }
        for(int i=0;i<nums.length;i++){
            b[0][i]=nums[i];
        }
for(int i=1;i<b.length;i++){
    for(int j=0;j<b[i].length;j++){
    b[i][j]=(b[i-1][j]+b[i-1][j+1])%10;
    }
}

// for(int i=0;i<b.length;i++){
//     for(int j=0;j<b[i].length;j++){
//         System.out.print(b[i][j]+" ");
//     }
//         System.out.println(" ");
// }

        return b[nums.length-1][0];
    }
}