
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class AddingOneTwoThree {
    public static int count = 0;
    public static int N;
    public static int target;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            target = Integer.parseInt(br.readLine());
            dfs(0);
            System.out.println(count);
            count = 0;
        }
    }

    public static void dfs(int num) {
        if (num == target) {
            count++;
            return;
        } else if (num > target) {
            return;
        }
        dfs(num + 1);
        dfs(num + 2);
        dfs(num + 3);
    }
}