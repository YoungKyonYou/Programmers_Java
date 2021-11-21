import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class  FuelStation{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] distance = new long[n - 1];
        long[] station = new long[n];
        long ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            station[i] = Long.parseLong(token.nextToken());
        }
        ans = distance[0] * station[0];
        long comp=station[0];
        for (int i = 1; i < n - 1; i++) {
            if (station[i] < comp) {
                ans += (station[i] * distance[i]);
                comp = station[i];
            } else {
                ans += (comp * distance[i]);
            }
        }
        System.out.println(ans);
    
    }
}