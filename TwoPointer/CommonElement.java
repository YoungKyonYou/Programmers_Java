package TwoPointer;
import java.util.*;
public class  CommonElement{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr1 = new int[N];
        for(int i=0;i<N;i++)
            arr1[i] = sc.nextInt();
        int M = sc.nextInt();
        int[] arr2 = new int[M];
        for(int i=0;i<M;i++)
            arr2[i] = sc.nextInt();
        solution(arr1,arr2);
    }
    public static void solution(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) 
            hashMap.put(arr1[i], 1);
        for (int i = 0; i < arr2.length; i++) 
            hashMap.put(arr2[i], hashMap.getOrDefault(arr2[i], 0) + 1);
        for (int a : hashMap.keySet()) 
            if (hashMap.get(a) == 2)
                list.add(a);
        Collections.sort(list);
        for(int i=0;i<list.size();i++)
            System.out.print(list.get(i) + " ");
    }
}