package programmers;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
	
		Solution sol = new Solution();
		
//		System.out.println(sol.solution(participant, completion));
		
	}
	
	
}

//class Solution {
//	public String solution(String[] participant, String[] completion) {
//		String answer = "";
//		
//		Map<String, Integer> map = new HashMap<>();
//		for(String part : participant) {
//			map.put(part, map.getOrDefault(part, 0) +1 );
//		}
//		for(String com : completion) {
//			map.put(com, map.get(com)-1);
//		}
//		
//		for(String key : map.keySet()) {
//			if(map.get(key)!=0) {
//				answer = key;
//			}
//		}
//		
//		return answer;
//	}
//}
//class Solution {
//	public String solution(String[] participant, String[] completion) {
//		
//		Arrays.sort(participant);
//		Arrays.sort(completion);
//		
//		int i;
//
//		for(i = 0; i < completion.length; i++) {
//			if(!completion[i].equals(participant[i])) {
//				return participant[i]
//			}
//		}
//		
//		
//		
//		
//		return participant[i];
//	}
//}
