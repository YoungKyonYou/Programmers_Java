package Arrays;
import java.util.*;
public class  Ranking3{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        solution(arr);
    }

    public static void solution(int[] arr) {
        int[] rank = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int cnt = 1;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j])
                    cnt++;
            }
            rank[i] = cnt;
        }
        for(int a:rank)
            System.out.print(a + " ");
    }
}