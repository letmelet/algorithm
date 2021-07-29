import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < moves.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[j][moves[i]-1] != 0){
                    if(!st.isEmpty() && st.peek() == board[j][moves[i]-1]){
                        st.pop();
                        answer+=2;
                    }else{
                        st.push(board[j][moves[i]-1]);
                    }
                    board[j][moves[i]-1] = 0;
                    break;
                }
                
            }
        }
        
        return answer;
    }
}
