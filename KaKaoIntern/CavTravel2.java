package KaKaoIntern;
import java.util.*;
public class CavTravel2 {
    public static void main(String[] args) throws Exception {
        int n=9;
        int[][] path={{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        int[][] order={{8,5},{6,7},{4,1}};
        solution(n,path,order);
    }
    public static void printVisited(boolean[] visited){
        System.out.print("Visited:");
        for(int i=0;i<visited.length;i++){
            if(visited[i])
                System.out.print(1+" ");
            else
                System.out.print(0+" ");
        }
        System.out.println();
    }
    public static boolean solution(int n, int[][] path, int[][] order) {
        ArrayList<Integer>[] adj=new ArrayList[n];
        int[] before=new int[n];
        int[] condition=new int[n];
        boolean[] visited=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++)
            adj[i]=new ArrayList<>();
        for(int i=0;i<path.length;i++){
            adj[path[i][0]].add(path[i][1]);
            adj[path[i][1]].add(path[i][0]);
        }
        for(int i=0;i<order.length;i++)
            before[order[i][1]]=order[i][0];
        if(before[0]!=0)
            return false;
        for(int i=0;i<adj[0].size();i++)
            q.add(adj[0].get(i));
        visited[0]=true;
        while(!q.isEmpty()){
            int a=q.poll();
            if(visited[a])
                continue;
            if(!visited[before[a]]){
                condition[before[a]]=a;
                continue;
            }
            visited[a]=true;
            for(int i:adj[a])
                q.add(i);
            for(int i=0;i<condition.length;i++)
                q.add(condition[i]);
        }
        int cnt=0;
        for(int i=0;i<visited.length;i++){
            if(visited[i])
                cnt++;
        }
        printVisited(visited);
        System.out.println(cnt==n?true:false);
        return cnt==n?true:false;
    }
    
}
