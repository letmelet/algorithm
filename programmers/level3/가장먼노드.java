import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<List<Integer>> map = new ArrayList<>();
        for(int i = 0; i < n+1; i++) {
        	map.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i< edge.length; i++) {
        	map.get(edge[i][0]).add(edge[i][1]);
        	map.get(edge[i][1]).add(edge[i][0]);
        }
        
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        while(!que.isEmpty()) {
        	int size = que.size();
        	answer = 0;
        	for(int i = 0; i < size; i++) {
        		int num = que.poll();
        		answer++;
        		for(int v : map.get(num)) {
        			if(!visited[v]) {
        				que.offer(v);
        				visited[v] = true;
        			}
        		}
        		
        	}
        }
        return answer;
    }
}
