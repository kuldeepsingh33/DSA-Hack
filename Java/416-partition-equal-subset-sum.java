/*
explanation: partition equal subset using dynamic programming! It works on the principle of recursion and the fact that any element has two options to affect sum1 and sum2 (sums of each partition), either the element will add sum1 or it will add to sum2 therefore we use the recursive calls to element that their equality!

testcase:
[1,5,11,5] -> Works

Time & Space Complexity: Time complexity is O(n^2) while space complexity is O(n^3), quadratic time complexity is due to using recursion whereas space complexity is due to the overhead of maintaining dp array!
*/

class Solution {
    int[] nums;
    int[][] dp;
    boolean[][][] dpb;
    
    boolean part(int sum1, int sum2, int n){
        if(n == nums.length){
            return sum1 == sum2?true:false;
        }
        
        // Retrieve Cache
        if(dp[sum1][n] != 0) return dp[sum1][n] == 1;
        
        // Include this item in arr1 & exclude from arr2
        boolean s1 = part(sum1+nums[n], sum2, n+1);
        
        // Exclude from arr1, include in arr2
        boolean s2 = part(sum1, sum2+nums[n], n+1);
        
        // Cache
        dp[sum1][n] = s1 || s2 ? 1 : -1;

        return  s1 || s2;
    }
    
    public boolean canPartition(int[] nums) {
        this.nums = nums;
        
        int MAX_SUM = 1;
        for(int i=0; i<nums.length; i++){
            MAX_SUM += nums[i];
        }
        
        // MAX_SUM /= 2;
        
        this.dp = new int[MAX_SUM][nums.length+1];
        
        return part(0, 0, 0);
    }
}