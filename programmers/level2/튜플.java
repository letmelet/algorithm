import java.util.*;

class Solution {
    	public int[] solution(String s) {
		String s2 = s.substring(1, s.length()-1);
		List<List<Integer>> list = new ArrayList<>();
				
		int index = 0;
		String str = "";
		for(int i = 0; i < s2.length(); i++) {
			if(s2.charAt(i)=='{') {
				list.add(new ArrayList<Integer>());
				continue;
			}
			if(s2.charAt(i)==',') {
				if(str.length() != 0) {
					list.get(index).add(Integer.valueOf(str));
					str = "";
				}
				continue;
			}
			if(s2.charAt(i)=='}') {
				list.get(index).add(Integer.valueOf(str));
				str = "";
				index++;
				continue;
			}
			str += s2.charAt(i);
		}
		Collections.sort(list, (a,b) -> a.size() - b.size());
		boolean[] visited = new boolean[100001];
		int[] answer = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < list.get(i).size(); j++) {
				if(!visited[list.get(i).get(j)]) {
					answer[i] = list.get(i).get(j);
					visited[answer[i]] = true;
				}
				
			}
			
		}
		return answer;
	}
}
