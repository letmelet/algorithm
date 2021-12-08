class Solution {
    public int solution(int[] cookie) {
		int answer = 0;
		int size = cookie.length;

		for (int i = 0; i < size - 1; i++) {
			int l = i;
			int r = i + 1;

			int lSum = cookie[l];
			int rSum = cookie[r];

			while (l>=0 && r<size) {
				if(lSum == rSum) {
					answer = Math.max(answer, lSum);
					l--;
					r++;
					if(l >= 0 && r <= size-1) {
                        lSum += cookie[l];
					    rSum += cookie[r];
                    }
					
					
				}else if(lSum > rSum) {
					if(r < size-1) {
						r++;
						rSum += cookie[r];
					} else break;
				}else {
					if(l>0) {
						l--;
						lSum+= cookie[l];
					}else break;
				}
				
			}
		}

		return answer;
	}
}
