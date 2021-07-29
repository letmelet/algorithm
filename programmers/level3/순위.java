import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
		int answer = 0;

		int INF = 987654321;

		int[][] res = new int[n + 1][n + 1];
		for (int[] r : res) {
			Arrays.fill(r, INF);
		}

		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				if (i == j)
					res[i][j] = 0;
			}
		}

		for (int[] num : results) {
			res[num[0]][num[1]] = 1;
		}

		for (int k = 1; k < n + 1; k++) {
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					if (res[i][j] > res[i][k] + res[k][j]) {
						res[i][j] = res[i][k] + res[k][j];
					}
				}
			}
		}

		boolean[] flag = new boolean[n + 1];
		Arrays.fill(flag, true);

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if(i == j) continue;
				if(res[i][j] == INF && res[j][i] == INF) {
					flag[i] = false;
					break;
				}
			}
		}
		
		for(int i = 1; i < n+1; i++) {
			if(flag[i]) answer++;
		}

		return answer;
	}
}
