package RecursiveTreeGraph;

import java.util.*;

public class DFS {
    static public List<List<Integer>> arr;
    static public int answer = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] flag = new int[N + 1];
        arr = new ArrayList(N + 1);
        for (int i = 0; i < N + 1; i++)
            arr.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr.get(a).add(b);
        }
        solution(1, N, flag);
        System.out.println(answer);
    }

    public static void solution(int start, int end, int[] flag) {
        flag[start] = 1;
        if (start == end)
            answer++;
        for (int i = 0; i < arr.get(start).size(); i++) {
            if (flag[arr.get(start).get(i)] == 0) {
                solution(arr.get(start).get(i), end, flag);
                flag[arr.get(start).get(i)] = 0;
            }
        }
    }
}