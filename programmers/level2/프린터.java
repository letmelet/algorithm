import java.util.*;

class Solution {
		class printer{
		int prior;
		int index;
		
		printer(int p, int i){
			this.prior = p;
			this.index = i;
		}
	}
	
	public int solution(int[] priorities, int location) {
        int answer = 1;
        
        Queue<printer> que = new LinkedList<>();
        boolean flag = false;
        for(int i = 0; i < priorities.length; i++) {
        	que.offer(new printer(priorities[i], i));
        }
        
        while(!que.isEmpty()) {
        	printer p = que.peek();
        	flag = false;
        	
        	for(printer chk : que) {
        		if(chk.prior > p.prior) {
        			que.offer(que.poll());
        			flag = true;
        			break;
        		}
        	}
        	if(flag) continue;
        	
        	if(p.index == location) {
        		return answer;
        	}
        	
        	que.poll();
        	answer++;
        }
        
        return answer;
    }
}
