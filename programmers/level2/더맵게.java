import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Integer> pq = new PriorityQueue<>();
        
        for(int sc : scoville) {
        	pq.offer(sc);
        }
        
        
        while(pq.peek() < K) {
        	
        	if(pq.size() <=1) {
        		return -1;
        	}
        	int n1 = pq.poll();
        	int n2 = pq.poll();
        	
        	int newSc = n1 + n2*2;
        	
        	pq.offer(newSc);
        	answer++;
        }
        
        return answer;
    }
}
