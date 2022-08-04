import java.util.*; 

class Solution {
    	
	static List<List<Integer>> map;
	static int[] before;
	static int[] after;
	static boolean[] visited;

	public static boolean solution(int n, int[][] path, int[][] order) {
		map = new ArrayList<>();
		before = new int[n];
		after = new int[n];
		visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			map.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < path.length; i++) {
			map.get(path[i][0]).add(path[i][1]);
			map.get(path[i][1]).add(path[i][0]);
		}
		
		for(int i = 0; i < order.length; i++) {
			before[order[i][1]] = order[i][0];
		}
		if(before[0] != 0) return false;
		
		Queue<Integer> que = new LinkedList<>();
		
		visited[0] = true;
		
		for(int i : map.get(0)) {
			que.add(i);
		}
		
		while(!que.isEmpty()) {
			int index = que.poll();
			
			if(visited[index]) continue;
			
			if(!visited[before[index]]) {
				after[before[index]] = index;
				continue;
			}
			
			visited[index] = true;
			
			for(int i : map.get(index)) {
				que.offer(i);
			}
			if(!visited[after[index]])
				que.add(after[index]);
		}
		
		for(boolean i : visited) {
			if(!i) return false;
		}
		
		return true;
	}
}
