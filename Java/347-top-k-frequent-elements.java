/*
explanation: top k frequent elements by first finding the frequency hashmap and converting it to treemap with frequency counts as key and the element as value added string! explained better in testcase:

testcase: [1,1,1,2,2,3] k=2 -> works
here the frequency map becomes 1 => 3, 2 => 2, 3 => 1, now the map is converted to another treemap with keys as 3, 2, 1 (the occurence) with values as 1, 2, 3. now the treemap is finally iterated and the maximum values are added to integer array.

Time & Space Complexity: O(n) & O(n): Since iteration over whole array is done therefore time complexity is O(n), also since hashmaps are used to store frequencies therefore space complexity is O(n) 
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0)+1);
        }
                
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
             System.out.println("K: " + entry.getKey() + ". V: " + entry.getValue());
        }

        TreeMap<Integer,String> map=new TreeMap<Integer,String>(Collections.reverseOrder());
        
        for (Map.Entry<Integer, Integer> mapElement : freq.entrySet()) {
            Integer key = mapElement.getKey();
            Integer value = mapElement.getValue();
            
            String s = map.get(value);
            if(s == null){
                map.put(value, ""+key);
            }
            else{
                map.put(value, s+" "+key);
            }
            // map.put(value, )
        }
        
        int[] ans = new int[k];
        int z = 0;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if(z >= k) break;
            String[] v = entry.getValue().split(" ");
            for (int i = 0; i < v.length && z<k; i++) {
                ans[z++] = Integer.valueOf(v[i]);
            }
        }

        
        return ans;
    }
}