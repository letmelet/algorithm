class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        String dart = "";
        for(int i = 0; i < dartResult.length(); i++) {
        	char ch = dartResult.charAt(i);
        	dart += ch;
        	if(ch == 'S' || ch== 'D' || ch == 'T') {
        		if(i+1<dartResult.length()) {
        			if(dartResult.charAt(i+1)>='0' && dartResult.charAt(i+1)<='9') {
        				dart += " ";
        			}
        		}
        	}
        }
        int index = 0;
        int i = 0;
        int[] arr = new int[3];
        String num = "";
        while(index < dart.length()) {
        	char ch = dart.charAt(index);
        	if(ch >='0' && ch<='9') {
        		num+=ch;    
        	}else {
        		if(num.length() != 0) {
        			arr[i] = Integer.valueOf(num);
        			num = "";        			
        		}
        		if(ch == 'D') {
        			arr[i] = arr[i]*arr[i];
        		}
        		if(ch == 'T') {
        			arr[i] = arr[i]*arr[i]*arr[i];
        		}
        		
        		if(ch == '*') {
        			if(i != 0) {
        				arr[i-1] *= 2;        				
        			}
        			arr[i] *= 2;
        			i++;
        		}
        		if(ch == '#') {
        			arr[i] -= arr[i]*2;
        			i++;
        		}
        		if(ch == ' ') {
        			i++;
        		}
        	}
        	index++;
        }
        for(int n : arr) {
        	answer += n;
        }
        return answer;
    }
}
