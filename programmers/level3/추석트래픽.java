class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        
        for(int i = 0; i < lines.length; i++) {
        	lines[i] = lines[i].substring(11).replace(":", "").replace("s", "");
        	
        	int sec = Integer.valueOf(lines[i].substring(0,2))*3600 +
        			Integer.valueOf(lines[i].substring(2,4))*60+
        			Integer.valueOf(lines[i].substring(4,6));
        	
        	lines[i] = ""+sec+lines[i].substring(6);
        	
        }
        int[] count = new int[lines.length];
        for(int i = 0; i < lines.length; i++) {
        	String[] str = lines[i].split(" ");
        	
        	double end = Double.valueOf(str[0])+1;
        	
        	for(int j = i; j<lines.length; j++) {
        		str = lines[j].split(" ");
        		
        		double start = Double.valueOf(str[0]) - Double.valueOf(str[1]) + 0.001;
        		
        		if(end > start) 
        				count[i]++;
        	}
        }
        for(int c : count) {
        	answer = Math.max(answer, c);
        }
        
        return answer;
    }
}
