package InflearnGreedyAlgorithm;
import java.util.*;
public class  Wrestler{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) 
            for(int j=0;j<2;j++)
                arr[i][j] = sc.nextInt();
        System.out.println(solution(arr));
    }

    public static int solution(int[][] arr) {
        int answer = 1;
        Arrays.sort(arr, (o1, o2)->{
            return o2[0]-o1[0];
        });
        int h = arr[0][0];
        int w = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][1] > w) {
                answer++;
                h = arr[i][0];
                w = arr[i][1]; 
            }
        }
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
        return answer;
    }
}