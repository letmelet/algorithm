import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        return binarySearch(n, times);
    }
	
	public long binarySearch(int n, int[] times) {
		long left = 0;
		long right = Long.MAX_VALUE;
		long mid = 0;
		long sum = 0;
		long result = Long.MAX_VALUE;
		while(left<=right) {
			mid = (left + right)/2;
			sum = 0;
			for(int i = 0; i < times.length; i++) {
				sum += mid/times[i];
				if(sum >= n) break;
			}
			if(sum >= n) {
				right = mid-1;
				result = Math.min(result, mid);
				System.out.println(result);
			}else {
				left = mid+1;
			}
		}
		return result;
	}
}
