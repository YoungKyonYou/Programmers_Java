package Arrays;
import java.util.*;
public class  ClassPresident{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][5];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < 5; j++)
                arr[i][j] = sc.nextInt();
        System.out.println(solution(arr));
    }

    public static int solution(int[][] arr) {
        int max = 0;
        int[][] flag = new int[arr.length][arr.length];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < 5; k++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i][k] == arr[j][k] && flag[i][j] == 0) {
                        flag[i][j] = 1;
                    }
                }
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[i][k] == arr[j][k] && flag[i][j] == 0) {
                        flag[i][j] = 1;
                    }
                }
            }

        }
        for(int i=0;i<flag.length;i++){
            int sum=0;
            for (int j = 0; j < arr.length; j++) {
                if(flag[i][j]==1)
                    sum++;
            }
            if (max < sum) {
                max = sum;
                idx = i;
            }
        }
        return idx+1;
    }
}