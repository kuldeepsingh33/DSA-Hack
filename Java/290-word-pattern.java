/*
explanation: uses hashmap to put key(pattern's character) into map if not found, but if it is found then uses the same key to get the string, if value of this map(key) is not equal to the one provided then return false (ie pattern not match), otherwise continue.

testcases:
"abba"
"dog cat cat dog"
Works!
*/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map=new HashMap<Character,String>();
        String[] splited = s.split(" ");
        if(pattern.length() != splited.length) return false;
        for(int i=0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            String st = splited[i];
            
            String m = map.get(c);
            if(m == null){
                if(map.containsValue(st)) return false;
                map.put(c, st);
            }
            else if(!m.equals(st)){
                System.out.println(m +" "+st+" maaaa ");
                return false;
            }
            System.out.println(c +" "+st);
        }
        return true;
    }
}