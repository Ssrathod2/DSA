import java.util.*;

class Solution {
    public int change(int amount, int[] coins) {

        int n = coins.length;
        int [][] dp = new int[n][amount+1];

        Arrays.stream(dp).forEach(row -> Arrays.fill(row,0));

        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }

        for(int j=0;j<=amount;j++){
            if(j%coins[0] == 0) dp[0][j] = 1;
        }

        for(int i=1;i<n;i++){
           for(int j=0;j<=amount;j++){
               int nottake = dp[i-1][j];

               int take = 0;

               if(j>=coins[i]){
                   take = dp[i][j-coins[i]];
               }
               dp[i][j] = nottake + take;
           }
        }

        return dp[n-1][amount];
        
    }
}