package InflearnStackQueue;
import java.util.*;
public class  EmergencyRoom{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M=sc.nextInt();
        int[] flag=new int[N];
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            flag[i]=i;
            arr[i]=sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    int t = flag[j];
                    flag[j] = flag[j + 1];
                    flag[j + 1] = t;
                }
            }
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == M) {
                System.out.println(i + 1);
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(flag));
    }
    public static void solution() {

    }
}