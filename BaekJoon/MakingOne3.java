
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class MakingOne3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(dfs(N, 0));
    }

    public static int dfs(int n, int cnt){
        if (n < 2) {
            return cnt;
        }
        
        return Math.min(dfs(n / 2, cnt + (n % 2) + 1), dfs(n / 3, cnt + (n % 3) + 1));
    }
}


