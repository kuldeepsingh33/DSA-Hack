/*
explanation: Solving the problem using modified version of Moore's voting algorithm. the problem is solved by having two counts for two different nums and applying the algorithm.

testcase: [1] -> Works

Time & Space Complexity: O(n) and O(1)
Since a linear scan is required, the time complexity is O(n) and whereas since few extra variables are used, the space complexity is O(1).
*/
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int m1 = Integer.MIN_VALUE;
        int m2 = Integer.MAX_VALUE;
        
        List<Integer> r = new ArrayList<Integer>();
        
        for(int i=0; i<nums.length; i++){
            int element = nums[i];
            
            if(element == m1){
                count1++;
            }
            else if(element == m2){
                count2++;
            }
            else if(count1==0){
                m1 = element;
                count1++;
            }
            else if(count2==0){
                m2 = element;
                count2++;
            }
            else{
                count1--;
                count2--;
            }
            
        }
        
        System.out.println(m1+" "+m2);
        int c = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == m1){
                c++;
            }
        }
        if(c > nums.length / 3){
            r.add(m1);
        }
        
        c = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == m2){
                c++;
            }
        }
        if(c > nums.length / 3){
            if(m1!=m2)
                r.add(m2);
        }
        
        return r;
    }
}