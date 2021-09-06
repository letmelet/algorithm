import java.util.*;
class Solution {
    class Node{
		int index;
		int x;
		int y;
		Node left;
		Node right;
	}
	
	int idx;
	
	public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        List<Node> list = new ArrayList<>();
        
        for(int i = 0; i< nodeinfo.length; i++) {
        	Node node = new Node();
        	node.index = i+1;
        	node.x = nodeinfo[i][0];
        	node.y = nodeinfo[i][1];
        	
        	list.add(node);
        }
        Collections.sort(list, new Comparator<Node>() {
        	@Override
        	public int compare(Node o1, Node o2) {
        		if(o2.y == o1.y) {
        			return o1.x - o2.x;
        		}
        		return o2.y - o1.y;
        	}
        });
        Node root = list.get(0);
        
        for(int i = 1; i < list.size(); i++) {
        	Node curNode = list.get(i);
        	connectNode(root, curNode);
        	
        }
        
        preorder(answer, root);
        idx = 0;
        postorder(answer, root);
        
        return answer;
    }
	
	public void connectNode(Node parent, Node child) {
		if(child.x < parent.x) {
			if(parent.left == null) {
				parent.left = child;
			}else {
				connectNode(parent.left, child);
			}
		}else {
			if(parent.right == null) {
				parent.right = child;
			}else {
				connectNode(parent.right, child);
			}
		}
	}
	
	public void preorder(int[][] answer, Node node) {
		if(node != null) {
			answer[0][idx++] = node.index;
			if(node.left != null) preorder(answer, node.left);
			if(node.right != null) preorder(answer, node.right);
		}
	}
	
	public void postorder(int[][] answer, Node node) {
		if(node != null) {
			if(node.left != null) postorder(answer, node.left);
			if(node.right != null) postorder(answer, node.right);
			answer[1][idx++] = node.index;
		}
	}
}
