import java.util.*;

class Solution {
    public int solution(int[][] sizes) {

        for(int i = 0; i < sizes.length; i++) {
            Arrays.sort(sizes[i]);
        }
        int maxA = -1;
        int maxB = -1;

        for(int i = 0; i < sizes.length; i++){
            if(maxA < sizes[i][0]) maxA = sizes[i][0];
            if(maxB < sizes[i][1]) maxB = sizes[i][1];
        }

        return maxA*maxB;
    }
}
