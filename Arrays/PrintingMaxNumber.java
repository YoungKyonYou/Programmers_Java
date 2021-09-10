package Arrays;
import java.util.*;
public class  PrintingMaxNumber{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();
        solution(arr);
    }

    public static void solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) 
            if (arr[i - 1] < arr[i]) 
                list.add(arr[i]);
        for(int a:list)
            System.out.print(a + " ");
    }
}