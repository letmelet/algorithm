import java.util.*;

class Solution {
    	public String solution(int[] numbers) {
        String answer = "";
        
        String[] chk = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
        	chk[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(chk, new Comparator<String>() {
        	@Override
        	public int compare(String o1, String o2) {
        		return (o2+o1).compareTo(o1+o2);
        	}
        });
        
        return chk[0].equals("0") ? "0" : String.join("",chk);
    }
}
