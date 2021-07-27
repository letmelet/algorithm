import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        int mid = 0;
        int count = 0;
        int prev = 0;
        while(left<=right) {
        	mid = (left+right)/2;
        	count = 0;
        	prev = 0;
        	
        	for(int i = 0; i < rocks.length; i++) {
        		if(rocks[i] - prev < mid) {
        			count++;
        			if(count > n) break;
        		}else {
        			prev = rocks[i];
        		}
        	}
        	
        	if(distance - rocks[rocks.length-1]< mid) count++;
        	
        	if(count > n) {
        		right = mid -1;
        	}else {
        		left = mid +1;
        		answer = Math.max(answer, mid);
        	}
        	
        }
        
        return answer;
    }
}
