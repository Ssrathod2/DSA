import java.util.*;
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left = 0;
        //int right = 0;
        int n =  blocks.length();

        int ans = Integer.MAX_VALUE;
        int wc = 0;
        
        for(int right = 0; right < n ;right++){
            if(blocks.charAt(right) == 'W') wc++;

            if(right-left + 1 == k){
                ans = Math.min(ans,wc);
                if(ans == 0) return 0;
                if(blocks.charAt(left) == 'W') wc--;
                left ++ ;
            }
        }

        return ans;
    }
}
