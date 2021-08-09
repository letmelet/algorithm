import java.util.*;

class Solution {
	public int[] solution (String[] gems) {
		int[] answer = {0, gems.length};
		
		Set<String> set = new HashSet<>();
		
		for(String gem : gems) {
			set.add(gem);
		}
		Map<String, Integer> map = new HashMap<>();
		
		int l = 0;
		int r = 0;
		
		map.put(gems[l], 1);
		
		while(l>=0 && l <gems.length && r>=0 && r < gems.length && l<=r) {
			if(map.size() == set.size()) {				
				if((r-l) < answer[1]-answer[0]) {
					answer[0] = l;
					answer[1] = r;
				}
				else if((r-l) == answer[1]-answer[0]) {
					if(l < answer[0]) {
						answer[0] = l;
						answer[1] = r;
					}
				}
				map.put(gems[l], map.get(gems[l])-1);
				if(map.get(gems[l])<=0) {
					map.remove(gems[l]);
				}
				l++;
			}
			
			if(map.size() < set.size()) {
				r++;
				if(r < gems.length) {
					map.put(gems[r], map.getOrDefault(gems[r], 0)+1);					
				}
			}
		}
		
		answer[0]++;
		answer[1]++;
		return answer;
	}
}
