package InflearnDFSBFSApplication;
import java.util.*;

public class Island {
    static public int[][] map;
    static public int[] arrX = { 0, 0, 1, -1,1,-1,1,-1 };
    static public int[] arrY = { 1, -1, 0, 0,1,-1,-1,1 };
    static public int ans = 0;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) 
                map[i][j] = sc.nextInt();
        for (int i = 0; i < N; i++) 
            for (int j = 0; j < N; j++) 
                if (map[i][j] == 1) {
                    solution(i, j, N);
                    ans++;
                }
        System.out.println(ans);
    }
    public static void solution(int x, int y, int N) {
        for (int i = 0; i < 8; i++)
            if (x + arrX[i] >= 0 && x + arrX[i] < N && y + arrY[i] >= 0 && y + arrY[i] < N && map[x + arrX[i]][y + arrY[i]] == 1) {
                map[x + arrX[i]][y + arrY[i]] = 0;
                solution(x + arrX[i], y + arrY[i],N);
            }
    }
}