import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> result = new HashMap<>();

        Set<String> set = new HashSet<>();
        Map<String, ArrayList<String>> map = new HashMap<>();

        for(int i = 0; i < id_list.length; i++){
            result.put(id_list[i], 0);
            map.put(id_list[i], new ArrayList<>());
        }

        for(String str : report){
            if(set.add(str)){
                String[] user = str.split(" ");

                map.get(user[1]).add(user[0]);
            }
        }


        for(int i = 0; i < map.size(); i++) {
            if(map.get(id_list[i]).size() >= k) {

                for(String user : map.get(id_list[i])){
                    result.put(user, result.getOrDefault(user,0)+1);
                }

            }
        }

        for(int i = 0; i < answer.length; i++){
            answer[i] = result.get(id_list[i]);
        }

        return answer;
    }
}
