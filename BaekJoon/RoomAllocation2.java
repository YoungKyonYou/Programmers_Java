import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class RoomAllocation2 {
    public static class Node {
        public int start;
        public int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int cnt = 0;
        Collections.sort(list, (o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return Integer.compare(o1.end, o2.end);
        });
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (map.containsKey(list.get(i).start)) {
                map.put(list.get(i).end, list.get(i).start);
                continue;
            }
            if (!map.containsKey(list.get(i).end)) {
                map.put(list.get(i).end, list.get(i).start);
                cnt++;
            }
        }
        System.out.println(cnt);
        
    }
}