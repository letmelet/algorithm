import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        Arrays.sort(timetable);
        int[] now = new int[2];
        now[0] = 9;
        now[1] = 0;
        
        List<int[]> p = new ArrayList<>();
        for(String s : timetable) {
        	int hour = Integer.valueOf(s.substring(0,2));
        	int min = Integer.valueOf(s.substring(3));
        	
        	p.add(new int[] {hour, min});
        }
        int[][] bus = new int[m][2];
        for(int i = 0; i < n; i++) {
        	bus = new int[m][2];
        	for(int[] b : bus) {
        		Arrays.fill(b, -1);
        	}
        	if(i != 0)
        		now[1] += t;
        	if(now[1]>=60) {
        		now[0] += now[1]/60;
        		now[1] = now[1]%60;
        	}
        	
        	int count = m;
        	
        	while(count>0 && p.size()>0) {
        		if(now[0]>p.get(0)[0]) {
        			bus[m-count][0] = p.get(0)[0];
        			bus[m-count][1] = p.get(0)[1];
        			p.remove(0);
        			count--;
        		}else if(now[0] == p.get(0)[0]){
        			if(now[1]>=p.get(0)[1]) {
        				bus[m-count][0] = p.get(0)[0];
            			bus[m-count][1] = p.get(0)[1];
        				p.remove(0);
        				count--;
        			}else {
        				break;
        			}
        		}else {
        			break;
        		}
        	}
        }
        String s1 = "";
    	String s2 = "";
        
        if(bus[m-1][0] == -1) {
        	if(now[0]<10) {
        		s1 = "0"+now[0];
        	}else {
        		s1 = now[0]+"";
        	}
        	if(now[1]<10) {
        		s2 = "0"+now[1];
        	}else {
        		s2 = now[0]+"";
        	}
        	answer = s1+":"+s2;
        }else {
        	int hh = bus[m-1][0];
        	int mm = bus[m-1][1]-1;
        	if(mm <0) {
        		mm=59;
        		hh--;
        	}
        	if(hh<10) {
        		s1 = "0"+hh;
        	}else {
        		s1 = hh+"";
        	}
        	if(mm<10) {
        		s2 = "0"+mm;
        	}else {
        		s2 = mm+"";
        	}
        	answer = s1+":"+s2;
        }
        return answer;
    }
}
