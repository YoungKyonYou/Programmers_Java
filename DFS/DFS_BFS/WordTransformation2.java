package DFS.DFS_BFS;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
public class WordTransformation2 {
    public static void main(String[] args) throws Exception {
        String[] words={"hot", "dot", "dog", "lot", "log", "cog"};
        String target="cog";
        String begin="hit";
        int ans=solution(begin, target, words);
        System.out.println(ans);
    }
    public static boolean similar(String w1, String w2){
        int cnt=0;
        for(int i=0;i<w1.length();i++){
            if(w1.charAt(i)!=w2.charAt(i))
                cnt++;
        }
        return cnt==1?true:false;
    }
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        List<String> wordsList=new ArrayList<>(Arrays.asList(words));
        Queue<String> Q=new LinkedList<>();
        List<String> tempWords=wordsList;
        Q.add(begin);
        while(true){
            Queue<String> tempQ=new LinkedList<>();
            wordsList=tempWords;
            while(!Q.isEmpty()){
                String word1=Q.poll();
                for(int j=0;j<wordsList.size();j++){
                    String word2=wordsList.get(j);
                    if(similar(word1,word2)){
                        if(word2.equals(target))
                            return answer+1;
                        tempQ.add(word2);
                        tempWords.remove(word2);
                    }
                }
            }
            answer++;
            Q=tempQ;
            if(tempQ.isEmpty())
                return 0;
        }
    }
}