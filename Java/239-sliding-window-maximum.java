/*
explanation: sliding window problem using concept of focused/out-of-focus window! The algorithm maintains current maximum and compares each next coming element (in-view) to its current stored maximum element! If this is higher then the current max element in focus changed. however after sometime it might happen that our greatest item go outside focus, so in that case we invalidate the maximum and recalculate it on that point! Repeating this over and over gives our solution!

testcase:
[1,3,-1,-3,5,3,6,7], k = 3 -> Works
Initially the window calculate over first three element, ie 1, 3, -1 and outputs 3 as max element now this is inserted to first position of returning array! after this the following loop steps are executed in order:

element in view: -3, element out of focus: 1, also current max=3 with index i=1
since current max is still in scope (element out of focus index(i=0) != current max index(i=1)) and since element in view(-3) < current max(3) therefore no change to current max is done!

after this:
eiv: 5, eos=3, cmax=3, cmaxindex=1 (pl. note: abbreviated, use common sense)
now since cmax < eiv therefore we set cmaxindex = i (equal to 4) and push the element to array (here 5)
... this continues and gives output for other similar items!

Time & Space Complexity: O(n^2 and O(n)): Time complexity is quadratic since two loops enclosed in one another is used in worst case (because the function getLagMax takes O(n) which is enclosed within another O(n) loop), also space complexity is linear since an array of almost n length is to be maintained throughout the program!
*/

class Solution {
    
    public int getLagMax(int[] nums, int k, int index){
        int max = nums[index];
        int maxdex = index;
        while(k > 0){
            // System.out.println("chc "+ nums[index]);
            if(nums[index] > max){
                maxdex = index;
            }
            max = Math.max(nums[index], max);
            index--;
            k--;
        }
        return maxdex;
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1) return nums;
        if(nums.length <= k){
            // Do a simple maximum if everything
            int max = -1000000;
            for(int i=0; i<nums.length; i++){
                max = Math.max(nums[i], max);
            }
            return new int[]{max};
        }
        
        int[] ret = new int[nums.length - k + 1];
        
        int currentLagWindowMax = getLagMax(nums, k, k-1);
        // System.out.println("max "+ currentLagWindowMax);
        ret[0] = nums[currentLagWindowMax];
        for(int i=k; i<nums.length; i++){
            if(nums[i] > nums[currentLagWindowMax]){
                // Recalculate max
                currentLagWindowMax = i;
            }
            int lastdrop = i - k;
            // System.out.println("ldro "+lastdrop);
            if(lastdrop == currentLagWindowMax){
                // Out of focus, recalculate
                // System.out.println("recalculate");
                currentLagWindowMax = getLagMax(nums, k, i);
            }
            ret[i-k+1] = nums[currentLagWindowMax];
            
            // System.out.println(i+" "+nums[i]+" "+currentLagWindowMax+" "+nums[currentLagWindowMax]);
        }
        
        return ret;
    }
}