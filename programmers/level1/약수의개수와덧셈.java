class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++) {
        	if(chk(i)) {
        		answer += i;
        	}else {
        		answer -= i;
        	}
        }
        
        return answer;
    }
	public boolean chk(int n) {
		int count = 0;
		
		for(int i = 1; i <=n;i++) {
			if(n%i==0) count++;
		}
		
		if(count%2==0) {// 짝수일때
			return true;
		}else {// 홀수일때
			return false;
		}
	}
}
