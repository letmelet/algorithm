import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        Set<Integer> set = new HashSet<>();
        int count = 0;
        
        for(int win : win_nums) {
        	set.add(win);
        }
        for(int i = 0 ; i < 6; i++) {
        	if(lottos[i] == 0) count++;
        	set.remove(lottos[i]);
        }
        
        int[] arr = new int[7];
        arr[0] = 6; arr[1] = 6;
        
        for(int i = 6; i >0 ; i--) {
        	arr[i] = 7-i; 
        }
        
        answer[0] = arr[6-set.size() + count];
        answer[1] = arr[6-set.size()];
       
        
        return answer;
    }
}
