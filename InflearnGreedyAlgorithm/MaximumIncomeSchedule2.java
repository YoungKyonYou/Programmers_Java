package InflearnGreedyAlgorithm;
import java.util.*;
public class MaximumIncomeSchedule2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mD = 0;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            mD = Math.max(mD, arr[i][1]);
        }
        Arrays.sort(arr,(o1,o2)->{
           if(o1[0]==o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0]; 
        });
        System.out.println(solution(arr, mD));
    }
    public static int solution(int[][] arr, int maxD) {
        int answer = 0;
        int[] flag = new int[maxD];
        for (int i = arr.length-1; i >=0 ; i--) {
            for (int j = arr[i][1]-1; j >= 0; j--) {
                if (flag[j] == 0) {
                    flag[j] = 1;
                    answer += arr[i][0];
                    break;
                }
            }
        }
        return answer;
    }
}