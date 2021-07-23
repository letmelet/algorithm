import java.util.*;

class Solution {
   boolean[] visited;
	List<String> ans;
	
	public String[] solution(String[][] tickets) {
		
		visited = new boolean[tickets.length];
		ans = new ArrayList<>();
		
		dfs(0, tickets,"ICN", "ICN");
		Collections.sort(ans);
		String[] result = ans.get(0).split(" ");
		return result;
	}
	
	public void dfs(int index, String[][] tickets, String cur, String sum) {
		if(index == tickets.length) {
			ans.add(sum);
			return;
		}
		
		for(int i = 0; i < tickets.length; i++) {
			if(visited[i]) continue;
			if(!cur.equals(tickets[i][0])) continue;
			
			visited[i] = true;
			dfs(index+1, tickets, tickets[i][1], sum + " " + tickets[i][1]);
			visited[i] = false;
		}
	}
}
