import java.util.*;
class Solution {
    	public int solution(String str1, String str2) {
        List<String> uni = new ArrayList<>();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
 
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        for(int i = 0; i < str1.length()-1; i++) {
        	char ch1 = str1.charAt(i);
        	char ch2 = str1.charAt(i+1);
        	if(ch1<'A' || ch1>'Z') continue;
        	if( ch2 < 'A' || ch2 > 'Z') continue;
        	
        	list1.add(ch1+""+ch2);
        	uni.add(ch1+""+ch2);
        	
        }
        for(int i = 0; i < str2.length()-1; i++) {
        	char ch1 = str2.charAt(i);
        	char ch2 = str2.charAt(i+1);
        	if(ch1<'A' || ch1>'Z') continue;
        	if( ch2 < 'A' || ch2 > 'Z') continue;
        	
        	list2.add(ch1+""+ch2);
        	if(list1.contains(ch1+""+ch2)) {
        		uni.remove(ch1+""+ch2);
        	}
        }
        
        for(String s : list2) {
        	uni.add(s);
        }
        
        int union = uni.size();
        
        for(int i = 0; i < list1.size(); i++) {
        	if(uni.contains(list1.get(i))) {
        		uni.remove(list1.get(i));
        	}
        }
        
        for(int i = 0; i < uni.size(); i++) {
        		list2.remove(uni.get(i));
        }
        int in = list2.size();

        if(union == 0) return 65536;
        return 65536*in/union;
    }
}
