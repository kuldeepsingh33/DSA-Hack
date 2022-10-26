/*
explanation: simple compare version numbers by converting the string version to array of integer version numbers! uses java built-in split and convert it by splitting on "." character! after doing this we convert each version number to integers and finally checks step-by-step from left to right each version in two arrays!

testcase:
"1.01"
"1.0.0" -> Works
After splitting+converting we get arrays as [1, 1] & [1, 0, 0], now comparing each element from two arrays sequentially (or default 0 if index outside bound).
*/
class Solution {
    public int[] process(String version){
        String[] tokens=version.split("\\.");
        int size = tokens.length;
        int [] arr = new int [size];
        for(int i=0; i<size; i++) {
         arr[i] = Integer.parseInt(tokens[i]);
        }
        return arr;
    }
    
    public int getOrDefault(int[] arr, int index){
        if(index >= arr.length) return 0;
        else return arr[index];
    }
    
    public int compareVersion(String version1, String version2) {
        int[] v1 = process(version1);
        int[] v2 = process(version2);
        
        int mlength = Math.max(v1.length, v2.length);
        for(int i=0; i<mlength; i++){
            int ver1 = getOrDefault(v1, i);
            int ver2 = getOrDefault(v2, i);
            
            if(ver1 > ver2) return 1;
            else if(ver1 < ver2) return -1;
        }
  
        
        // System.out.println(Arrays.toString(v1));
        // System.out.println(Arrays.toString(v2));
        
        return 0;
    }
}