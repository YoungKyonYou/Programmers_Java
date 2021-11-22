
import java.util.*;
public class  ReverseWord{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] arr = new String[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.next();
        }
        String[] ans = solution(arr);
        for (String s : ans) {
            System.out.println(s);
        }
        
    }

    public static String[] solution(String[] N) {
        String[] ans = new String[N.length];
        for (int i = 0; i < N.length; i++)
            ans[i] = "";
        for (int i=0;i<N.length;i++) 
            for (int j=0;j<N[i].length();j++) 
                ans[i] = Character.toString(N[i].charAt(j))+ans[i];
        return ans;
    }
}