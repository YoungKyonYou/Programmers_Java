package KaKaoCode;
import java.util.*;

public class TakingGroupPhoto {
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        String[] data = { "N~F=0", "R~T>2" };
        int n = 2;
        int ans = solution(n, data);
        System.out.println("FINAL ANSWER:" + ans);

    }

    static void numberCases(String s, String[] data) {
        int flag = 0;

        for (int i = 0; i < data.length; i++) {
            char n1 = data[i].charAt(0);
            char n2 = data[i].charAt(2);
            char op = data[i].charAt(3);
            int d = Character.getNumericValue(data[i].charAt(4));
            if (op=='=' && Math.abs(s.indexOf(n1) - s.indexOf(n2)) == 1) {
                flag++;
            } else if (op=='<' && Math.abs(s.indexOf(n1) - s.indexOf(n2)) <= d - 1) {
                flag++;
            } else if (op=='>' && Math.abs(s.indexOf(n1) - s.indexOf(n2)) >= d + 2) {
                flag++;
            }
        }
        if (flag == data.length) {
            answer++;
        }
    }
    static int permutation(String[] arr, int depth, int n, int r, String[] data) {
        if (depth == r) {
            String s = "";
            for (int i = 0; i < 8; i++)
                s += arr[i];
            numberCases(s, data);
            return answer;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r, data);
            swap(arr, depth, i);
        }
        return answer;
    }

    static void swap(String[] arr, int depth, int i) {
        String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    public static int solution(int n, String[] data) {
        answer = 0;
        String[] p = { "A", "C", "F", "J", "M", "N", "R", "T" };
        permutation(p, 0, 8, 8,data);
        return answer;
    }
}