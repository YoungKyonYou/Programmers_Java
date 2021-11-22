package InflearnDFSBFSApplication;
import java.util.*;
public class  ShortestPath{
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] flag = new int[N + 1];
        int[][] arr = new int[M + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            arr[row][col] = 1;
        }
        int[] distance = new int[N + 1];
        distance = solution(arr, distance, flag);
        for (int i = 2; i <=N; i++) {
            System.out.println((i) + ":" + (distance[i]));
        }
        
    }
    public static int[] solution(int[][] arr, int[] distance, int[] flag) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int s = q.poll();
            for (int i = 1; i < arr[s].length; i++) {
                if (flag[i] == 0 && arr[s][i] == 1) {
                    distance[i] = distance[s] + 1;
                    flag[i] = 1;
                    q.add(i);
                }
            }
        }
        return distance;
    }
}