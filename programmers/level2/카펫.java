class Solution {
   	public int[] solution(int brown, int yellow) {
		
		int[] answer = {};
		int sum = brown + yellow;
		
		for(int i = 3; i <= sum; i++) {
			if(sum % i == 0) {
				int wid = sum / i;
				int hei = sum / wid;
				
				int yelWid = wid-2;
				int yelHei = hei-2;
				
				if(yelWid*yelHei == yellow && wid >= hei) {
					return new int[] {wid, hei};
				}
			}
		}
		return answer;
	}
}
