class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] map = new int[n][m];
        map[0][0] = 1;
        
        for(int i = 0; i < puddles.length; i++) {
        		map[puddles[i][1]-1][puddles[i][0]-1] = -1;          		
        }
        
        for(int y = 0; y < map.length; y++) {
        	for(int x = 0; x < map[y].length; x++) {
        		if(map[y][x] == -1) {
        			map[y][x] = 0;
        			continue;
        		}
        		
        		if(y!=0) {
        			map[y][x] += map[y-1][x]%1000000007;
        		}
        		if(x!=0) {
        			map[y][x] += map[y][x-1]%1000000007;
        		}
        	}
        }
        
        return map[n-1][m-1]%1000000007;
    }
}
