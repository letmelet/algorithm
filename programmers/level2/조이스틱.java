class Solution {
	public int solution(String name) {
		int answer = 0;
		int minMove = name.length() - 1;

		for (int i = 0; i < name.length(); i++) {
			int n1 = name.charAt(i) - 'A';
			int n2 = 'Z' - name.charAt(i) + 1;

			answer += Math.min(n1, n2);

			int next = i + 1;
			while (next < name.length() && name.charAt(next) == 'A') {
				++next;
			}
			minMove = Math.min(minMove, i + name.length() - next + Math.min(i, name.length() - next));
		}
		answer += minMove;
		return answer;
	}
}
