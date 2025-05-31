class Solution {
    public int maxSubArray(int[] nums) {

        //int curSum = Integer.MIN_VALUE;
        //int maxSoFar = Integer.MIN_VALUE;
        int curSum = nums[0];
        int maxSoFar = nums[0];

        for(int i=1;i<nums.length;i++){
            //if(curSum+nums[i] < 0) curSum=0;
            curSum = Math.max(nums[i],curSum+nums[i]);
            maxSoFar = Math.max(maxSoFar,curSum);

        }

        return maxSoFar;

        
    }
}
