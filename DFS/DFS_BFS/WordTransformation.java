package DFS.DFS_BFS;
import java.util.Queue;
import java.util.LinkedList;
public class WordTransformation {
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
    public static String[] erase(String[] words, String target){
        String[] newWords=new String[words.length-1];
        int idx=0;
        for(int i=0;i<words.length;i++){
            if(!words[i].equals(target))
                newWords[idx++]=words[i];
        }
        return newWords;
    }
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<String> Q=new LinkedList<>();
        String[] tempWords=words;
        Q.add(begin);
        while(true){
            Queue<String> tempQ=new LinkedList<>();
            words=tempWords;
            while(!Q.isEmpty()){
                String word1=Q.poll();
                for(int j=0;j<words.length;j++){
                    String word2=words[j];
                    if(similar(word1,word2)){
                        if(word2.equals(target))
                            return answer+1;
                        tempQ.add(word2);
                        tempWords=erase(tempWords, word2);
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