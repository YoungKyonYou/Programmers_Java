package Arrays;
import java.util.*;
public class  ClassPresident2{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N+1][6];
        for (int i = 1; i < N+1; i++)
            for (int j = 1; j < 6; j++)
                arr[i][j] = sc.nextInt();
        System.out.println(solution(arr));
    }

    public static int solution(int[][] arr) {
        int max = 0;
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            int cnt=0;
            for (int j = 1; j < arr.length; j++) {
                for (int k = 1; k < 6; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
                if (max < cnt) {
                    max = cnt;
                    ans = i;
                }
            }
        }
        return ans;
    }
}