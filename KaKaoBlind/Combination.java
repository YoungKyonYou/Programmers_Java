
import java.util.*;

public class Combination {
    static int[] comb = new int[2];
    static int n, m;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = 4;
        m = 2;
        solution(0, 1);
    }

    public static void solution(int L, int s) {
        if (L == m) {
            for (int a : comb) {
                System.out.print(a + " ");
            }
            System.out.println();
        } else {
            for (int i = s; i <= n; i++) {
                comb[L] = i;
                solution(L + 1, i+1);
            }
        }
    }
}