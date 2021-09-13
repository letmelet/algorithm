import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int turn = 1;
        int count = 1;
        char ch = words[0].charAt(0);
        Set<String> set = new HashSet<>();
        
        
        for(String word : words) {
        	if(word.charAt(0) != ch || !set.add(word)) {
        		return new int[] { count, turn};
        	}
        	
        	ch = word.charAt(word.length()-1);
        	count++;
        	if(count > n) {
        		turn++;
        		count = 1;
        	}
        }


        return new int[] {0, 0};
    }
}
