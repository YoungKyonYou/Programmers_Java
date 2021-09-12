package Arrays;
import java.util.*;
public class  ClassPresident{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                arr[i][j] = sc.nextInt();
        System.out.println(solution(arr));
    }

    public static int solution(int[][] arr) {
        int max = 0;
        int[] ans=new int[arr.length];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr.length; k++) {
                for (int j = k; j < arr.length - 1; j++) {
                    System.out.println("arr[j][k]:" + arr[j][k] + " arr[j+1][k]:" + arr[j + 1][k]);
                    System.out.println("test:" + arr[1][0]);
                    if (arr[j][k] == arr[j + 1][k]) {
                        ans[i]++;
                    }
                }
                for (int j = k; j >0; j--) {
                    if (arr[j][k] == arr[j - 1][k]) {
                        ans[i]++;
                    }
                }
            }

        }
        for (int i = 0; i < ans.length; i++) {
            if (max < ans[i]) {
                max = ans[i];
                idx = i;
            }
        }
        System.out.println(Arrays.toString(ans));

        return idx+1;
    }
}