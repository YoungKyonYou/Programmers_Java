package InflearnDFSBFSApplication;
import java.util.*;

public class MazeSearch {
    public static int[][] map = new int[7][7];
    public static int ans = 0;
    public static int[] arrX={0,0,1,-1};
    public static int[] arrY = { 1, -1, 0, 0 };
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 7; i++) 
            for (int j = 0; j < 7; j++) 
                map[i][j] = sc.nextInt();
        map[1][0] = 1;
        System.out.println(solution(1, 0));
    }
    public static int solution(int x, int y) {
        if (x == 6 && y == 6) 
            ans++;
        for (int i = 0; i < 4; i++) 
            if (x + arrX[i] >= 0 && y + arrY[i] >= 0 &&x+arrX[i]<7 && y+arrY[i]<7 && map[x + arrX[i]][y + arrY[i]] == 0) {
                map[x + arrX[i]][y + arrY[i]] = 3;
                solution(x + arrX[i], y + arrY[i]);
                map[x + arrX[i]][y + arrY[i]] = 0;
            }
        return ans;
    }
}