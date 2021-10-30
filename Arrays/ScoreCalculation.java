package Arrays;
import java.util.*;
public class  ScoreCalculation{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        int ans = arr[0]==1?1:0;
        int score = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (arr[i - 1] == 1)
                    score++;
                ans += score;
            } else 
                score = 1;
        }
        return ans ;
    }
}