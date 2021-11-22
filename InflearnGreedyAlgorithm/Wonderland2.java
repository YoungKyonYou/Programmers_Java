package InflearnGreedyAlgorithm;
import java.util.*;

public class Wonderland2 {
    public static class Edge {
        int v2;
        int w;
        public Edge(int v2, int w) {
            this.v2 = v2;
            this.w = w;
        }
    }

    // static public List<List<Edge>> arr;
    static public List<List<Edge>> arr;
    static public PriorityQueue<Edge> pq;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] node = new int[N+1];
        pq = new PriorityQueue<>((o1, o2) -> {
            return o1.w - o2.w;
        });
        int answer = 0;
        arr= new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) 
            arr.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();
            arr.get(v1).add(new Edge(v2, w));
            arr.get(v2).add(new Edge(v1, w));
        }
        for (int i = 0; i < arr.get(1).size(); i++)
            pq.add(arr.get(1).get(i));
        int tv1 = 1;
        node[1] = 1;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            tv1 = e.v2;
            if (node[e.v2]==0) {
                node[e.v2] = e.v2;
                answer += e.w;
            }
            for (int j = 0; j < arr.get(e.v2).size(); j++) {
                if(node[arr.get(e.v2).get(j).v2]==0)
                    pq.add(arr.get(e.v2).get(j));
            }
        }
        System.out.println(solution(answer));
    }
    public static int solution(int ans) {
        return ans;
    }
}