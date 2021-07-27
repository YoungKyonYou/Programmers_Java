package DFS.DFS_BFS;
public class Network {
    public void dfs(int n, int v, int[][] computers, int[] flag){
        for(int i=0;i<n;i++){
            if(computers[v][i]==1 && flag[i]==0){
                flag[i]=1;
                dfs(n,i,computers,flag);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] flag=new int[n];
        for(int i=0;i<n;i++){
            if(flag[i]==0){
                flag[i]=1;
                dfs(n,i,computers,flag);
                answer++;
            }
        }
        return answer;
    }
}