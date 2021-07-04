class Solution {
    public boolean solution(String[] phone_book) {
         for(String ph : phone_book) {
        	for(String ph2 : phone_book) {
        		if(ph.equals(ph2)) continue;
        		
        		if(ph2.indexOf(ph)==0) {
        			return false;
        		}
        	}
        }
        
        return true;
    }
}
