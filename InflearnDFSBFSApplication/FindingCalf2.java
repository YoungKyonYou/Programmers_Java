package InflearnDFSBFSApplication;
import java.util.*;

public class FindingCalf2 {
    public static int[] flag;
    public static int[] dis = { 1, -1, 5 };
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int N = sc.nextInt();
        int M = sc.nextInt();
        flag = new int[100015 ];
        System.out.println(solution(q,N,M));
    }

    public static int solution(Queue<Integer> q, int start, int target) {
        q.add(start);
        int answer = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int x = q.poll();
                for (int j = 0; j < 3; j++) {
                    int y = x + dis[j];
                    if (y == target)
                        return answer + 1;
                    if (y > 0 && y < 10001 && flag[y] == 0) {
                        q.add(y);
                        flag[y] = 1;
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}