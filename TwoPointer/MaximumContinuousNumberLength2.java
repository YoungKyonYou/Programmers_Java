package TwoPointer;
import java.util.*;
public class  MaximumContinuousNumberLength2{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();
        System.out.println(solution(arr, M, N));
    }

    public static int solution(int[] arr, int k,int n) {
        int answer = 0, cnt = k, lt = 0;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0)
                cnt--;
            while (cnt < 0) {
                if (arr[lt] == 0)
                    cnt++;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        return answer;
    }
}