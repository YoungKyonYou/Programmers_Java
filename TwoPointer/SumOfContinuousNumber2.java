package TwoPointer;
import java.util.*;
public class  SumOfContinuousNumber2{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(solution(N));
    }
    public static int solution(int n) {
        int ans = 0;
        n--;
        int cnt = 1;
        while (n > 0) {
            cnt++;
            n -= cnt;
            if(n%cnt==0)
                ans++;
        }
        return ans;
    }
}
 