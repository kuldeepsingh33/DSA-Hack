/*
explanation: intersection of two arrays by maintaining a hashmap of frequencies of element, first the programs assigns maxarray and minarray according to size of nums1 and nums2 and according iterate over max array to build frequency hasmap list, after the program iterates over min array and reduces the counter while adding the key to result list

testcase:
[1,2,2,1]
[2,2]
In this case the program loops over first array and builds a hashmap list of 1 -> 2, 2 -> 2
also while iterating over to 2nd array it checks the element for presence of 2 and reduces the count by 1, therefore by the end of operation hashmap becomes 1->2, 2->0 and result list becomes 2, 2

Time & Space Complexity: O(n) and O(n) respectively: Since a linear loop is used in program which running over n elements gives time complexity of O(n), also a map is used to store the frequency distribution which in worst case can occupy n elements, so space complexity is O(n)
*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1len = nums1.length;
        int n2len = nums2.length;
        int[] maxarray;
        int[] minarray;
        if(n1len > n2len){
            maxarray = nums1;
            minarray = nums2;
        }
        else{
            maxarray = nums2;
            minarray = nums1;
        }
                
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for(int i=0; i<maxarray.length; i++){
            int e = maxarray[i];
            Integer value = numbers.get(e);
            if(value == null){
                numbers.put(e, 1);
            }
            else{
                numbers.put(e, ++value);
            }
        }
        
        List<Integer> soln = new ArrayList<>();

        for(int i=0; i<minarray.length; i++){
            int e = minarray[i];
            Integer value = numbers.get(e);
            if(value != null && value > 0){
                System.out.println(e+" "+value);
                numbers.put(e, --value);
                soln.add(e);
            }
        }
        
        int[] array = new int[soln.size()];
        int i=0;
        for(Integer el : soln){
            array[i++] = el.intValue();
        }
        return array;
    }
}