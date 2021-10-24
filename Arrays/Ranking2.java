package Arrays;
import java.util.*;
public class  Ranking2{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        solution(arr);
    }

    public static void solution(int[] arr) {
        Integer[] arrSort = new Integer[arr.length];
        Integer[] arrTemp = new Integer[arr.length];
        Integer[] ans = new Integer[arr.length];
        List<Integer> list = new ArrayList<>();
        int r = 1;
        int num = 0;

        for (int i = 0; i < arr.length; i++) {
            arrSort[i] = arr[i];
            arrTemp[i] = arr[i];
            list.add(arr[i]);
        }
        Arrays.sort(arrSort, Collections.reverseOrder());
        Arrays.sort(arrTemp, Collections.reverseOrder());
        int cnt = 1;

        arrTemp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arrSort[i - 1] == arrSort[i]) {
                cnt++;
                arrTemp[i] = r;
            } else if (cnt != 0) {
                r += cnt;
                arrTemp[i] = r;
                cnt = 1;
            } else 
                r++;
        }
        for (int a : arrSort)
            System.out.printf("%2d ", a);
        System.out.println();
        for (int a : arrTemp)
            System.out.printf("%2d ", a);
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            int idx = list.indexOf(arrSort[i]);
            list.set(idx, -1);
            ans[idx] = arrTemp[i];
            
        }
        for(int a: ans)
            System.out.print(a + " ");
    }
}