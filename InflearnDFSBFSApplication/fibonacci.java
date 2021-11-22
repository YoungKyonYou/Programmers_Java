package InflearnDFSBFSApplication;
import java.util.*;

public class fibonacci {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N+1];
        solution(N);
        System.out.println(Arrays.toString(arr));
    }

    public static int solution(int n) {
        if (n == 1 || n == 2)
            return arr[n]=1;
        else {
            return arr[n]=solution(n - 2) + solution(n - 1);
        }
    }
}