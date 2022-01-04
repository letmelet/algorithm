import java.util.*;

class Solution {
    List<List<Integer>> list;

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int len = dungeons.length;

        list = new ArrayList<>();

        List<Integer> cur = new ArrayList<>();
        permutation(0, cur, len);

        for(int i = 0; i < list.size(); i++) {
            int cnt = 0;
            int piro = k;
            for(int j = 0; j < len; j++){
                if(piro >= dungeons[list.get(i).get(j)][0]) {
                    piro -= dungeons[list.get(i).get(j)][1];
                    cnt++;
                }
            }
            if(answer < cnt) answer = cnt;
        }


        return answer;
    }

    public void permutation(int dep, List<Integer> cur ,int len) {
        if(dep == len) {
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i <cur.size(); i++) {
                res.add(cur.get(i));
            }
            list.add(res);
            return;
        }

        for(int i = 0; i < len; i++) {
            if(cur.contains(i)) continue;

            cur.add(i);
            permutation(dep+1, cur, len);
            cur.remove(cur.size() - 1);

        }

    }
}
