package Arrays;
import java.util.*;
public class  Ranking{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        solution(arr);
    }

    public static int findMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(max<arr[i])
                max=arr[i];
        }
        return max;
    }

    public static void solution(int[] arr) {
        int[] rank = new int[arr.length];
        int max = 0;
        int r = 1;
        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
            if (flag == arr.length)
                break;
            max = findMax(arr);
            int cnt = 0;
            for (int j = 0; j < arr.length; j++) {
                if (max == arr[j]) {
                    rank[j] = r;
                    arr[j] = 0;
                    cnt++;
                    flag++;
                }
            }
            r+=cnt;
        }
        for(int a: rank)
            System.out.print(a + " ");
    }
}