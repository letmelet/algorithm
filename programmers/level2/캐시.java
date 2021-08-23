import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> que = new LinkedList<>();
        
        if(cacheSize == 0) {
        	return cities.length*5;
        }
        
        for(int i = 0; i < cities.length; i++) {
        	String city = cities[i].toUpperCase();
        	
        	if(!que.isEmpty() && que.contains(city)) {
        		que.remove(city);
        		que.offer(city);
        		answer += 1;
        		continue;
        	}
        	answer += 5;
        	que.offer(city);
        	if(que.size() > cacheSize) {
        		que.poll();
        	}
        }
        return answer;
    }
}
