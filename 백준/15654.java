package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj15654 {

    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visit;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        String str = br.readLine();
        st = new StringTokenizer(str);
        list = new ArrayList<>();
        arr = new int[M + 1];
        visit = new boolean[N + 1];

        for(int i = 0; i < N; i++) {
            list.add(Integer.valueOf(st.nextToken()));
        }
        Collections.sort(list);

        permutation(N, M, 0);

        System.out.println(sb);
    }

    private static void permutation(int n, int m, int idx) {
        if(idx == m) {
            for(int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            arr[idx] = list.get(i);
            permutation(n, m, idx + 1);
            visit[i] = false;
        }
    }
}
