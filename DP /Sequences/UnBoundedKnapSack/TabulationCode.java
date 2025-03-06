import java.util.*;


class Solution {
    static int rec(int val[] , int wt[] , int cap , int ind,int [][] dp){
        if(cap <= 0) return 0;
        // if(ind == 0){
        //     if(wt[ind] <= cap )
        //         return val[ind];
        //     else return 0;
        // }
        
        if(ind < 0) return 0;
        
        if(dp[ind][cap] != -1) return dp[ind][cap];
        
        int take = 0,nottake = 0;
        
        if(wt[ind] <= cap){
            take = rec(val,wt,cap-wt[ind],ind,dp) + val[ind];
        }
        
        nottake = rec(val,wt,cap,ind-1,dp);
        
        return dp[ind][cap] = Math.max(take,nottake);
        
    }
    
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        
        int [][] dp = new int[val.length][capacity+1];
        Arrays.stream(dp).forEach(row-> Arrays.fill(row,0));
        int n = val.length;
        
        //return rec(val,wt,capacity,val.length-1,dp);
        
        for(int j=1;j<=capacity;j++){
            if(wt[0] <= j) dp[0][j] = val[0] * (j/wt[0]);
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<=capacity;j++){
                int take = 0;
                
                int nottake = dp[i-1][j];
                
                if(wt[i] <= j) take = dp[i][j-wt[i]] + val[i];
                
                dp[i][j] = Math.max(take,nottake);
                
            }
        }
        
        return dp[n-1][capacity];
        
    }
}