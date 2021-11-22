import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        int[][] testArr = { { 5, 2, 4, 6, 2 }, { 52, 1, 3, 6, 5 } };

        Arrays.sort(testArr, (o1, o2) -> {
            return o1[0] - o1[1];
        });
        for (int[] a : testArr) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }




    }
}
