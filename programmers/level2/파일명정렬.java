import java.util.*;
class Solution {
    class File{
		String head;
		int number;
		int index;
		
		File(String head, int number, int index){
			this.head = head;
			this.number = number;
			this.index = index;
		}
	}
	
	public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        List<File> list = new ArrayList<>();
        
        for(int i = 0; i < files.length; i++) {
        	String head = "";
        	String number = "";
        	for(char ch : files[i].toCharArray()) {
        		if(ch >='0' && ch <= '9') {
        			number += ch;
        			continue;
        		}
        		if(number.length() != 0) break;
        		
        		head += ch;
        	}        	
        	list.add(new File(head.toLowerCase(), Integer.valueOf(number), i));
        }
        Collections.sort(list, new Comparator<File>() {
        	@Override
        	public int compare(File o1, File o2) {
        		if(o1.head.equals(o2.head)) {
        			if(o1.number == o2.number) {
        				return o1.index - o2.index;
        			}        			
        			return o1.number - o2.number;
        		}        		
        		return o1.head.compareTo(o2.head);
        	}
        });
        
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = files[list.get(i).index];
        }
        
        return answer;
    }
}
