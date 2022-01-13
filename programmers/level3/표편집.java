import java.util.*;

class Solution {
    class Node{
		boolean remove;
		Node prev;
		Node next;
	}
	
	Node[] arr = new Node[1000000];
	
	public String solution(int n, int k, String[] cmd) {
		
		for(int i = 0; i< n; i++) {
			arr[i] = new Node();
		}	
		for(int i = 1; i < n ; i++) {
			arr[i-1].next = arr[i];
			arr[i].prev = arr[i-1];
		}
		
		Stack<Node> st = new Stack<>();
		Node cur = arr[k];
		
		for(String cm : cmd) {
			char c = cm.charAt(0);
			
			switch(c) {
				case 'U' :{
					int num = Integer.valueOf(cm.substring(2));
					for(int i = 0; i < num; i++) {
						cur = cur.prev;
					}
					break;}
				case 'D' :{
					int num = Integer.valueOf(cm.substring(2));
					for(int i = 0; i < num; i++) {
						cur = cur.next;
					}
					break;}
				case 'C' :{
					cur.remove = true;
					st.push(cur);
					Node up = cur.prev;
					Node down = cur.next;
					if(up != null) {
						up.next = down;
					}
					if(down != null) {
						down.prev = up;
						cur = down;
					} else {
						cur = up;
					}
					break;}
				case 'Z' :{
					Node node = st.pop();
					node.remove = false;
					Node up = node.prev;
					Node down = node.next;
					if(up != null) {
						up.next = node;
					}
					if(down != null) {
						down.prev = node;
					}
					break;}
			}
		}
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < n; i++) {
			if(arr[i].remove) 
				res.append('X');
			else 
				res.append('O');
		}
		return res.toString();
	}
}
