/*
explanation: pure dp approach! Maintains dp array which maintains maximum length possible for a tail x with being member of list.

testcase:
[10,9,2,5,3,7,101,18] -> Works

Time & Space Complexity: O(n^2) and O(n) : inefficient dp used!
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
        }
        
        int madp = -100000;
        for(int i=0; i<dp.length; i++){
            madp = Math.max(madp, dp[i]);
        }
        
        return madp;
    }
}