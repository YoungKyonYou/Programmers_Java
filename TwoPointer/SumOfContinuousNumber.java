package TwoPointer;
import java.util.*;
public class  SumOfContinuousNumber{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(solution(N));
    }
    public static int solution(int n) {
        int ans = 0;
        int sum=0;
        int lp = 1;
        for (int rp = 1; rp <=n; rp++) {
            sum += rp;
            if (sum == n) {
                ans++;
                continue;
            }
            while (sum > n) {
                sum -= lp;
                lp++;
            }
            if(sum==n)
                ans++;
        }
        return ans-1;
    }
}
 