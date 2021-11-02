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
        int cnt = 1;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                cnt++;
                max = arr[i];
            }
        }
        return cnt;
    }
}