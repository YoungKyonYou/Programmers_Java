package Arrays;
import java.util.*;
public class  Fibbonachi{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
    
        arr = solution(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
    public static int[] solution(int[] arr) {
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 1; i < arr.length - 1; i++) 
            arr[i + 1] = arr[i - 1] + arr[i];
        return arr;
    }
}