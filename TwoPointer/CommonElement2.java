package TwoPointer;
import java.util.*;
public class  CommonElement2{
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
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int idx1 = 0;
        int idx2 = 0;
        while(idx1<arr1.length && idx2< arr2.length){
            if (arr1[idx1] < arr2[idx2]) {
                idx1++;
            } else if(arr2[idx2]<arr1[idx1]){
                idx2++;
            }else{
                list.add(arr1[idx1]);
                idx1++;
                idx2++;
            }
        }
        for(int i=0;i<list.size();i++)
            System.out.print(list.get(i)+" ");
    }
}