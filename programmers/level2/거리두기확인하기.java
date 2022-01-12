import java.util.*;

class Solution {
    static int[][] dirs = {{0,-1},{1,0},{0,1},{-1,0}};
	static boolean[][] chk;
	static int index = 0;
	class Point {
		int x;
		int y;
		int count;
		
		Point(int x, int y, int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(String[] place : places) {
        	char[][] map = new char[5][5];
        	chk = new boolean[5][5];
        	boolean noFlag = false;
        	
        	for(int i = 0; i < 5; i++) {
        		for(int j = 0; j < 5; j++) {
        			map[i][j] = place[i].charAt(j);        			
        		}
        	}
        	for(int y = 0; y < 5; y++) {
        		for(int x = 0; x < 5; x++) {
        			if(map[y][x] == 'P') {
        				chk[y][x] = true;
        				if(!bfs(map, y, x)) {
        					noFlag = true;
        				}
        			}
        			if(noFlag) break;
        		}
        		if(noFlag) break;
        	}
        	if(noFlag) {
        		answer[index++] = 0;
        	} else {
        		answer[index++] = 1;
        	}
        }
        return answer;
    }
	
	boolean bfs(char[][] map, int y, int x) {
		
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(x, y, 0));
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			for(int[] dir : dirs) {
				int dx = p.x + dir[0];
				int dy = p.y + dir[1];
				int count = p.count;
				
				if(dy < 0 || dx <0 || dy >= 5 || dx >= 5 || map[dy][dx] == 'X' || chk[dy][dx]) continue;
				if(count >= 2) continue;
				
				if(map[dy][dx] == 'P') {
					return false;
				}
				que.offer(new Point(dx, dy, count+1));
			}
		}
		return true;
	}
}
