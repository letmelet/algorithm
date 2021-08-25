import java.util.*;
class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        char ch = 'A';
        int num = 1;
        for(int i = 0; i < 26; i++) {
        	map.put(ch++ +"", num++);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < msg.length(); i++) {
        	String str = msg.charAt(i)+"";
        	
        	if(i == msg.length()-1) {
        		list.add(map.get(str));
        		break;
        	}
        	for(int j = i+1; j < msg.length(); j++) {
        		if(map.containsKey(str+msg.charAt(j))) {
        			str += msg.charAt(j);
        			
        			if(j == msg.length()-1) {
        				list.add(map.get(str));
        				int[] answer = new int[list.size()];
        				
        				for(int k = 0; k < answer.length; k++) {
        					answer[k] = list.get(k);
        				}
        				return answer;
        			}
        		}else {
        			list.add(map.get(str));
        			str += msg.charAt(j);
        			map.put(str, num++);
        			i = j-1;
        			break;
        		}
        	}
        }
        int[] answer = new int[list.size()];
		
		for(int k = 0; k < answer.length; k++) {
			answer[k] = list.get(k);
		}
        return answer;
    }
}
