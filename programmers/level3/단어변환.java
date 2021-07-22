import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        List<String> list = Arrays.asList(words);
        
        if(words == null || !list.contains(target)) return 0;
        
        Queue<String> que = new LinkedList<>();
        Set<String> set = new HashSet<>(list);        
        
        que.offer(begin);
        set.remove(begin);
        
        int result = 0;
        
        while(!que.isEmpty()){
            int size = que.size();
            
            for(int i = 0; i < size; i++){
                String str = que.poll();
                
                if(str.equals(target)){
                    return result;
                }
                
                for(String st : similarString(str, set)){
                    que.offer(st);
                }
            }
            result++;
        }
        return 0;
    }
    
    public List<String> similarString(String str, Set<String> set){
        List<String> list = new ArrayList<>();
       
        for(int i = 0; i < str.length(); i++){
            char[] chars = str.toCharArray();
            for(char ch = 'a'; ch <= 'z'; ch++){
                chars[i] = ch;
                String st = String.valueOf(chars);
                
                if(set.remove(st)){
                    list.add(st);
                }
            }
        }
        return list;
    }
}
