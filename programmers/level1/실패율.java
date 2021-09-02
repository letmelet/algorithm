import java.util.*;
class Solution {
    class st{
		int stage;
		double fail;
		
		st(int s, double f){
			stage = s;
			fail = f;
		}
	}
	
	public int[] solution(int N, int[] stages) {
        
        Arrays.sort(stages);
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 1; i <= N; i++) {
        	map.put(i, 0);
        }
        
        for(int i = 0; i < stages.length; i++) {
        	map.put(stages[i], map.getOrDefault(stages[i], 0)+1);
        } 
        
        
        List<st> list = new ArrayList<>();
        
        int num = stages.length;
        for(int i = 1; i <= N; i++) {
        	Double failure = (double)map.get(i)/num;
            if(map.get(i)==0) {
        		failure = 0.0;
        	}
        	list.add(new st(i, failure));
        	num -= map.get(i);
        }
        
        
        Collections.sort(list, new Comparator<st>() {
        	@Override
        	public int compare(st o1, st o2) {
        		if(o2.fail == o1.fail) {
        			return o1.stage - o2.stage;
        		}
        		return o2.fail>o1.fail? 1 : -1;
        	}
        });
       
        
        int[] answer = new int[N];
        
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = list.get(i).stage;
        }
        
        return answer;
    }
}
