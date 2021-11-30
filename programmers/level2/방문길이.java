import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Map<Character, int[]> command = new HashMap<>();
        
        command.put('U', new int[] {1, 0});
        command.put('D', new int[] {-1, 0});
        command.put('L', new int[] {0, -1});
        command.put('R', new int[] {0, 1});
        
        Set<String> set = new HashSet<>();
        
        int y = 0;
        int x = 0;
        
        for(int i = 0; i < dirs.length(); i++) {
        	char ch = dirs.charAt(i);
        	
        	int dy = y + command.get(ch)[0];
        	int dx = x + command.get(ch)[1];
        	
        	if(dy < -5 || dx < -5 || dy > 5 || dx > 5) continue;
        	
        	set.add(x+""+y+""+dx+""+dy);
        	set.add(dx+""+dy+""+x+""+y);
        	x = dx;
        	y = dy;
        	
        }
        
        answer = set.size()/2;
        
        return answer;
    }
}
