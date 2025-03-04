import java.util.*;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if((sum+target) % 2 != 0) return 0;
        if(sum < Math.abs(target)) return 0;
        int findsum = (sum+target)/2;
        int n = nums.length;
        int [][] dp = new int [n][sum+1];
        Arrays.stream(dp).forEach(row-> Arrays.fill(row,0));

        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }
        dp[0][nums[0]] += 1;

        for(int i=1;i<n;i++){
            for(int j=0;j<=findsum;j++){
                int nottake = dp[i-1][j];
                int take = 0;
                if(nums[i] <= j){
                    take = dp[i-1][j-nums[i]];
                }
                dp[i][j] = take + nottake;
            }
        }
        return dp[n-1][findsum];  
    }
}