package TwoPointer;

import java.util.*;

public class ContinuousSequence {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        System.out.println(solution(arr, M));
    }

    public static int solution(int[] arr, int n) {
        int sum = 0;
        int ans = 0;
        int l = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == n)
                ans++;
            while (sum > n) {
                sum -= arr[l];
                l++;
                if (sum == n)
                    ans++;
            }
        }
        return ans;
    }
}