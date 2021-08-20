package DynamicProgramming;
import java.util.*;

public class ExpressingWithN {
    public static int answer = -1;// 전역변수로 설정
    public static void main(String[] args) throws Exception {
        int N = 5;
        int number = 12;
        int ans = solution(N, number);
        System.out.println(ans);
    }
    

    public static void dfs(int N, int number, int cnt, int prev) {
        if (cnt > 8) {// 8번안에 끝내야한다
            answer = -1;
            return;
        }
        if (prev == number) {
            if (answer == -1 || cnt < answer) {// 처음이거나 기존answer보다 더 최솟값을 발견했다면
                answer = cnt;
                return;
            }
        }
        int NN = 0;
        for (int i = 0; i < 8 - cnt; i++) {// 8번안에 끝내야하므로
            NN = 10 * NN + N;// 숫자 N으로 만들 수 있는 수
            dfs(N, number, cnt + i + 1, prev + NN);
            dfs(N, number, cnt + i + 1, prev - NN);
            dfs(N, number, cnt + i + 1, prev * NN);
            dfs(N, number, cnt + i + 1, prev / NN);
        }
    }

    public static int solution(int N, int number) {
        dfs(N, number, 0, 0);
        return answer;
    }
}