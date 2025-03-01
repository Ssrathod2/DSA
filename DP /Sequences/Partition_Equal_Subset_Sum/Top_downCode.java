import java.util.*;

class Solution {
    public boolean rec(int[] nums , int i,int cursum , int ans,int [][] dp){
        if( i >= nums.length || cursum > ans) return false;
        if(cursum == ans){
            dp[i][cursum] = 1;
            return true;
        }
        if(dp[i][cursum] != -1) return dp[i][cursum] == 1 ? true : false;
        dp[i][cursum] = (rec(nums,i+1,cursum+nums[i] , ans,dp) || rec(nums,i+1,cursum,ans,dp)) ? 1 : 0;
        return dp[i][cursum] == 1 ? true : false;

    }
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        if(sum %2 !=0) return false;
        int [][] dp = new int[n][sum/2+1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row,-1));
        return rec(nums,0,0,sum/2,dp);
        
    }
}
