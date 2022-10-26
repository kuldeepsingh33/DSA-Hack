/*
explanation: coin change problem using simple dp! it works by having a recursive function that performs one of the two operations: either skip current coin in case it is insufficient and go to next coin or take it and reduce the amount for it! using simple memoization to optimize the solution!

testcase:
[1,2,5]
11 -> Works

Time & Space Complexity: O(n^2) && O(n): Time complexity is quadratic for array dp and recursion! Same for space complexity.
*/
class Solution {
    int[] coins;
    int dp[][];
    
    public int chan(int n, int amount){
        // System.out.println(n+" "+amount);
        
        // if(amount == 0) return 0;
        // if(n < 0){
        //     return Integer.MAX_VALUE - 1000;
        //}
        if(amount < 0) return Integer.MAX_VALUE - 1;
        if(amount == 0) return 0;
        if(n < 0){
            return Integer.MAX_VALUE - 1;
        }
        
        if(dp[n][amount]!=-1) return dp[n][amount];

        if(coins[n] > amount){
            return dp[n][amount]=chan(n-1, amount); // No change to amount, skip this coin as denom > amount
        }
        else{
            int wh = amount/coins[n];
            int frac = amount%coins[n];
            // int x1 = wh + chan(n-1, frac);
            int x1 = 1 + chan(n, amount-coins[n]);
            int x2 = chan(n-1, amount);
            
            return dp[n][amount]=Math.min(x1, x2); // Get the better result! either include or exclude the coin change
        }
    }
    
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.dp = new int[coins.length+1][amount+1];
        for(int[] d:dp){
            Arrays.fill(d, -1);
        }
        
        int denom = chan(coins.length-1, amount);
        // System.out.println(denom+" ");
        if(denom < 0 || denom > amount)
            return -1;
        else return denom;
    }
}