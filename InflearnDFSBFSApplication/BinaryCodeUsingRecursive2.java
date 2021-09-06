package InflearnDFSBFSApplication;
import java.util.*;


public class BinaryCodeUsingRecursive2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        solution(N);
    }
    public static void solution(int n) {
        if(n==0)
            return;
        else {
            solution(n / 2);
            System.out.print(n % 2);
        }
    }
}