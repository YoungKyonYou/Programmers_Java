package TwoPointer;
import java.util.*;
public class  MaximumSales{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();
        System.out.println(solution(arr, M));
    }
    public static int solution(int[] arr, int N) {
        int l = 0;
        int r = N-1;
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < N; i++)
            ans += arr[i];
        sum = ans;
        for (int i = N; i < arr.length-N; i++) {
            sum -= arr[l];
            r++;
            sum += arr[r];
            ans = Math.max(ans, sum);
            l++;
        }
        return ans;
    }
}