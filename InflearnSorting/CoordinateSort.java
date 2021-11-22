package InflearnSorting;
import java.util.*;

public class CoordinateSort {
    public static int[][] arr;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        solution(N);
        for(int i=0;i<N;i++)
            System.out.println(arr[i][0] + " " + arr[i][1]);
    }
    public static void solution(int N) {
        Arrays.sort(arr,(o1,o2)->{
            if(o1[0]==o2[0])
                return o1[1]-o2[1];
            else
                return o1[0]-o2[0];
        });
    }
}