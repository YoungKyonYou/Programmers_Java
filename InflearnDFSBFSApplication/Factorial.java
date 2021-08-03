package InflearnDFSBFSApplication;
import java.util.*;
public class  Factorial{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = solution(N);
        System.out.println(a);
    }

    public static int solution(int n) {
        if (n == 1)
            return 1;
        return n * solution(n - 1);
    }
}