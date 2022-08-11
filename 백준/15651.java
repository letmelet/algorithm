package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15651 {

    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        arr = new int[M + 1];

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

        for(int i = 1; i <= n; i++) {
            arr[idx] = i;
            permutation(n, m, idx + 1);
        }
    }
}
