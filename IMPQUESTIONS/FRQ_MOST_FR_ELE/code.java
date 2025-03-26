import java.util.*;
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = 0;
        long ts = 0 , ans = 0;

        while(right < n){
            ts += nums[right];
            if(nums[right] * (right-left+1L) <= ts+k){
                ans = Math.max(ans, right-left+1L);
            }
            while(nums[right] * (right-left+1L) > ts+k && left <right){
                ts -= nums[left];
                left++;
            }
            right++;
        }

        return (int) ans;
    }
}
