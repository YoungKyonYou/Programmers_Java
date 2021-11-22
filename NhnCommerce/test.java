
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class test {
    static public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void test2() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
            arr[j] = Integer.parseInt(token.nextToken());
        }

        System.out.println();
        System.out.print("test:");
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            test2();
        }

    }
    public static void solution() {

    }
}