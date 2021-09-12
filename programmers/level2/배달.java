import java.util.*;

class Solution {
    class Node{
		int index;
		int time;
		
		Node(int i, int t){
			index = i;
			time = t;
		}
	}
	
	public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        int[][] time = new int[N+1][N+1];
        
        Queue<Node> que = new LinkedList<>();
        
        for(int i = 0; i < time.length; i++) {
        	Arrays.fill(time[i], Integer.MAX_VALUE);
        }
        
        for(int[] r : road) {
        	time[r[0]][r[1]] = Math.min(time[r[0]][r[1]], r[2]);
        	time[r[1]][r[0]] = Math.min(time[r[0]][r[1]], r[2]);
        }

        
        que.offer(new Node(1, 0));
        
        while(!que.isEmpty()) {
        	Node n = que.poll();
        	
        	if(n.time > K) continue;
        	
        	if(time[1][n.index] < n.time) continue;
        	time[1][n.index] = n.time;
        	
        	for(int i = 1; i <= N; i++) {
        		if(n.index == i) continue;
        		
        		if(time[n.index][i] == Integer.MAX_VALUE) continue;
        		
        		que.offer(new Node(i, n.time+time[n.index][i]));
        	}
        }

        for(int i = 1; i <= N; i++) {
    		if(time[1][i] <= K) answer++;
    	}
        
        return answer;
    }
}
