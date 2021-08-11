import java.util.*;

class Solution {
   	int[][] dirs = {{-1, 0},{0, 1},{1, 0},{0, -1}};
	
	class Node{
		int val;
		int direction;
		int y;
		int x;
		
		Node(int v, int d, int y, int x){
			this.val = v;
			this.direction = d;
			this.y = y;
			this.x = x;
		}
	}
	
	public int solution(int[][] board) {
		int result = Integer.MAX_VALUE;
		int[] des = {board.length-1, board[0].length-1};
		Queue<Node> que = new LinkedList<>();
		for(int i = 0; i < 4; i++) {
			Node node = new Node(0, i, 0, 0);
			que.offer(node);
		}
		
		while(!que.isEmpty()) {
			Node temp = que.poll();
			if(temp.val > result) continue;
			if(temp.y == des[0] && temp.x == des[1]) {
				result = Math.min(result, temp.val);
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				int dy = temp.y + dirs[i][0];
				int dx = temp.x + dirs[i][1];
				
				if(dy >=0 && dx >= 0 && dy <board.length && dx < board[0].length && board[dy][dx] != 1) {
					int newVal = temp.val;
					if(temp.direction != i) {
						newVal += 500;
					}
                    newVal += 100;
                    
					if(board[dy][dx] == 0) {
						board[dy][dx] = newVal;
						que.offer(new Node(newVal, i, dy, dx));
					} else if(board[dy][dx] >= newVal) {
						board[dy][dx] = newVal;
						que.offer(new Node(newVal, i, dy, dx));
					}
				}
			}
		}
		
		return result;
	}
}
