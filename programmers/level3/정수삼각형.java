import java.util.*;

class Solution {
    	public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] newTri = new int[triangle.length][triangle.length];
        
        for(int i = 0; i < triangle.length; i++) {
        	for(int j = 0; j < triangle[i].length; j++) {
        		newTri[i][j] = triangle[i][j];
        	}
        }
        for(int i = 1; i < triangle.length; i++) {
        	newTri[i][0] += newTri[i-1][0];
        	newTri[i][i] += newTri[i-1][i-1]; 
            for(int j = 1; j <i; j++) {
        		newTri[i][j] += Math.max(newTri[i-1][j], newTri[i-1][j-1]); 
        	}
        }
        for(int i = 0; i < triangle[triangle.length-1].length; i++) {
        	answer = Math.max(answer, newTri[triangle.length-1][i]);
        }
        
        return answer;
    }
}
