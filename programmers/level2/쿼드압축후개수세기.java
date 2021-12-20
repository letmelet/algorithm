class Solution {
    int[] answer;

    public int[] solution(int[][] arr) {
        answer = new int[2];

        quad(0, 0, arr.length, arr);

        return answer;
    }

    public void quad(int y, int x, int len, int[][] arr) {
        if(len == 1) {
            answer[arr[y][x]]++;
            return;
        }

        if(check(y, x, len, arr)) {
            answer[arr[y][x]]++;
            return;
        }

        quad(y, x, len/2, arr);
        quad(y, x+len/2, len/2, arr);
        quad(y+len/2, x, len/2, arr);
        quad(y+len/2, x+len/2, len/2, arr);

    }

    private boolean check(int y, int x, int len, int[][] arr) {
        for(int i = y; i < y+len; i++){
            for(int j = x; j < x+len; j++) {
                if(arr[y][x] != arr[i][j]) {
                   return false;
                }
            }
        }
        return true;
    }
}
