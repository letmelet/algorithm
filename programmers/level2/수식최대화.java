import java.util.*;

class Solution {
    static char[] opers; // 수식 우선순위를 담을 배열
    static long answer; // 수식을 계산한 값
    static String exp;
    static boolean[] visited;

    public static long solution(String expression) {
    	exp = expression;
    	List<Character> oper = new ArrayList<>();
    	if(exp.contains("+")) {
    		oper.add('+');
    	}
    	if(exp.contains("-")) {
    		oper.add('-');
    	}
    	if(exp.contains("*")) {
    		oper.add('*');
    	}
    	answer = -1;
    	opers = new char[oper.size()];
    	visited = new boolean[oper.size()];
    	solve(0, oper);
    	
    	
        
        return answer;
    }
    
    
    public static void solve(int index, List<Character> oper) {
    	if(index == opers.length) {
    		long result = calculate();
    		answer = Math.max(answer, result);
    		return;
    	}
    	
    	for(int i = 0; i < opers.length; i++) {
    		if(visited[i]) continue;
    		
    		opers[index] = oper.get(i);
    		visited[i] = true;
    		solve(index+1, oper);
    		visited[i] = false;
    	}
    }
    
    public static long calculate() {
//    	opers, exp
    	Map<String, Integer> map = new HashMap<>();
    	for(int i = 0; i < opers.length; i++) {
    		map.put(opers[i] + "", i);
    	}
    	List<String> equation = new ArrayList<>();
    	Stack<String> arg = new Stack<>();
    	String temp = "";
    	for(int i = 0; i< exp.length(); i++) {
    		char ch = exp.charAt(i);
    		if(ch == '+' || ch == '-'  || ch == '*' ) {
    			equation.add(temp);
    			temp = "";
    			
    			while(!arg.isEmpty() && map.get(ch+"") <= map.get(arg.peek())) {
    				equation.add(arg.pop());
    			}
    			
    			arg.push(ch+"");
    			continue;
    		}
    		temp += ch;
    	}
    	
    	equation.add(temp);
    	while(!arg.isEmpty()) {
    		equation.add(arg.pop());
    	}
    	Stack<Long> value = new Stack<>();
    	for(String e : equation) {
    		if(map.containsKey(e)) {
    			Long b = value.pop();
    			Long a = value.pop();
    			
    			switch(e) {
    				case "+" :
    					value.push(a+b); break;
    				case "-" :
    					value.push(a-b); break;
    				case "*" :
    					value.push(a*b); break;
    			}
    			continue;
    		}
    		
    		value.push(Long.valueOf(e));
    	}
    	return Math.abs(value.pop());
    }
}
