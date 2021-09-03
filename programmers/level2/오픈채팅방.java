import java.util.*;
class Solution {
    public String[] solution(String[] record) {
		List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

		for(int i = 0; i < record.length; i++) {
			String[] temp = record[i].split(" ");
			if(temp[0].equals("Enter")) {
				map.put(temp[1], temp[2]);
				list.add(temp[1] + "님이 들어왔습니다.");
			}
			if(temp[0].equals("Change")) {
				map.put(temp[1], temp[2]);
			}
			if(temp[0].equals("Leave")) {
				list.add(temp[1] + "님이 나갔습니다.");
			}
		}

		String[] answer = new String[list.size()];
		int index = 0;
		for(String s : list) {
			int endId = s.indexOf("님");
			String user = s.substring(0, endId);
			
			answer[index++] = s.replace(user, map.get(user));
		}
        
        return answer;
    }
}
