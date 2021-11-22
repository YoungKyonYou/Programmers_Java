package KDigital;
import java.util.*;

public class problem3 {
    
    public static void main(String[] args) throws Exception {
        int n = 9;
        int[][] wires = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } };
        int ans = solution(n, wires);
        System.out.println("final ANSWER:" + ans);
    }
    public static int dfs(List<Integer>[] adj, int[] flag, int v, int num) {
        flag[v] = 1;
        num++;
        for (int a : adj[v]) 
            if (flag[a] == 0) 
                num=dfs(adj, flag, a, num);
        return num;
    }
    public static int solution(int n, int[][] wires) {
        List<Integer>[] adj = new ArrayList[n + 1];
        int answer = 101;
        int v1, v2;
        int[] flag = new int[n + 1];
        for (int i = 0; i < n + 1; i++) 
            adj[i] = new ArrayList<>();
        for (int i = 0; i < wires.length; i++) {
            adj[wires[i][0]].add(wires[i][1]);
            adj[wires[i][1]].add(wires[i][0]);
        }

        for (int i = 0; i < wires.length; i++) {
            int num1 = 0, num2 = 0;

            Integer in1 = wires[i][1];
            Integer in2 = wires[i][0];

            adj[wires[i][0]].remove(in1);
            adj[wires[i][1]].remove(in2);

            v1 = wires[i][0];
            v2 = wires[i][1];

            Arrays.fill(flag, 0);
            num1=dfs(adj, flag, v1, num1);

            Arrays.fill(flag, 0);
            num2=dfs(adj, flag, v2, num2);

            adj[wires[i][0]].add(wires[i][1]);
            adj[wires[i][1]].add(wires[i][0]);

            answer = Math.min(Math.abs(num1 - num2), answer);
        }
        return answer;

    }
}