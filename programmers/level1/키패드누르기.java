class Solution {
    public String solution(int[] numbers, String hand) {
		String answer = "";
		
		int left = 10;
		int right = 12;
		
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] == 0) numbers[i] = 11;
			
			if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				answer += "L";
				left = numbers[i];
				continue;
			}
			if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				answer += "R";
				right = numbers[i];
				continue;
			}
			
			if(checkHand(left, right, numbers[i]) < 0) {
				answer += "L";
				left = numbers[i];
			}else if(checkHand(left, right, numbers[i]) > 0) {
				answer += "R";
				right = numbers[i];
			} else {
				if(hand.equals("left")) {
					answer += "L";
					left = numbers[i];
				}else {
					answer += "R";
					right = numbers[i];
				}
			}
		}
		
		
		return answer;
	}
	// 왼손이 가까우면 음수 오른손이 가까우면 양수 같으면 0
	public int checkHand(int l, int r, int target) {
	
		int l_distance = Math.abs(target-l)/3 + Math.abs(target-l)%3;
		int r_distance = Math.abs(target-r)/3 + Math.abs(target-r)%3;
		
		
		return l_distance - r_distance; 
	}
}
