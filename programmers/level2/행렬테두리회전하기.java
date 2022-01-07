class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] map = new int[rows+1][columns+1];
        
        int num = 1;
        for(int i = 1; i < map.length; i++) {
        	for(int j = 1; j < map[i].length; j++) {
        		map[i][j] = num++;
        	}
        }
        
        for(int r = 0; r < queries.length; r++) {
        	int min = 10001;
        	int before = 0;
        	int temp = 0;
        	int y1 = queries[r][0];
        	int y2 = queries[r][2];
        	int x1 = queries[r][1];
        	int x2 = queries[r][3];
        	//상
        	for(int x = x1; x < x2; x++){
        		temp = map[y1][x];
        		map[y1][x] = before;
        		before = temp;
        		min = Math.min(before, min);
        	}
        	
        	//우
        	for(int y = y1; y < y2; y++) {
        		temp = map[y][x2];
        		map[y][x2] = before;
        		before = temp;
        		min = Math.min(before, min);
        	}
        	//하
        	for(int x = x2; x > x1; x--) {
        		temp = map[y2][x];
        		map[y2][x] = before;
        		before = temp;
        		min = Math.min(before, min);
        	}
        	
        	//좌
        	for(int y = y2; y > y1; y--) {
        		temp = map[y][x1];
        		map[y][x1] = before;
        		before = temp;
        		min = Math.min(before, min);
        	}
        	map[y1][x1] = before;
        	answer[r] = min;
        }
        
        
        return answer;
    }
}
