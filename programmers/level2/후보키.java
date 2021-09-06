import java.util.*;
class Solution {
    String[][] relation;
	List<List<Integer>> list = new ArrayList<>();
	public int solution(String[][] relation) {
        int answer = 0;
        this.relation = relation;
        
        for(int i = 1; i <= relation[0].length; i++) {
        	List<Integer> l = new ArrayList<>();
        	dfs(0, i, relation[0].length, l);
        }
        return list.size();
    }
	
	public void dfs(int index, int len, int r, List<Integer> l) {
		if(index == len) {
			List<Integer> l2 = new ArrayList<>();
			for(int i = 0; i < l.size(); i++) {
				l2.add(l.get(i));
			}
			if(isUnique(l2)) {
				for(int j = 0; j < list.size(); j++) {
					if(l2.containsAll(list.get(j))) {
						return;
					}
				}
				list.add(l2);				
			}
		
			return;
		}
		for(int i = 0; i < r; i++) {
			if(l.contains(i)) continue;
			if(l.size() > 0) {
				if(l.get(l.size()-1)> i) continue;
			}
			l.add(i);
			dfs(index+1, len, r, l);
			l.remove(l.size()-1);
		}
	}
	
	public boolean isUnique(List<Integer> l) {
		Set<String> cadi = new HashSet<>();
		for(int i = 0; i < relation.length; i++) {
			String str = "";
			for(int j = 0; j < l.size(); j++) {
				str += relation[i][l.get(j)];
			}
			if(!cadi.add(str)) {
				return false;
			}
		}
		
		return true;
	}
}
