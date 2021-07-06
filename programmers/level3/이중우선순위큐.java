import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        LinkedList<Integer> pq = new LinkedList<>();
        
        for(String s : operations) {
        	String[] opers = s.split(" ");
        	
        	if(opers[0].equals("I")) {
        		pq.offer(Integer.valueOf(opers[1]));
        		Collections.sort(pq, new Comparator<Integer>() {
        			@Override
        			public int compare(Integer o1, Integer o2) {
        				return o1 - o2;
        			}
        		});
        	}else {
        		if(opers[1].equals("1")) {
        			pq.pollLast();
        		}else {
        			pq.pollFirst();
        		}
        	}
        }
        
        if(pq.isEmpty()) {
        	return new int[] {0,0};
        }
        
        return new int[] {pq.peekLast(), pq.peekFirst()};
    }
}
