import java.util.*;
class Solution {
    	class Node{
		Map<Character, Node> childNodes = new HashMap<>();
		int childCount = 0;
		
		Node put(char c) {
			childCount++;
			if(!childNodes.containsKey(c)) {
				childNodes.put(c,  new Node());
			}
			return childNodes.get(c);
		}
	}
	Node root = new Node();
	
	public int solution(String[] words) {
		int answer = 0;
		
		for(String word : words) {
			insert(word);
		}
		
		return search(root, 0);
	}
	
	void insert(String word) {
		Node curNode = root;
		
		for(int i = 0; i < word.length(); i++) {
			Node newNode = curNode.put(word.charAt(i));
			curNode = newNode;
		}
		curNode.put('*');
	}
	
	int search(Node node, int cnt) {
		if(node.childCount == 1) {
			return cnt;
		}
		int count = 0;
		
		for(char key : node.childNodes.keySet()) {
			if(key == '*') {
				count += cnt;
			}
			else {
				count += search(node.childNodes.get(key), cnt+1);
			}
		}
		return count;
	}
}
