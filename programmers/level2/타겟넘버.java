class Solution {
int result;
	
	public int solution(int[] numbers, int target) {
		result = 0;
		
		dfs(0, numbers, target, 0);
		
		return result;
	}
	
	public void dfs(int index, int[] numbers, int target, int sum) {
		if(index == numbers.length) {
			if(sum == target)
				result++;
			
			return;
		}
		
		dfs(index+1, numbers, target, sum + numbers[index]);
		dfs(index+1, numbers, target, sum - numbers[index]);
		
	}
}
