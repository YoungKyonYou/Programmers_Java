package InflearnStackQueue;
import java.util.*;

public class CraneDoll {
    public static int[][] arr;
    public static int[] seq;
    public static int cnt = 0;
    public static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr=new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                arr[i][j] = sc.nextInt();
        int M = sc.nextInt();
        seq = new int[M];
        for(int i=0;i<M;i++)
            seq[i] = sc.nextInt();
        System.out.println(solution(N));
    }

    public static int solution(int N) {
        for (int i = 0; i < seq.length; i++) {
            int temp = seq[i];
            for (int j = 0; j < N; j++) {
                if (arr[j][temp - 1] != 0) {
                    if (!stack.isEmpty() && (stack.peek() == arr[j][temp - 1])) {
                        arr[j][temp - 1] = 0;
                        stack.pop();
                        cnt += 2;
                        break;
                    }
                    stack.push(arr[j][temp - 1]);
                    arr[j][temp - 1] = 0;
                    break;
                }
            }
        }
        return cnt;
    }
}