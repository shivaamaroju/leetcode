class Solution {
    public boolean isHappy(int n) {
        int s=n,f=n;
        while(true){
            s=square(s);
            f=square(square(f));
            if(check(s) || check(f))return true;
            if(s==f)return false;
        }
        // return true;
    }

    public boolean check(int n){
        return Math.log10(n)+1 == 1;
    }
    public int square(int num) {
        
        int ans = 0;
        
        while(num > 0) {
            int remainder = num % 10;
            ans += remainder * remainder;
            num /= 10;
        }
        
        return ans;
    }
}