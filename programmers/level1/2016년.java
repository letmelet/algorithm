class Solution {
    public String solution(int a, int b) {
        String answer = "";

        int date = 4;

        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if(a != 1) {
            for(int i = 0; i < a-1; i++) {
                date += month[i];
            }
        }
        date += b;

        int result = date%7;

        answer = day[result];

        return answer;
    }
}
