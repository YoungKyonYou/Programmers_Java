package DFS.DFS_BFS;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class TravelPath {
  
    public static void main(String[] args) throws Exception {
        String[][] tickets={{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
        solution(tickets);
    }
    public static void printString(List<String[]> answer){
        for(String[] s: answer){
            System.out.print("{"+s[0]+","+s[1]+"}"+" ");
        }
    }
    public static List<String[]> dfs(String[][] tickets, int[] flag, int n,int v, List<String[]> answer){
        flag[v]=1;
        answer.add(tickets[v]);
        System.out.println(Arrays.toString(flag));
        printString(answer);
        if(answer.size()==n)
            return answer;
        for(int i=0;i<tickets.length;i++){
            if(flag[i]==0 && tickets[v][1].equals(tickets[i][0])){
                dfs(tickets,flag, n, i, answer);
                if(answer.size()!=n){
                    flag[i]=0;
                    answer.remove(answer.size()-1);
                }
            }
        }
        return answer;
    } 
    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        answer=new String[tickets.length+1];
        System.out.println();

        Arrays.sort(tickets,(o1, o2)->{
            if(o1[0].equals(o2[0])){
                return o1[1].compareTo(o2[1]);
            }else{
                return o1[0].compareTo(o2[0]);
            }
        });
        
        for(String[] s:tickets){
            System.out.print("{"+s[0]+","+s[1]+"}"+" ");
        }
        
        for(int i=0;i<tickets.length;i++){
            if(tickets[i][0].equals("ICN")){
                int[] flag=new int[tickets.length];
                List<String[]> ans=new ArrayList<>();
                ans=dfs(tickets,flag,tickets.length,i,ans);
                System.out.println();
                System.out.println();
                System.out.print("ans:");
                for(String[] s:ans){
                    System.out.print("{"+s[0]+","+s[1]+"}"+" ");
                }
                if(ans.size()==tickets.length){
                    answer[0]=ans.get(0)[0];
                    answer[1]=ans.get(0)[1];
                    for(int j=1;j<ans.size();j++)
                        answer[j+1]=ans.get(j)[1];
                return answer;
                }
            }
        }       
        return answer;
    }
}