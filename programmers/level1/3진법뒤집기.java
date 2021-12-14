import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String str = "";
        while(n>0) {
        	str = ((n%3)+"") + str;
        	n /= 3;
        }
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
        	st.push(str.charAt(i));
        }
        str = "";
        while(!st.isEmpty()) {
        	str+=st.pop();
        }
        
        int thr = 1;
        for(int i = str.length()-1; i >=0; i--) {
        	int k = str.charAt(i)-'0';
        	answer += k*thr;
        	thr*=3;
        }
        return answer;
    }
}
