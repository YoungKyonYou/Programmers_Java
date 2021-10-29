package Arrays;
import java.util.*;


public class  RockScissorPaper{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arrA = new int[N];
        int[] arrB = new int[N];
        for (int i = 0; i < N; i++) {
            arrA[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            arrB[i] = sc.nextInt();
        }
        solution(arrA, arrB);
    }
    public static void solution(int[] arrA, int[] arrB) {
        for (int i = 0; i < arrA.length; i++) {
            if ((arrA[i]==1 && arrB[i]==3) || (arrA[i]==2 && arrB[i]==1) || (arrA[i]==3 && arrB[i]==2)) 
                System.out.println("A");
            else if((arrB[i] == 1 && arrA[i] == 3) || (arrB[i] == 2 && arrA[i] == 1) || (arrB[i] == 3 && arrA[i] == 2))
                System.out.println("B");
            else
                System.out.println("D");
        }
    }
}