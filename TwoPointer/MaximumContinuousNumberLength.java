package TwoPointer;
import java.util.*;
public class  MaximumContinuousNumberLength{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();
        System.out.println(solution(arr, M));
    }

    public static int solution(int[] arr, int n) {
        int ans = 0;
        int sum = 0;
        int cnt = n;
        int dis = 1;
        int[] map = new int[100001];
        int idx=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1)
                dis++;
            if (arr[i] == 0) {
                map[idx++] = dis;
                dis = 1;   
            }
        }
        idx=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1)
                sum++;
            else if (arr[i] == 0 && cnt > 0) {
                sum++;
                cnt--;
            } else {
                ans=Math.max(ans,sum);
                sum -= map[idx++];
                sum++;
            }
        }
        return ans<sum?sum:ans;
    }
}