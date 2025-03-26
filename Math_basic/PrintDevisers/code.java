class Solution {
    public static int calc(int num){
        int sq = (int) Math.sqrt(num);
        int ans = 0;
        
        for(int i=1;i<=sq;i++){
            if(num%i == 0){
                if(num/i != i) ans += (num/i + i);
                else ans += i;
            }
        }
        
        return ans;
    }
    public static int sumOfDivisors(int n) {
        // code here
        int ans = 0;
        
        
        for(int i=1;i<=n;i++){
            ans += calc(i);
        }
        
        return ans;
        
        
    }
}
