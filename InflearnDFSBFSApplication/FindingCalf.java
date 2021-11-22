package InflearnDFSBFSApplication;
import java.util.*;

public class FindingCalf {
    public static int[] flag;
    public static class Pair {
        public int pos;
        public int cnt;

        public Pair(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int N = sc.nextInt();
        int M = sc.nextInt();
        flag = new int[10001];
        System.out.println(solution(q,N,M));
    }

    public static int solution(Queue<Integer> q, int start, int target) {
        q.add(start);
        flag[start] = 1;
        int answer = 0;
        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                int p = q.poll();
                if(p==target)
                    break;
                if (flag[p+1] == 0 && p+1<10000)
                    q.add(p + 1);
                if(flag[p-1]==0 && p-1>0)
                    q.add(p - 1);
                if(flag[p+5]==0 && p+5<10000)
                    q.add(p + 5);
                answer++;
            }
        }
        return answer;
    }
}