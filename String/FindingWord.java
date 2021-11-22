
import java.util.*;
public class  FindingWord{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        char c = sc.next().charAt(0);
        System.out.println(solution(N, c));
        
    }

    public static int solution(String N, char c) {
        int ans = 0;
        int idx = 0;
        char cc = Character.toLowerCase(c);
        N = N.toLowerCase();
        while (true) {
            idx = N.indexOf(cc, idx);
            if (idx == -1)
                break;
            idx += 1;
            ans++;
        }
        return ans;
    }
}