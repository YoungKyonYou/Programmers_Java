
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class AtoB {
    public static int cnt = Integer.MAX_VALUE;

    public static class Node {
        public int count;
        public long value;

        public Node(int count, long value) {
            this.count = count;
            this.value = value;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        System.out.println(bfs(A, B));
        
    }

    public static int bfs(int a, int b) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,a));
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.value == b) {
                cnt = Math.min(cnt, temp.count);
            } else if (temp.value > b) {
                continue;
            }
            queue.add(new Node(temp.count + 1, temp.value * 2));
            queue.add(new Node(temp.count + 1, (temp.value * 10) + 1));

        }
        return cnt==Integer.MAX_VALUE?-1:cnt;
        
    }
}