package InflearnDynamicProgramming;

import java.util.*;
//여기서는 j가 뒤에서부터 시작한다 그래야
//문제에서 요구하는 한문제씩만 풀어라를 충족시킬 수 있다.
//이렇게 하나씩만 써야 할땐 뒤에서부터 시작하고
//이전 냅색 문제처럼 무제한으로 쓸 수 있으면 앞에서부터 간다.
public class  MaxScoreKnacksack{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[] dy = new int[M + 1];
        
        System.out.println(solution(arr, dy));
    }

    public static int solution(int[][] arr, int[] dy) {
        int answer = 0;
       // Arrays.fill(dy, Integer.MAX_VALUE);
       // dy[(dy.length-1)-arr[0][1]]=arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = dy.length - 1; j >= arr[i][1]; j--) {
                if (dy[j - arr[i][1]]+arr[i][0] > dy[j])
                    dy[j] = dy[j - arr[i][1]] + arr[i][0];
            }
        }
        for(int a:dy)
            answer = Math.max(answer, a);
        return answer;
    }
}