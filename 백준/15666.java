package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj15666 {

    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visit;
    static List<Integer> list;
    static Set<String> set = new HashSet<>();

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

        permutation(N, M, 0, "");

        System.out.println(sb);
    }

    private static void permutation(int n, int m, int idx, String result) {
        if(idx == m) {
            if(set.add(result)){
                for(int i = 0; i < m; i++) {
                    sb.append(arr[i] + " ");
                }
                sb.append("\n");
            }
            return;
        }

        for(int i = 0; i < n; i++) {
            if(idx > 0 && arr[idx - 1] > list.get(i)) continue;
            arr[idx] = list.get(i);
            permutation(n, m, idx + 1, result + "," +list.get(i));
        }
    }
}
