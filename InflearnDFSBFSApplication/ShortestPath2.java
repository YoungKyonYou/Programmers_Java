package InflearnDFSBFSApplication;
import java.util.*;

public class ShortestPath2 {
    static public int[] flag;
    static public int[] distance;
    public static void main(String[] args) throws Exception {
        ArrayList<ArrayList<Integer>> arr = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        flag = new int[N + 1];
        distance = new int[N + 1];
        for(int i=0;i<N+1;i++)
            arr.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            arr.get(v1).add(v2);
        }
        solution(arr);
        System.out.println(Arrays.toString(distance));
    }
    public static void solution(ArrayList<ArrayList<Integer>> arr) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        flag[1] = 1;
        while (!q.isEmpty()) {
            int s = q.poll();
            for (int a : arr.get(s)) {
                if (flag[a] == 0) {
                    flag[a] = 1;
                    distance[a] = distance[s] + 1;
                    q.add(a);
                }
            }
        }
    }
}