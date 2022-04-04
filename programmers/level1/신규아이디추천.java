class Solution {
    public String solution(String new_id) {
        String result = "";
		
		// step 1
		String step1 = new_id.toLowerCase();
		
		// step 2
		String step2 = "";
		for(int i = 0; i < step1.length() ; i++) {
			if((step1.charAt(i) >= 'a' && step1.charAt(i) <= 'z') || (step1.charAt(i) >= '0' && step1.charAt(i) <= '9') || step1.charAt(i) == '-' || step1.charAt(i) == '_' || step1.charAt(i) == '.') 
				step2 += step1.charAt(i);
		}
		
		// step 3
		StringBuilder step3 = new StringBuilder();
		for(int i = 0; i < step2.length(); i++) {
			if(i+1 < step2.length() && step2.charAt(i) == '.' && step2.charAt(i+1) == '.') {
				continue;
			}
			step3.append(step2.charAt(i));
		}
		// step 4
		String step4 = step3.toString();
		if(step4.length() >0) {
			if(step4.charAt(0) == '.') {
				step4 = step4.substring(1, step4.length());
			}			
		}
		if(step4.length() > 0) {
			if(step4.charAt(step4.length()-1) == '.') {
				step4 = step4.substring(0, step4.length()-1);
			}			
		}
		// step 5
		if(step4.length() == 0) 
			step4 += "a";
		// step 6
		String step6 = step4;
		if(step6.length() >= 16) {
			step6 = step6.substring(0, 15);
			if(step6.charAt(step6.length()-1)== '.') {
				step6 = step6.substring(0,step6.length()-1);
			}
		}
		
		// step 7
		String step7 = step6;
		
		if(step7.length() <=2) {
			char ch = step7.charAt(step7.length()-1);
			while(step7.length() < 3) {
				step7 += ch;
			}
		}
		result = step7;
		System.out.println("step7 : " + result);
		return result;
    }
}
