import java.util.Arrays;

class Solution {
  	public int solution(int[] stones, int k) {
        int l = 0;
        int r = Integer.MAX_VALUE;
        int mid = 0;
        int count = 0;                        
        boolean flag = false;               
        int answer = 0;
       
        while(true) {
        	if(l>r) {
        		System.out.println("result --> l : "+ l + " r: " + r + " mid : "+(l+r)/2);
        		break;
        	}
        	int[] newStone = stones.clone();
        	flag = false;
        	count = 0;
        	mid = (l+r)/2;
        	System.out.println("mid : " + mid);
        	for(int i = 0; i < newStone.length; i++) {
        		if(newStone[i] <= mid) {
        			newStone[i] = 0;
        			count++;
        		} else {
        			count = 0;
        		}
        		
        		if(count == k) {
        			flag = true;
        			break;
        		}
        	}
        	if(flag) {
        		r = mid-1;
        		System.out.println("changed r --> l : "+ l + " r: " + r + " mid : "+mid);
        		answer = mid;
        		System.out.println("answer : " + answer);
        	}
        	else {
        		l = mid+1;
        		System.out.println("changed l --> l : "+ l + " r: " + r + " mid : "+mid);
        	}
        }
        
        return answer;
    }

}
