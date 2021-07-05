import java.util.*;

class Solution {
	public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> st = new Stack<>();
        
        st.push(0);
        
        for(int i = 1; i < prices.length; i++) {
        	if(prices[st.peek()] <= prices[i]) {
        		st.push(i);
        		continue;
        	}
        	
        	while(true) {
        		if(st.isEmpty() || prices[st.peek()] <= prices[i]) {
        			break;
        		}
        		
        		answer[st.peek()] = i - st.peek();
        		st.pop();
        	}
        	
        	st.push(i);
        }
        
        while(!st.isEmpty()) {
        	answer[st.peek()] = (answer.length - 1) - st.peek();
    		st.pop();
        }
        
        
        return answer;
    }
}
