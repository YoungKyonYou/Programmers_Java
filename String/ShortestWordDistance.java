import java.util.*;

public class ShortestWordDistance {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String c = sc.next();
        int[] arr = new int[str.length()];
        solution(str, c, arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }

    }

    public static int[] solution(String str, String c, int[] arr) {
        int preIdx = str.indexOf(c);
        int idx = preIdx;
        for (int i = 0; i < str.length(); i++) {
            idx = str.indexOf(c,idx);
            int cnt = Math.min(Math.abs(idx - i),Math.abs(preIdx - i));
            arr[i] = cnt;
            if (i == idx) {
                preIdx = idx;
                idx++;
            }
        }
        return arr;
    }
}