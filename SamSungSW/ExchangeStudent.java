
import java.util.*;
public class  ExchangeStudent{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int[] days = new int[7];
            int[] dis = new int[7];
            int N = sc.nextInt();
            int idx = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 7; j++) {
                days[j] = sc.nextInt();
            }
            for (int j = 0; j < 7; j++) {
                int c = 1;
                if (days[j] == 0)
                    continue;
                for (int k = 0; k < 7; k++) {
                    if (days[(j + 1 + k) % 7] == 1) {
                        dis[j] = c;
                        break;
                    }
                    c++;
                }
            }

            for (int j = 0; j < 7; j++) {
                if (dis[j] < min && dis[j]!=0) {
                    min = dis[j];
                    idx = j;
                }
            }
            int cnt = 0;
            while (N > 0) {
                if (days[idx % 7] == 1) {
                    N--;
                }
                cnt++;
                idx++;
            }
            System.out.printf("#%d %d\n",i+1,cnt);
        }

    }

}