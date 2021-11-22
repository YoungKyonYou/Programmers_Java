package InflearnSorting;
import java.util.*;

public class DuplicationCheck {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int N = sc.nextInt();
        LinkedList<Integer> list=new LinkedList<>();
        System.out.println(solution(list,N));
    }
    public static String solution(LinkedList<Integer> list, int N) {
        for (int i = 0; i < N; i++) {
            Integer temp = sc.nextInt();
            if (list.contains(temp))
                return "D";
            else
                list.add(temp);
        }
        return "U";
    }
}