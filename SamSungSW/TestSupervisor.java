
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;
public class  TestSupervisor{
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        int[] supervisor = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());   
        for (int i = 0; i < N; i++) {
           arr[i]=Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2; i++) {
            supervisor[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(arr, supervisor));

    }

    public static long solution(long[] arr, int[] supervisor) {
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans++;
            arr[i]= arr[i]- supervisor[0];
            if (arr[i] < 0) {
                continue;
            } else {
                ans += Math.ceil((double) arr[i] / supervisor[1]);
            }
        }
        return ans;
    }
}