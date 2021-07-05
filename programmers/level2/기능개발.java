import java.util.*;
class Solution {
 public int[] solution(int[] progresses, int[] speeds) {

		Queue<Integer> proQue = new LinkedList<>();
		Queue<Integer> spQue = new LinkedList<>();

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < progresses.length; i++) {
			proQue.offer(progresses[i]);
			spQue.offer(speeds[i]);
		}

		int day = 0;
		int count = 0;
		while (!proQue.isEmpty()) {
			if (proQue.peek() + day * spQue.peek() >= 100) {
				while (true) {
					if (proQue.isEmpty())
						break;
					if (proQue.peek() + day * spQue.peek() < 100)
						break;

					proQue.poll();
					spQue.poll();
					count++;

				}
				list.add(count);
				count = 0;
				if (proQue.isEmpty())
					break;

			}

			int speed = spQue.peek();
			int pro = proQue.peek() + speed * day;

			while (pro < 100) {
				pro += speed;
				day++;
			}

		}

		int[] answer = new int[list.size()];
		for(int i=0; i < list.size(); i++ ) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
