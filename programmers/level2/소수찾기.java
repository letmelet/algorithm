import java.util.*;
class Solution {
   Set<Integer> result;
	boolean[] visited;
	public int solution(String numbers) {
		int answer = 0;
		result = new HashSet<>();
		
		List<Character> cur = new ArrayList<>();
		visited = new boolean[numbers.length()];
		for(int i = 1; i <= numbers.length(); i++) {
			dfs(0, cur, numbers, i);
		}
		
		for(int num : result) {
			if(isPrime(num)) {
				answer++;
			}
		}
		

		
		return answer;
	}
	
	public void dfs(int index, List<Character> cur, String numbers, int len) {
		if(index == len) {
			String str = "";
			for(char s : cur) {
				str+= s;
			}
			result.add(Integer.valueOf(str));
			return;
		}
		
		for(int i = 0; i < numbers.length(); i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			cur.add(numbers.charAt(i));
			dfs(index+1, cur, numbers, len);
			visited[i] = false;
			cur.remove(cur.size()-1);
		}
	}
	
	public boolean isPrime(int num) {
		if(num == 0 || num == 1) return false;
		
		for(int i = 2; i <num ; i++) {
			if(num%i == 0) return false;
		}
		
		return true;
	}
}
