package Arrays;
import java.util.*;
public class  NumberOfSummit{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) 
            for(int j=0;j<N;j++)
                arr[i][j] = sc.nextInt();
        System.out.println(solution(arr));
    }

    public static int solution(int[][] arr) {
        int cnt = 0;
        int[][] tempArr = new int[arr.length + 2][arr.length + 2];
        for (int i = 1; i < tempArr.length - 1; i++) 
            for (int j = 1; j < tempArr.length - 1; j++) 
                tempArr[i][j] = arr[i-1][j-1];
        for (int i = 1; i < tempArr.length-1; i++) 
            for (int j = 1; j < tempArr.length-1; j++) 
                if (tempArr[i][j] > tempArr[i - 1][j] && tempArr[i][j] > tempArr[i + 1][j] && tempArr[i][j] > tempArr[i][j - 1]
                        && tempArr[i][j] > tempArr[i][j + 1]) 
                    cnt++;
        return cnt;
    }
}