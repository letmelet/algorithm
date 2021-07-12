import java.util.*;

class Solution {
    public String solution(String number, int k) {
		// 목표 : 첫째자리수가 가장큰수가 될때( 뺄수 있는 수를 뺀 범위내에서) 뽑고, 범위내에서 나머지 반복
		// 스택으로 뺄수있는 수를 체크하며 첫째수가 제일 크게되게 찾음
		Stack<Character> st = new Stack<>();
		int len = number.length()-k;
		
		for(int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			
			while(!st.isEmpty() && st.peek() < c) {
				if(k <=0) break;
				st.pop();
				k--;
			}
			
			st.push(c);
		}
		String str = "";
		for(int i = 0; i < len; i++) {
			str += st.get(i);
		}

		return str;
	}
}
