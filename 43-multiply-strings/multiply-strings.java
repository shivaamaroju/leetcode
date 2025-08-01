class Solution {
    public String multiply(String nums1, String nums2) {
            if (nums1.equals("0") || nums2.equals("0")) return "0";
        if(nums2.length()>nums1.length()){
            String temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        // int i=0,c=0;
        String ans="0";
        for(int j=nums1.length()-1;j>=0;j--){
        String s="";
        int c=0;
int y=(int)nums1.charAt(j)-'0';
        for( int i=nums2.length()-1;i>=0;i--){
int x=(int)nums2.charAt(i)-'0';
int ans1=x*y+c;
s=(ans1%10)+s;
c=ans1/10;
        }
        if(c>0)s=c+s;
         for (int z = 0; z < nums1.length() - 1 - j; z++) {
            s += "0";
        }
        ans=add(ans,s);
        }

        return ans;
    }
    public String add(String s, String t) {
    if (s.length() < t.length()) {
        String temp = s;
        s = t;
        t = temp;
    }

    int c = 0;
    String ans = "";

    int i = s.length() - 1;
    int j = t.length() - 1;

    while (i >= 0 || j >= 0 || c > 0) {
        int x = (i >= 0) ? s.charAt(i) - '0' : 0;
        int y = (j >= 0) ? t.charAt(j) - '0' : 0;

        int cal = x + y + c;
        ans = (cal % 10) + ans;
        c = cal / 10;

        i--;
        j--;
    }

    return ans;
}

}