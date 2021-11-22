
import java.util.*;

public class MazeEscape {
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        int start = 1;
        int start2 = 1;
        int end = 3;
        int end2 = 4;
        int n = 3;
        int n2 = 4;
        int[][] roads = { { 1, 2, 2 }, { 3, 2, 3 } };
        int[][] roads2 = { { 1, 2, 1 }, { 3, 2, 1 }, { 2, 4, 1} };
        int[] trap = { 2 };
        int[] trap2 = { 2,3 };
        //System.out.println(solution(n, start, end, roads, trap));
        System.out.println(solution(n2, start2, end2, roads2, trap2));

    }

    public static void dfs(int start, int end, int[][] roads, boolean[] trapVisit, int cnt) {
        cnt += roads[start][2];
        if (roads[start][1] == end) {
            ans = Math.min(ans, cnt);
            return;
        }
        if (!trapVisit[roads[start][1]]) {
            for (int i = 0; i < roads.length; i++) {
                if (roads[i][0] == roads[start][1]) {
                    dfs(roads[i][1] - 1, end, roads, trapVisit,cnt+roads[start][2]);       
                }
            }
        } else if (trapVisit[roads[start][1]]) {
            int b = roads[start][1];
            for (int[] a : roads) {
                if (a[1] == b || a[0]==b) {
                    int temp = a[0];
                    a[0] = a[1];
                    a[1] = temp;
                }
            }
            for (int i = start; i < roads.length; i++) {
                if (roads[i][0]==roads[start][0]) {
                    dfs(i, end, roads, trapVisit, cnt);   
                }
            }
        }
    }

    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        boolean[] trapVisit = new boolean[15];
        for (int a : traps) {
            trapVisit[a] = true;
        }
        for (int[] a : roads) {
            if (a[0] == start) {
                int[][] tempArr = new int[roads.length][roads[0].length];
                for (int i = 0; i < roads.length; i++) {
                    for (int j = 0; j < roads[i].length; j++) {
                        tempArr[i][j] = roads[i][j];
                    }
                }
                dfs(a[0] - 1, end, tempArr, trapVisit, 0);
            }
        }
        return ans;

    }
}