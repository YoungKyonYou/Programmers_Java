
import java.util.*;
public class  MaximumNumber{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int[] arr = new int[10];
            for (int j = 0; j < 10; j++) {
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.println("#"+(i+1)+" "+arr[arr.length - 1]);
        }
    }
    
}