import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        int[] parent = new int[n];
        
        for(int i = 0; i < n; i++) {
        	parent[i] = i;
        }
        
        Arrays.sort(costs, (a,b) -> a[2] - b[2]);

        for(int[] cost : costs) {
        	int n1 = cost[0];
        	int n2 = cost[1];
        	
        	if(!checkP(n1, n2, parent)) {
        		unionP(n1, n2, parent);	
            	answer += cost[2];
        	}
        }
        
        return answer;
    }
	
	public boolean checkP(int n1, int n2, int[] parent) {
		n1 = getP(n1, parent);
		n2 = getP(n2, parent);
		
		return n1==n2;
	}
	
	public void unionP(int n1, int n2, int[] parent) {
		int p1 = getP(n1, parent);
		int p2 = getP(n2, parent);
		
		if(p1 > p2) {
			parent[p1] = p2;
		}else {
			parent[p2] = p1;
		}
	}
	
	public int getP(int n1, int[] parent) {
		if(parent[n1] == n1) return n1;
		
		return getP(parent[n1], parent);
	}
}
