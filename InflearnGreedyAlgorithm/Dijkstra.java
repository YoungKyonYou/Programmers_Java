package InflearnGreedyAlgorithm;
import java.util.*;
public class Dijkstra {
    public static class Graph {
        int v2;
        int w;
        public Graph(int v2, int w) {
            this.v2 = v2;
            this.w = w;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] d = new int[N+1];
        int INF = Integer.MAX_VALUE;

        for(int i=0;i<d.length;i++)
            d[i] = INF;

        List<List<Graph>> arr = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            arr.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();
            Graph g = new Graph(v2, w);
            arr.get(v1).add(g);
        }
        solution(arr, d,1);
    }
    public static void solution(List<List<Graph>> arr, int[] d, int start) {
        PriorityQueue<Graph> pq=new PriorityQueue<>((o1,o2)->{
            return o1.w-o2.w;
        });
        pq.add(new Graph(1, 0));
        d[start] = 0;
        while (!pq.isEmpty()) { 
            Graph g = pq.poll();
            int current = g.v2;
            int distance = g.w;
            if (d[current] < distance)
                continue;
            for (int i = 0; i < arr.get(current).size(); i++) {
                int next = arr.get(current).get(i).v2;
                int nextDistance = distance + arr.get(current).get(i).w;
                if (nextDistance < d[next]) {
                    d[next] = nextDistance;
                    pq.add(new Graph(next, nextDistance));
                }
            }
        }
        System.out.println(Arrays.toString(d));
    }
}