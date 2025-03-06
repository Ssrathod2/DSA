import java.util.*;

class Solution {

    public int rec(String s1,String s2, int idx1, int idx2,int [][] dp){
        if(idx1<0 || idx2<0) return 0;
        // if(idx1==0 || idx2==0){
        //     if(s1.charAt(idx1) == s2.charAt(idx2)) return 1;
        //     else return 0;
        // }

        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        int nottake1 = 0;
        int nottake2 = 0;
        int take = 0;

        if(s1.charAt(idx1) == s2.charAt(idx2)){
            take = rec(s1,s2,idx1-1,idx2-1,dp)+1;
        }else{
            nottake1 = rec(s1,s2,idx1-1,idx2,dp);
            nottake2 = rec(s1,s2,idx1,idx2-1,dp);
        }

        return dp[idx1][idx2] = Math.max(take,Math.max(nottake1,nottake2));

    }
public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int [][] dp = new int[s1.length()+1][s2.length()+1];

        Arrays.stream(dp).forEach(row -> Arrays.fill(row,0));

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int take=0,nottake1=0,nottake2=0;
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    take = dp[i-1][j-1] + 1;
                }else{
                    nottake1 = dp[i-1][j];
                    nottake2 = dp[i][j-1];
                }

                dp[i][j] = Math.max(take, Math.max(nottake1,nottake2));
            }

        }

        return dp[n][m];


        //return rec(s1,s2,s1.length()-1,s2.length()-1,dp);
    }
}

/*
Approach :

 0 1 2
0
1
2
3

*/