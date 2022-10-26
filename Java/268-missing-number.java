/*
explanation: find missing number by first summing up everything that is expected, ie base number and then the numbers in array. now the missing number is automatically be found by retuning the difference of these two numbers.

testcase:
[1] -> Works
[9,6,4,2,3,5,7,0,1] -> Works
*/

class Solution {
    public int missingNumber(int[] nums) {
        int base = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            base += i;
            sum += nums[i];
        }
        base += nums.length;
        
        return base - sum;
    }
}