import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < skill.length(); i++) {
        	list.add(skill.charAt(i));
        }
        
        
        for(String sk : skill_trees) {
        	int index = 0;
        	boolean flag = true;
        	
        	for(int i = 0; i < sk.length(); i++) {
        		char ch = sk.charAt(i);
        		
        		if(!list.contains(ch)) continue;
        		
        		if(ch != list.get(index)) {
        			flag = false;
        			break;
        		}
        		index++;
        	}
        	if(flag) answer++;
        }
        
        return answer;
    }
}
