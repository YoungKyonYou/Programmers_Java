
import java.util.*;
public class  ExchangeStudent2{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int i = 0; i < T; i++) {
            List<Integer> list = new ArrayList<>();
            int[] days = new int[7];
            int[] dis = new int[7];
            int N = sc.nextInt();
            for (int j = 0; j < 7; j++) {
                days[j] = sc.nextInt();
            }
            for (int j = 0; j < 7; j++) {
                int temp = N;
                int cnt = 0;
                int idx = j;
                while (temp > 0) {
                    if (days[idx % 7] == 1) {
                        temp--;
                    }
                    cnt++;
                    idx++;
                }
                list.add(cnt);
            }
            Collections.sort(list);
            

            System.out.printf("#%d %d\n",i+1,list.get(0));
        }

    }

}