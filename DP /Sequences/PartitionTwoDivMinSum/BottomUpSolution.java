import java.util.*;

class Solution {
    // Function to calculate the number of subsets with a given sum
    
    public int rec(int[] nums, int idx, int cursum, int target,int [][] dp){
        if(cursum > target) return 0;
        if(idx >= nums.length){
            if(cursum == target) {
                return 1;
            }
            else {
                return 0;
                
            }
        }
        //cursum += nums[idx];
        if(dp[idx][cursum] != -1) return dp[idx][cursum];

        
        int take = rec(nums,idx+1,cursum+nums[idx],target,dp);
        int nottake = rec(nums,idx+1,cursum,target,dp);
        dp[idx][cursum] = take+nottake;
        return dp[idx][cursum];
     }
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        int [][] dp = new int[n][target+1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row,-1));
        return rec(nums,0,0,target,dp);
        
        // for(int i=0;i<n;i++){
        //     dp[i][0] = 1;
        // }
        // if(nums[0] <= target) dp[0][nums[0]] += 1;
        
        // for(int i=1;i<n;i++){
        //     for(int j=0;j<=target;j++){
        //         int nottake = dp[i-1][j];
        //         int take = 0;
        //         if(nums[i] <= j){
        //             take = dp[i-1][j-nums[i]];
        //         }
        //         dp[i][j] = take+nottake;
        //     }
        // }
        
        // return dp[n-1][target];

       
    }
}

/* 
Approach :

1 2 3 4 5

  0 1 2 3 4 5
0 1 0 0 0 0 0
1 1 1 0 0 0 0
2 
3
4
5

*/