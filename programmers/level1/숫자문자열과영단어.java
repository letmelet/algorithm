import java.util.*;

class Solution {
    public int solution(String s) {
        String res = "";
        Map<String, String> map = new HashMap<>();
        
        map.put("0", "0");
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
        map.put("6", "6");
        map.put("7", "7");
        map.put("8", "8");
        map.put("9", "9");
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        String str = "";
        
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	str += c;
        	
        	if(map.containsKey(str)) {
        		res += map.get(str);
        		str = "";
        	}
        }
        
        return Integer.valueOf(res);
    }
}
