class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int result = 0;
		
		int[] cl = new int[n];
		
		for(int num : lost) {
			cl[num-1]--;
		}
		
		for(int num : reserve) {
			cl[num-1]++;
		}
		
		for(int i = 0; i < cl.length; i++) {
			if(cl[i] == -1) {
				if(i-1 >= 0 && cl[i-1] == 1) {
					cl[i-1]--;
					cl[i]++;
					continue;
				}
				if(i+1 < n && cl[i+1] == 1) {
					cl[i+1]--;
					cl[i]++;					
				}
			}
		}
		
		for(int num : cl) {
			if(num != -1) result++;
		}
		
		return result;
	}
}
