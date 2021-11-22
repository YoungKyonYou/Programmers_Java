package InflearnGreedyAlgorithm;

import java.util.*;

public class Wonderland {
    public static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int w;

        public Edge(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {

            return this.w - o.w;
        }
    }

    // static public List<List<Edge>> arr;
    static public List<Edge> arr;
    static public int[] root;

    public static int find(int v2) {
        if (root[v2] == v2)
            return v2;
        return root[v2] = find(root[v2]);
    }

    public static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x != y)
            root[y] = x;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int answer = 0;
        root = new int[N + 1];
        for (int i = 1; i < N + 1; i++)
            root[i] = i;
        arr = new ArrayList<>(M - 1);
        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Edge(v1, v2, w));
        }
        Collections.sort(arr);
        for (int i = 0; i < M; i++) {
            int a = find(arr.get(i).v1);
            int b = find(arr.get(i).v2);
            if (a != b) {
                union(a, b);
                answer += arr.get(i).w;
            }
        }
        System.out.println(solution(answer));
    }

    public static int solution(int ans) {
        return ans;
    }
}