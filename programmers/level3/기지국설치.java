class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index = 1;
        for(int i = 0; i < stations.length; i++) {
        	while(true) {
        		if(stations[i]-w<= index) {
            		index = stations[i]+w+1;
                    break;
            	}else {
            		index += 2*w +1;
            		answer++;
            	}
        	}
        }
        
        while(index<=n) {
        	index += 2*w +1;
    		answer++;
        }
        return answer;
    }
}
