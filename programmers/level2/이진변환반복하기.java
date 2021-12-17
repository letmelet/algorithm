class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while(!s.equals("1")){
            String newS = s.replaceAll("0", "");
            answer[1] += s.length() - newS.length();
            answer[0]++;

            s = getSizeToBinary(newS);

        }

        return answer;
    }

    private String getSizeToBinary(String s) {
        int n = s.length();
        String result = "";
        while(n != 1){
            if(n % 2 == 0)
                result = "0" + result;
            else {
                result = "1" + result;
            }
            n /= 2;
        }
        result = n + result;

        return result;
    }
}
