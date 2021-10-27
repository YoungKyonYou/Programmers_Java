package Arrays;
import java.util.*;
public class  ReversePrime2{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        solution(arr);
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
    public static void solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb=new StringBuilder(Integer.toString(arr[i]));
            if (isPrime(Integer.parseInt(sb.reverse().toString()))) {
                System.out.print(Integer.parseInt(sb.toString())+ " ");
            }
        }
    }
}