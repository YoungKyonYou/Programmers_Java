import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Operator {
    public static class Node {
        public int[] operators;
        public int value;
        public int idx;

        public Node(int value, int[] operators, int idx) {
            this.value = value;
            this.operators = operators;
            this.idx = idx;
        }

    }
    public static void main(String[] args) throws Exception {
        Queue<Node> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] operators = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer token=new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(token.nextToken());
        }
        
        int idx = 0;
        queue.add(new Node(arr[idx++], operators, 1));
        
        int min = Integer.MAX_VALUE;
        int max = -Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.idx == N) {
                min = Math.min(node.value, min);
                max = Math.max(node.value, max);
            }
            if(node.idx<N){
                if (node.operators[0] != 0) {
                    node.operators[0] -= 1;
                    int[] temp = new int[4];
                    for (int j = 0; j < 4; j++) {
                        temp[j] = node.operators[j];
                    }
                    queue.add(new Node(node.value + arr[node.idx], temp, node.idx+1));
                    node.operators[0] += 1;
                }
                if(node.operators[1] != 0 ){
                    node.operators[1] -= 1;
                    int[] temp = new int[4];
                    for (int j = 0; j < 4; j++) {
                        temp[j] = node.operators[j];
                    }
                    queue.add(new Node(node.value - arr[node.idx], temp, node.idx+1));
                    node.operators[1] += 1;
                }
                if(node.operators[2] != 0 ){
                    node.operators[2] -= 1;
                    int[] temp = new int[4];
                    for (int j = 0; j < 4; j++) {
                        temp[j] = node.operators[j];
                    }
                    queue.add(new Node(node.value * arr[node.idx], temp, node.idx+1));
                    node.operators[2] += 1;
                }
                if(node.operators[3] != 0 ){
                    node.operators[3] -= 1;
                    int[] temp = new int[4];
                    for (int j = 0; j < 4; j++) {
                        temp[j] = node.operators[j];
                    }
                    queue.add(new Node(node.value / arr[node.idx], temp, node.idx+1));
                    node.operators[3] += 1;

                }
            }
        }
        System.out.println(max);
        System.out.println(min);
        
        

    }

}