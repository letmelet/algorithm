import java.util.*;

class Solution {
    	class job {
		int requestTime;
		int workingTime;

		job(int r, int w) {
			requestTime = r;
			workingTime = w;
		}
	}

	public int solution(int[][] jobs) {
		int answer = 0;

		Queue<job> wq = new PriorityQueue<>(new Comparator<job>() {
			@Override
			public int compare(job o1, job o2) {
				return o1.requestTime - o2.requestTime;
			}
		});
		Queue<job> pq = new PriorityQueue<>(new Comparator<job>() {
			@Override
			public int compare(job o1, job o2) {
				return o1.workingTime - o2.workingTime;
			}
		});

		for (int[] j : jobs) {
			wq.offer(new job(j[0], j[1]));
		}

		int count = 0;
		int time = wq.peek().requestTime;

		while (count < jobs.length) {
			while (!wq.isEmpty() && time >= wq.peek().requestTime) {
				pq.offer(wq.poll());
			}
			if (!pq.isEmpty()) {
				job j = pq.poll();
				time += j.workingTime;
				answer += time - j.requestTime;
				count++;
			} else {
				time++;
			}
		}
		return answer / count;
	}
}
