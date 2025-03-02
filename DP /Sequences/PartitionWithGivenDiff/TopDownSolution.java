import java.util.*;

class Solution {
    int countPartitions(int[] arr, int d) {
        // code here
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        if(sum-d < 0 || (sum-d)%2 !=0) return 0;
        int target = (sum-d)/2;
        
        int [][] dp = new int[n][target+1];
        
        Arrays.stream(dp).forEach(row -> Arrays.fill(row,0));
        
        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }
        
        if(arr[0] <= target) dp[0][arr[0]] += 1;
        
        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                int nottake = dp[i-1][j];
                int take = 0;
                if(arr[i] <= j){
                    take = dp[i-1][j-arr[i]];
                }
                dp[i][j] = take + nottake;
            }
        }
        
        return dp[n-1][target];
    }
}