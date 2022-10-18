/*
explanation: solving the given problem by using hare and tortoise theorem! Since the elements in array nums can be converted (or used) as a linedlist and duplicate number implies a loop in it therefore we can use Floyd's loop detection to find this duplicate number!

testcases:
[1,2,3,4,9,5,6,7,8,9] -> Works!
Starting, hare = 3, tortoise = 2,
now on next run hare becomes 3 -> 4 -> 9 (since nums[nums[3]] = nums[4] = 9), similiarly tortoise becomes nums[2] = 3, since now hare != tortoise, the algorithm is run again and on the next run hare and tortoise becomes 9 and 4 respectively.
On the last iteration, the values of hare and tortoise matches, and this is at the only duplicate number 9, returning it!

Time and Space Complexity: O(n) and O(1)
here hare and tortoise has time complexity O(n) and constant extra space is required therefore Space complexity is O(1)
*/

class Solution {
    public int findDuplicate(int[] nums) {
        int hare = nums[0];
        int tortoise = nums[0];
        
        hare = nums[nums[hare]];
        tortoise = nums[tortoise];
        
        while(hare != tortoise){
            hare = nums[nums[hare]];
            tortoise = nums[tortoise];
        }
        
        tortoise = nums[0];
        while(hare != tortoise){
            hare = nums[hare];
            tortoise = nums[tortoise];
        }

        return hare;
    }
}