import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class LazyKingdom {
    public static class Node {
        public Long a;
        public Long b;

        public Node(Long a, Long b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            Set<Long> set = new HashSet<>();
            HashMap<Long, Long> map = new HashMap<>();
           // StringTokenizer st = new StringTokenizer(br.readLine());
            List<Node> nodeList = new ArrayList<>();
            // int N = Integer.parseInt(st.nextToken());
            int N = sc.nextInt();
            int K = sc.nextInt();
           // int K = Integer.parseInt(st.nextToken());
            Long[][] arr = new Long[2][N];
            for (int j = 0; j < 2; j++) {
               //StringTokenizer token = new StringTokenizer(br.readLine());
                for (int r = 0; r < N; r++) {
                   // arr[j][r] = Integer.parseInt(token.nextToken());
                    arr[j][r] = sc.nextLong();
                    if (j == 0) {
                        map.put(arr[j][r], map.getOrDefault(arr[j][r], 0L) + 1);
                        set.add(arr[j][r]);
                    }
                }
            }
            for (int j = 0; j < N; j++) {
                nodeList.add(new Node(arr[0][j], arr[1][j]));
            }
            Collections.sort(nodeList, (o1, o2) -> {
                return o1.b.intValue() - o2.b.intValue();
            });


            int ans = 0;
            int cnt = set.size();
            if (cnt >= K) {
                System.out.printf("#%d %d\n", i + 1, ans);
                continue;
            }
            for (int j = 0; j < nodeList.size(); j++) {
                if (map.containsKey(nodeList.get(j).a) && map.get(nodeList.get(j).a) > 1 && cnt != K) {
                    map.put(nodeList.get(j).a, map.get(nodeList.get(j).a)-1);
                    ans += nodeList.get(j).b;
                    cnt++;
                }
            }
            System.out.printf("#%d %d\n",i+1,ans);
        }
        

    }

}
