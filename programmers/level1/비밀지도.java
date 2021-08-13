class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
        	char[] ch = new char[n];
        	
        	int sum1 = arr1[i];
        	int sum2 = arr2[i];
        	for(int j = n-1; j >= 0 ; j--) {
        		if(sum1%2 == 1 || sum2 %2 == 1) {
        			ch[j] = '#';
        			
        		}else {
        			ch[j] = ' ';
        		}
        		sum1 /= 2;
    			sum2 /= 2;
        	}
        	answer[i] = String.valueOf(ch);
        }
        
        return answer;
    }
}
