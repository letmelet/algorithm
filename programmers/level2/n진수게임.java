class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int num = m*(t-1)+p;        
        int k = 0;        
        String str = "";
        int dig = 0;        
        
        while(str.length()<num) {
        	int number = dig;
        	String s = "";
        	if(number == 0) {
        		str += number;
        	}else {
        		while(number>0) {
        			if(number%n < 10) {
        				s = number%n + s;
        			}else {
        				s = (char)((number%n)-10+'A') + s;
        			}
        			number = number/n;
        		}
        	}
        	str += s;
        	dig++;
        }
        for(int i =p-1; i < num; i+=m) {
        	answer += str.charAt(i);
        }        
        return answer;
    }
}
