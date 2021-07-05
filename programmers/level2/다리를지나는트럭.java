import java.util.*;

class Solution {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int wei = 0;
        Queue<Integer> que = new LinkedList<>();
        
        for(int truck : truck_weights) {
        	
        	while(true) {
        		if(que.isEmpty()) {
        			que.offer(truck);
        			wei += truck;
        			answer++;
        			break;
        		}
        		else if(que.size() == bridge_length) {
        			wei -= que.poll();
        		}
        		else {
        			if(weight < wei + truck) {
        				que.offer(0);
        				answer++;
        			}
        			else {
        				que.offer(truck);
        				wei += truck;
        				answer++;
        				break;
        			}
        		}
        	}
        }
        
        return answer + bridge_length;
    }
}
