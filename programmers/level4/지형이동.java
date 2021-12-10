import java.util.*;

class Solution {
    int[][] dirs = {{-1,0}, {0,1},{1,0},{0,-1}};
	int count = 0;
	
	
	public int solution(int[][] land, int height) {
        int answer = 0;
        
        boolean[][] visited = new boolean[land.length][land.length];
        
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        int X = 0;
        int Y = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < land.length; i++) {
        	for(int j = 0; j < land.length; j++) {
        		if(land[i][j] < min) {
        			Y = i;
        			X = j;
        			min = land[i][j];
        		}
        	}
        }
        
        
        while(count < land.length*land.length) {
        	dfs(Y, X, height, land, visited, pq);
        	while(!pq.isEmpty()) {
        		int[] temp = pq.poll();
        		if(!visited[temp[0]][temp[1]]) {
        			Y = temp[0];
        			X = temp[1];
        			answer += temp[2];
        			break;
        		}
        	}
        	
        }
        
        
        return answer;
    }
	
	public void dfs(int y, int x, int height, int[][] land, boolean[][] visited, Queue<int[]> pq) {
		
		count++;
		visited[y][x] = true;
		
		while(!pq.isEmpty()) {
			if(visited[pq.peek()[0]][pq.peek()[1]]) pq.poll();
			else break;
		}
		
		for(int[] dir : dirs) {
			int dy = y+ dir[0];
			int dx = x+ dir[1];
			
			if(dy < 0 || dx < 0 || dy >= land.length || dx >= land.length) continue;
			if(visited[dy][dx]) continue;
			
			if(Math.abs(land[y][x] - land[dy][dx])<=height) {
				dfs(dy, dx, height, land, visited, pq);
			} else {
				pq.offer(new int[] {dy, dx, Math.abs(land[y][x] - land[dy][dx])});
			}
		}
		
	}
}
