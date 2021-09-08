import java.util.*;

class Solution {
    	public int solution(int[] nums) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        
        dfs(nums, list, cur, 0);
        
        for(int num : list) {
        	if(isPrime(num)) {
        		answer++;
        	}
        }
        return answer;
    }
	
	public void dfs(int[] nums, List<Integer> list, List<Integer> cur, int index) {
		if(index == 3) {
			int sum = 0;
			for(int num : cur) {
				sum += nums[num];
			}
			list.add(sum);
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(cur.contains(i)) continue;
			if(index != 0) {
				if(cur.get(cur.size()-1) > i) continue;
			}
			cur.add(i);
			
			dfs(nums, list, cur, index+1);
			
			cur.remove(cur.size()-1);
			
		}
	}
	public boolean isPrime(int num) {
		
		for(int i = 2; i <= (int)Math.sqrt(num); i++) {
			if(num%i == 0) return false;
		}
		
		return true;
	}
}
