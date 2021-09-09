package Arrays;
import java.util.*;
public class  ShowStudent{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1])
                cnt++;
            else
                cnt = 0;
            ans = Math.max(ans, cnt);
        }
        return ans+1;
    }
}