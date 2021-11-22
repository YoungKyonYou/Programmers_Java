import java.io.*;
import java.util.*;

public class Operator2 {

    static int N;
    static int[] map;
    // static int []visit;

    static int cnt;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    static void dfs(int start, int index, int[] operator) {
        if (index == N) {
            // max = max > start ? max:start;
            // min = min < start ? min:start;
            max = Math.max(max, start);
            min = Math.min(min, start);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                if (i == 1) {
                    dfs(start + map[index + 1], index + 1,operator);

                } else if (i == 2) {
                    dfs(start - map[index + 1], index + 1, operator);

                } else if (i == 3) {
                    dfs(start * map[index + 1], index + 1, operator);

                } else if (i == 4) {
                    dfs(start / map[index + 1], index + 1, operator);

                }
                operator[i]++;

            }

        }

    }

    public static void main(String[] args) throws IOException {
        int[] operator;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1];
        // visit = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        operator = new int[5];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());

        }

        dfs(map[1], 1,operator);

        System.out.println(max);
        System.out.println(min);
    }

}
