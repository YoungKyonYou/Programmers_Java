package KaKaoIntern;
import java.util.*;
public class CaveTravel {
    public static int[] before;
    public static int[] savePoint;
    public static ArrayList<ArrayList<Integer>> map;
    public static boolean[] visited;
    public static void main(String[] args) throws Exception {
        int n=9;
        int[][] path={{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        int[][] order={{8,5},{6,7},{4,1}};
        solution(n,path,order);
    }
    public static boolean solution(int n, int[][] path, int[][] order) {
        map = new ArrayList<ArrayList<Integer>>();
        before = new int[n];
        savePoint = new int[n];
        visited = new boolean[n];
 
        for (int i = 0; i < n; i++) { //
            map.add(new ArrayList<Integer>());
        }
 
        for (int i = 0; i < path.length; i++) { // 그래프 생성
            map.get(path[i][0]).add(path[i][1]);
            map.get(path[i][1]).add(path[i][0]);
        }
 
        for (int i = 0; i < order.length; i++) { // 탐험 순서 저장
            before[order[i][1]] = order[i][0];
        }
        
        if(before[0] != 0) {                     //0이 먼저 들려야하는 정점이 있다면 false
            return false;
        }
        
        System.out.print("before: ");
        for(int i=0;i<before.length;i++)
            System.out.print(before[i]+" ");
        System.out.println();



        visited[0] = true;
        Queue<Integer> q = new LinkedList<>();
        System.out.print("Starting Point:");
        for(int i : map.get(0)) {
            q.add(i);
            System.out.print(i+" ");
        }
        System.out.println();
        while (!q.isEmpty()) {
            int e = q.remove();

            System.out.print("visit:");
            for(int i=0;i<visited.length;i++)
                System.out.print(visited[i]+" ");
            System.out.println();
            if (visited[e]) {
                continue;
            }
 
            if (!visited[before[e]]) {
                savePoint[before[e]] = e;
                System.out.print("savePoint:");
                for(int i=0;i<n;i++)
                    System.out.print(savePoint[i]+" ");
                System.out.println();
                continue;
            }
 
            visited[e] = true;
            for (int i : map.get(e)) {
                q.add(i);
            }
 
            q.add(savePoint[e]);
        }
 
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
 
        return true;
    }
}
