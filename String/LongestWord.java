
import java.util.*;
public class  LongestWord{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        System.out.println(solution(N));
        
    }

    public static String solution(String N) {
        String ans = "";
        N += " ";
        int idx = 0;
        int preIdx=0;
        int max = 0;
        String str="";
        while (true) {
            idx = N.indexOf(" ", idx);
            if (idx == -1) 
                break;
            str=N.substring(preIdx, idx);
            if (max < str.length()) {
                max = str.length();
                ans = str;
            }
            idx++;
            preIdx = idx;
        }
        return ans;
    }
}