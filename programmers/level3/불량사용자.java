import java.util.*;

class Solution {
   	boolean[] visited;
	int result;
	Set<List<Integer>> set;
	
	public int solution(String[] user_id, String[] banned_id) {
		set = new HashSet<>();
		List<List<Integer>> list = new ArrayList<>();
		
		for(int i = 0; i < banned_id.length; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < banned_id.length; i++) {
			for(int j = 0; j < user_id.length; j++) {
				if(isValid(banned_id[i], user_id[j])) {
					list.get(i).add(j);
				}
			}
		}
		result = 0;
		
		visited = new boolean[user_id.length];
		
		dfs(list, 0, banned_id.length);
		
		return result;
	}
	public void dfs(List<List<Integer>> list, int index, int N) {
		if(index == N) {
			List<Integer> last = new ArrayList<>();
			for(int i = 0; i <visited.length; i++) {
				if(visited[i]) last.add(1);
				else last.add(0);
			}
			if(set.add(last)) {
				result++;
			}
			return;
		}
		
		for(int i = 0; i < list.get(index).size(); i++) {
			if(visited[list.get(index).get(i)]) continue;

			visited[list.get(index).get(i)] = true;
			
			dfs(list, index+1, N);
			
			visited[list.get(index).get(i)] = false;
		}
	}
	public boolean isValid(String ban, String user) {
		if(ban.length() != user.length()) return false;
		
		for(int i = 0; i < ban.length(); i++) {
			if(ban.charAt(i) == '*') continue;
			if(ban.charAt(i) != user.charAt(i)) return false;
		}
		return true;
	}
}
