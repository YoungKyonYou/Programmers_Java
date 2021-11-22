import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TestSupervisor2 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st, st2;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        int curN = Integer.parseInt(st2.nextToken());
        int curN2 = Integer.parseInt(st2.nextToken());
        long sum = 0;
        int temp;
        for (int i = 0; i < N; i++) {
            temp = (Integer.parseInt(st.nextToken()) - curN);
            sum++;
            if (temp > 0) {
                int tt = temp + (curN2 - 1);
                sum += tt/ curN2;
            }
        }
        System.out.println(sum);
    }
}
