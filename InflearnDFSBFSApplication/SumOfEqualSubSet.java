package InflearnDFSBFSApplication;
import java.util.*;

public class SumOfEqualSubSet {
    static public int[] flag;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int sum = 0;
        flag=new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];   
        }
    }
    public static void solution() {
        
    }
}