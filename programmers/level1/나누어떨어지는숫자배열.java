import java.util.*;

class Solution {
    public Integer[] solution(int[] arr, int divisor) {
        int[] answer = {};

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            if (isMultiple(arr[i], divisor))
                result.add(arr[i]);
        }

        Collections.sort(result);

        if(result.size() == 0) {
            return new Integer[]{-1};
        } else {
            return result.toArray(new Integer[result.size()]);
        }
    }

    public boolean isMultiple(int num, int divisor) {
        if(num < divisor) return false;

        return num % divisor == 0;
    }
}
