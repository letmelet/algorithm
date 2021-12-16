class Solution {
    public int[] solution(int n) {
        int max = getMax(n);
        int[] answer = new int[max];
        int[][] map = new int[n][n];

        int k = 1;
        int y = 0, x = 0;

        map[y][x] = k++;

        while(k <= max) {
            while(y+1 < n && k <= max && map[y+1][x] == 0) {
                map[++y][x] = k++;
            }
            while(x+1 < n && k <= max && map[y][x+1] == 0) {
                map[y][++x] = k++;
            }
            while(y-1 >0 && x-1 > 0 && k <= max && map[y-1][x-1] == 0){
                map[--y][--x] = k++;
            }
        }

        int r = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++){
                answer[r++] = map[i][j];
            }
        }

        return answer;
    }

    private int getMax(int n) {
        int max = n * (n + 1) / 2;
        return max;
    }
}
