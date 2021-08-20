class Solution {
    int[][] dirs = {{0,1},{1,1},{1,0}};
	boolean[][] visited;
	public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        visited = new boolean[m][n];
        char[][] map = new char[m][n];
        char[][] change = new char[m][n];
        for(int i = 0; i <n; i++) {
    		for(int j = m-1; j >= 0; j--) {
    			change[j][i] = board[j].charAt(i);
    		}
    	}
        
        while(true) {
        	int count = 0;
        	map = new char[m][n];        	
        	
        	for(int i = 0; i <n; i++) {
        		int y = m-1;
        		for(int j = m-1; j >= 0; j--) {
        			if(visited[j][i]) continue;
        			map[y][i] = change[j][i]; 
        			y--;
        		}
        	}
        	for(int i = 0; i < m; i++) {
        		for(int j = 0; j < n ; j++) {
        			change[i][j] = map[i][j];
        		}
        	}
        	visited = new boolean[m][n];
        	
        	for(int i = 0; i < m-1; i++) {
        		for(int j = 0; j < n-1; j++) {
        			char ch = map[i][j];
        			boolean flag = true;
        			if(ch == '\u0000') continue;
        			
        			for(int[] dir : dirs) {
        				int dy = i+dir[0];
        				int dx = j+dir[1];
        				
        				if(map[dy][dx]!=ch) {
        					flag = false;
        					break;
        				}
        			}
        			if(flag) {
        				visited[i][j] = true;
        				for(int[] dir : dirs) {
        					int dy = i+dir[0];
        					int dx = j+dir[1];
        					
        					visited[dy][dx] = true;
        				}
        			}
        		}
        	}
        	
        	for(int i = 0; i < visited.length; i++) {
        		for(int j = 0; j < visited[i].length ; j++) {
        			if(visited[i][j]) {
        				count++;
        			}
        		}
        	}
        	if(count == 0) break;
        	answer += count;
        }
        return answer;
    }
}
