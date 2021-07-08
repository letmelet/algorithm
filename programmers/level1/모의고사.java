import java.util.*;

class Solution {
    public int[] solution(int[] ans) {
       int[][] mathman = {
				{1,2,3,4,5},
				{2,1,2,3,2,4,2,5},
				{3,3,1,1,2,2,4,4,5,5}
		}; 
		
		int[] res = new int[3];
		
		for(int i = 0; i< ans.length; i++) {
			for(int j = 0; j < res.length; j++) {
				if(ans[i] == mathman[j][i%mathman[j].length]) res[j]++;
			}
		}
		
		int max = Math.max(res[0], Math.max(res[1], res[2]));
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < res.length; i++) {
			if(max == res[i]) list.add(i+1);
		}
		
		int[] result = new int[list.size()];
		
		for(int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
    }
}
