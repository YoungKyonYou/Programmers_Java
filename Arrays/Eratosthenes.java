package Arrays;
import java.util.*;
public class  Eratosthenes{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(solution(N));
    }

    public static int solution(int n) {
        int[] flag = new int[n+1];
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (flag[i] == 0) {
                cnt++;
                for (int j = i; j <= n; j += i) {
                    flag[j] = 1;
                }
            }
           
        }
        return cnt;
    }
}