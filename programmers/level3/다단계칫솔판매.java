import java.util.*;

class Solution {
    class Person{
		String parent;
		int price;
		
		Person(String p, int price){
			this.parent = p;
			this.price = price;
		}
	}
	
	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Person> parentMap = new HashMap<>();
        for(int i = 0; i < enroll.length; i++) {
        	parentMap.put(enroll[i], new Person(referral[i], 0));
        }
        
        for(int i = 0; i < seller.length; i++) {
        	String p = seller[i];
        	int price = amount[i]*100;
        	
        	while(!p.equals("-")) {
        		int parentPrice = price/10;
        		parentMap.get(p).price += price-parentPrice;
        		price = parentPrice;
        		p = parentMap.get(p).parent;
        	}
        }
        
        for(int i = 0; i < enroll.length; i++) {
        	answer[i] = parentMap.get(enroll[i]).price;
        }
        
        return answer;
    }
}
