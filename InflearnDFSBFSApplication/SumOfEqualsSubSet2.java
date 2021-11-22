package InflearnDFSBFSApplication;
import java.util.*;

public class SumOfEqualsSubSet2 {
    static public String ans = "NO";
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        dfs(arr, sum, 0, 0);
        System.out.println(ans);
    }
    public static void dfs(int[] arr, int sum, int target, int s) {
        if (ans.equals("YES"))
            return;
        if (sum == target)
            ans="YES";
        for (int i = s; i < arr.length; i++) 
            dfs(arr, sum - arr[i], target + arr[i], i+1);
    }
}