package Arrays;
import java.util.*;
public class  ReversePrime{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuffer[] arr = new StringBuffer[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            if (max < temp) {
                max = temp;
            }
            arr[i] = new StringBuffer(Integer.toString(temp));
        }
        solution(arr, max);
    }

    public static boolean isPrime(int num) {
        if (num == 1)
            return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void solution(StringBuffer[] arr, int max) {
        int[] arrInt = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrInt[i] = Integer.parseInt(arr[i].reverse().toString());
        }

        for (int i = 0; i < arrInt.length; i++) {
            if (isPrime(arrInt[i])) {
                System.out.print(arrInt[i] + " ");
            }
        }
    }
}