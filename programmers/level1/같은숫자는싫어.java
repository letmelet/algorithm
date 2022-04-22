import java.util.*;

public class Solution {
    public Integer[] solution(int []arr) {

        int preNum = -1;

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == preNum) continue;

            preNum = arr[i];
            result.add(arr[i]);
        }

        return result.toArray(new Integer[result.size()]);
    }
}
